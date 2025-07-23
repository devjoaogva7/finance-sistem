package com.um_sushi.Um_Sushi.domain.service;

import com.um_sushi.Um_Sushi.domain.model.*;
import com.um_sushi.Um_Sushi.domain.model.enums.EnumConfirmacaoPagamento;
import com.um_sushi.Um_Sushi.domain.model.enums.EnumStatus;
import com.um_sushi.Um_Sushi.domain.service.validacao.ProcessadorPagamento;
import com.um_sushi.Um_Sushi.domain.service.validacao.impl.ProcessadorCartaoCredito;
import com.um_sushi.Um_Sushi.domain.service.validacao.impl.ProcessadorCartaoDebito;
import com.um_sushi.Um_Sushi.port.input.AlterarClienteUserCase;
import com.um_sushi.Um_Sushi.port.input.FinalizarPagamentoUserCase;
import com.um_sushi.Um_Sushi.port.input.ProcessarPagamentoUserCase;
import com.um_sushi.Um_Sushi.port.input.SalvarCartaoUserCase;
import com.um_sushi.Um_Sushi.port.output.ConsultarClientePort;
import com.um_sushi.Um_Sushi.port.output.ConsultarEstabelecimentoPort;
import com.um_sushi.Um_Sushi.port.output.ConsultarPagamentoPort;
import com.um_sushi.Um_Sushi.port.output.ProcessarPagamentoPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

import static com.um_sushi.Um_Sushi.domain.model.enums.EnumFormaPagamento.*;

@Service
@RequiredArgsConstructor
public class PagamentoService implements SalvarCartaoUserCase, ProcessarPagamentoUserCase, FinalizarPagamentoUserCase {

    private final ConsultarClientePort consultarClientePort;
    private final AlterarClienteUserCase alterarClienteUserCase;
    private final ProcessarPagamentoPort processarPagamentoPort;
    private final ConsultarEstabelecimentoPort consultarEstabelecimentoPort;
    private final ConsultarPagamentoPort consultarPagamentoPort;

    @Override
    @Transactional
    public void salvarCartao(Cartao request) {
        consultarClientePort.buscarPorCpf(request.getCpf()).ifPresentOrElse(cliente -> {
            if (cliente.getCartao() == null || cliente.getCartao().getNumero() == null) {
                alterarClienteUserCase.alterarCartao(cliente, request);
            } else {
                throw new IllegalArgumentException("Você ja possui um cartão cadastrado");
            }
        }, () -> {
            throw new IllegalArgumentException(("Cliente com CPF " + request.getCpf() + " não encontrado."));
        });
    }

    @Override
    @Transactional
    public String processarPagamento(ProcessarPagamento request) {
        if (request.getFormaPagamento().equals(CREDITO) && request.getParcelas() == null) {
            throw new IllegalArgumentException("Forma de pagamento CREDITO precisa de parcelas definidas.");
        } else if (request.getFormaPagamento().equals(DEBITO)
                || request.getFormaPagamento().equals(PIX) && request.getParcelas() == null) {
            request.setParcelas(1);
        }

        Optional<Cliente> cliente = consultarClientePort.buscarPorCpf(request.getCpf());

        Estabelecimento estabelecimento = consultarEstabelecimentoPort.buscarDadosEstabelicentoPorId().orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));
        Pedido pedido = consultarEstabelecimentoPort.buscarPedidoPorCpfCliente(cliente.get().getCpf()).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        Frete frete = consultarEstabelecimentoPort.buscarFretePorId().orElseThrow(() -> new RuntimeException("Frete não encontrado"));

        BigDecimal valorTotal = calcularValorTotalPedido(pedido.getValor(), frete.getPreco());

        return processarPagamentoPort.salvar(request, valorTotal, cliente.orElse(null), estabelecimento, frete, pedido);
    }

    @Override
    public String finalizarPagamento(FinalizarPagamento request) {
        Pagamento pagamento = this.consultarPeloId(request.getIdPagamento());
        Estabelecimento estabelecimento = consultarEstabelecimentoPort.buscarDadosEstabelicentoPorId().orElseThrow();

        if (request.getConfirmacao() == EnumConfirmacaoPagamento.SIM) {

            ProcessadorPagamento processador;

            if (pagamento.getFormaPagamento() == null) {
                throw new IllegalStateException("Forma de pagamento não cadastrada para o pagamento.");
            }

            switch (pagamento.getFormaPagamento()) {
                case "CREDITO":
                    processador = new ProcessadorCartaoCredito();
                    break;
                case "DEBITO":
                    processador = new ProcessadorCartaoDebito();
                    break;
                case "PIX":
                    return estabelecimento.getPixCopiaCola();
                default:
                    throw new IllegalArgumentException("Forma de pagamento não suportada.");
            }

            processador.processar(pagamento);
            pagamento.setStatus(EnumStatus.APROVADO.getDescricao());

        } else if (request.getConfirmacao() == EnumConfirmacaoPagamento.NAO) {
            pagamento.setStatus(EnumStatus.CANCELADO.getDescricao());
        }

        Pagamento pFinalizado = processarPagamentoPort
                .alterarPagamento(pagamento).orElseThrow(() -> new RuntimeException("Erro no pagamento."));
        return pFinalizado.comprovante();

    }

    public Pagamento consultarPeloId(Long id){
        return consultarPagamentoPort.consultarPeloId(id).orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com o ID: " + id));
    }

    //FUNCOES PRIVADAS
    private BigDecimal calcularValorTotalPedido(BigDecimal valorPedido, BigDecimal valorFrete) {
        BigDecimal valor = valorPedido.add(valorFrete);
        return valor;
    }
}
