package com.um_sushi.Um_Sushi.domain.service;

import com.um_sushi.Um_Sushi.domain.model.*;
import com.um_sushi.Um_Sushi.domain.model.enums.EnumFormaPagamento;
import com.um_sushi.Um_Sushi.port.input.AlterarClienteUserCase;
import com.um_sushi.Um_Sushi.port.input.FinalizarPagamentoUserCase;
import com.um_sushi.Um_Sushi.port.input.ProcessarPagamentoUserCase;
import com.um_sushi.Um_Sushi.port.input.SalvarCartaoUserCase;
import com.um_sushi.Um_Sushi.port.output.ConsultarClientePort;
import com.um_sushi.Um_Sushi.port.output.ConsultarEstabelecimentoPort;
import com.um_sushi.Um_Sushi.port.output.ProcessarPagamentoPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PagamentoService implements SalvarCartaoUserCase, ProcessarPagamentoUserCase, FinalizarPagamentoUserCase {

    private static final Long ID_ESTABELECIMENTO = 15576315825589L;
    private static final Long ID_FRETE_VALOR_UNICO = 1L;

    private final ConsultarClientePort consultarClientePort;
    private final AlterarClienteUserCase alterarClienteUserCase;
    private final ProcessarPagamentoPort processarPagamentoPort;
    private final ConsultarEstabelecimentoPort consultarEstabelecimentoPort;

    @Override
    @Transactional
    public void salvar(Cartao request) {
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
    public String processarPagamento(ProcessarPagamento request) {
        if (request.getFormaPagamento().equals(EnumFormaPagamento.CREDITO) && request.getParcelas() == null) {
            throw new IllegalArgumentException("Forma de pagamento CREDITO precisa de parcelas definidas.");
        } else if (request.getFormaPagamento().equals(EnumFormaPagamento.DEBITO)
                || request.getFormaPagamento().equals(EnumFormaPagamento.PIX) && request.getParcelas() == null) {
            request.setParcelas(1);
        }

        Cliente cliente = consultarClientePort.buscarPorCpf(request.getCpf())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com CPF: " + request.getCpf()));

        Estabelecimento estabelecimento = consultarEstabelecimentoPort.buscarDadosEstabelicentoPorId(ID_ESTABELECIMENTO);
        Pedido pedido = consultarEstabelecimentoPort.buscarPedidoPorCpfCliente(cliente.getCpf());
        Frete frete = consultarEstabelecimentoPort.buscarFretePorId(ID_FRETE_VALOR_UNICO);

        BigDecimal valorTotal = calcularValorTotalPedido(pedido.getProdutos(), frete.getPreco());

        return processarPagamentoPort.salvar(request, valorTotal, cliente, estabelecimento, frete, pedido);
    }

    private BigDecimal calcularValorTotalPedido(List<Pedido.Produto> produtos, BigDecimal frete) {
        BigDecimal valor = BigDecimal.ZERO;

        for (Pedido.Produto produto : produtos) {
            valor = valor.add(produto.getPreco().multiply(BigDecimal.valueOf(produto.getQuantidade()))).add(frete);
        }

        return valor;
    }

    //TODO adequuar a função para o tipo de pagamento se for pix deve mostra o QRcode no response, se for credito ou debito deve validar o CVV do cartao ajustar a request para aceitar o CVV
    @Override
    public String finalizarPagamento(FinalizarPagamento request) {
//        PagamentoCredito pagamentoCredito = new PagamentoCredito();
//        PagamentoDebito pagamentoDebito = new PagamentoDebito();
//        PagamentoPix pagamentoPix = new PagamentoPix();
//
//        PagamentoEntity pagamento = pagamentoRepository.findById(request.getIdPagamento())
//                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com o ID: " + request.getIdPagamento()));
//
//        if (request.getConfirmacao() == EnumConfirmacaoPagamento.SIM) {
//
//            if (pagamento.getFormaPagamento().equals(EnumFormaPagamento.CREDITO.getDescricao())) {
//                pagamentoCredito.processar(pagamento);
//            } else if (pagamento.getFormaPagamento().equals(EnumFormaPagamento.DEBITO.getDescricao())) {
//                pagamentoDebito.processar(pagamento);
//            } else if (pagamento.getFormaPagamento().equals(EnumFormaPagamento.PIX.getDescricao())) {
//                pagamentoPix.processar(pagamento);
//            }
//
//            pagamento.setStatus(EnumStatus.APROVADO.getDescricao());
//
//        } else if (request.getConfirmacao() == EnumConfirmacaoPagamento.NAO) {
//            pagamento.setStatus(EnumStatus.CANCELADO.getDescricao());
//        }
//
//        var pFinalizado = pagamentoRepository.save(pagamento);
//
//        return pFinalizado.comprovante();
        return  null;
    }
}
