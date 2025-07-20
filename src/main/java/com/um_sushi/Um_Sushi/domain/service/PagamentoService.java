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
import java.util.Optional;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PagamentoService implements SalvarCartaoUserCase, ProcessarPagamentoUserCase, FinalizarPagamentoUserCase {

    private static final Long ID_ESTABELECIMENTO = 15576315825589L;
    private static final Long ID_FRETE_VALOR_UNICO = 1L;

    private final ConsultarClientePort consultarClientePort;
    private final AlterarClienteUserCase alterarClienteUserCase;
    private final ProcessarPagamentoPort processarPagamentoPort;
    private final ConsultarEstabelecimentoPort consultarEstabelecimentoPort;
    private final PagamentoRepository pagamentoRepository;

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
    @Transactional
    public String processarPagamento(ProcessarPagamento request) {
        if (request.getFormaPagamento().equals(EnumFormaPagamento.CREDITO) && request.getParcelas() == null) {
            throw new IllegalArgumentException("Forma de pagamento CREDITO precisa de parcelas definidas.");
        } else if (request.getFormaPagamento().equals(EnumFormaPagamento.DEBITO)
                || request.getFormaPagamento().equals(EnumFormaPagamento.PIX) && request.getParcelas() == null) {
            request.setParcelas(1);
        }

        Optional<Cliente> cliente = consultarClientePort.buscarPorCpf(request.getCpf());

        Estabelecimento estabelecimento = consultarEstabelecimentoPort.buscarDadosEstabelicentoPorId(ID_ESTABELECIMENTO)
                .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));
        Pedido pedido = consultarEstabelecimentoPort.buscarPedidoPorCpfCliente(cliente.get().getCpf())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        Frete frete = consultarEstabelecimentoPort.buscarFretePorId(ID_FRETE_VALOR_UNICO)
                .orElseThrow(() -> new RuntimeException("Frete não encontrado"));

        BigDecimal valorTotal = calcularValorTotalPedido(pedido.getValor(), frete.getPreco());

        return processarPagamentoPort.salvar(request, valorTotal, cliente.orElse(null), estabelecimento, frete, pedido);
    }

    @Override
    @Transactional
    public String finalizarPagamento(FinalizarPagamento request) {
        PagamentoEntity pagamento = pagamentoRepository.findById(request.getIdPagamento())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Pagamento não encontrado com o ID: " + request.getIdPagamento()));

        if (request.getConfirmacao() == EnumConfirmacaoPagamento.SIM) {
            // Lógica de processamento de pagamento por tipo (simulada)
            // Em um cenário real, isso envolveria gateways de pagamento externos para
            // segurança e processamento real.
            if (pagamento.getFormaPagamento().equals(EnumFormaPagamento.CREDITO.getDescricao())) {
                // Exemplo de validação de CVV (se CVV estivesse na requisição e não armazenado
                // permanentemente)
                // if (request.getCvv() == null ||
                // !request.getCvv().equals(pagamento.getCartao().getCvv())) throw new
                // IllegalArgumentException("CVV inválido");
                // Para este exemplo, apenas simula aprovação
                System.out.println("Processando pagamento de CRÉDITO para ID: " + pagamento.getId());
                // Chamar lógica de integração com gateway de crédito aqui
            } else if (pagamento.getFormaPagamento().equals(EnumFormaPagamento.DEBITO.getDescricao())) {
                // Lógica de débito
                System.out.println("Processando pagamento de DÉBITO para ID: " + pagamento.getId());
                // Chamar lógica de integração com gateway de débito aqui
            } else if (pagamento.getFormaPagamento().equals(EnumFormaPagamento.PIX.getDescricao())) {
                // Lógica de PIX (gerar QR code ou confirmar pagamento externo)
                System.out.println("Processando pagamento PIX para ID: " + pagamento.getId());
                // Chamar lógica para confirmar PIX (ex: consulta status da transação no banco)
                // Se a confirmação fosse para gerar o QR Code, essa lógica estaria no método
                // 'processarPagamento'
            }
            pagamento.setStatus(EnumStatus.APROVADO.getDescricao());
        } else if (request.getConfirmacao() == EnumConfirmacaoPagamento.NAO) {
            pagamento.setStatus(EnumStatus.CANCELADO.getDescricao());
        } else {
            throw new IllegalArgumentException("Confirmação de pagamento inválida. Use 'SIM' ou 'NAO'.");
        }

        pagamento.setDatahora(LocalDateTime.now()); // Atualiza a data/hora da finalização
        var pFinalizado = pagamentoRepository.save(pagamento);

        return pFinalizado.comprovante();
    }

    private BigDecimal calcularValorTotalPedido(BigDecimal valorPedido, BigDecimal valorFrete,
            EnumCuponsDisponiveis cupom) {
        BigDecimal valorTotal = valorPedido.add(valorFrete);

        if (cupom != null) {
            if (cupom.isValido()) {
                BigDecimal desconto = valorTotal.multiply(BigDecimal.valueOf(cupom.getDescontoPercentual())
                        .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
                valorTotal = valorTotal.subtract(desconto);
                System.out.println("Cupom " + cupom.getNome() + " aplicado. Desconto de "
                        + cupom.getDescontoPercentual() + "%. Novo valor total: R$ " + valorTotal);
            } else {
                System.out.println("Cupom " + cupom.getNome() + " inválido ou expirado. Desconto não aplicado.");
            }
        }
        return valorTotal.setScale(2, RoundingMode.HALF_UP);
    }
}
