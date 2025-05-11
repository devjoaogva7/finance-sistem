package org.UmSusi.service;

import org.UmSusi.model.*;
import org.UmSusi.model.enuns.EnumConfirmacaoPagamento;
import org.UmSusi.model.enuns.EnumFormaPagamento;
import org.UmSusi.model.enuns.EnumStatus;
import org.UmSusi.repository.*;
import org.UmSusi.repository.Entity.*;
import org.UmSusi.repository.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SistemaPagamentoService {

    @Autowired
    private SistemaPagamentoRepository pagamentoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
    @Autowired
    private FreteRepository freteRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EntityMapper mapper;

    public String processarPagamento(ProcessarPagamentoModel request) {

        if (request.getFormaPagamento().equals(EnumFormaPagamento.CREDITO) && request.getParcelas() == null) {
            throw new IllegalArgumentException("Forma de pagamento CREDITO precisa de parcelas definidas.");
        } if (request.getFormaPagamento().equals(EnumFormaPagamento.DEBITO) || request.getFormaPagamento().equals(EnumFormaPagamento.PIX) && request.getParcelas() == null) {
            request.setParcelas(1);
        }

        ClienteEntity cliente = clienteRepository.getReferenceById(request.getCpf());
        EstabelecimentoEntity estabelecimento = estabelecimentoRepository.findFirstByOrderByCnpjAsc();
        FreteEntity frete = freteRepository.findFirstByOrderByIdAsc();
        PedidoEntity pedido = pedidoRepository.findByClienteCpf(request.getCpf());
        BigDecimal valorTotal = PedidoModel.calcularValorTotalPedido(pedido, frete);

        PagamentoEntity savedEntity = pagamentoRepository.save(mapper.toPagamentoEntity(request, valorTotal, cliente, estabelecimento, frete, pedido));

        return "Pagamento processado com ID: " + savedEntity.getId() + ". Status: \"PENDENTE\", aguardando confirmação.";
    }

    public String finalizarPagamento(FinalizarPagamentoModel request) {
        PagamentoCartao cartao = new PagamentoCartao();
        PagamentoPix pagamentoPix = new PagamentoPix();

        PagamentoEntity pagamento = pagamentoRepository.findById(request.getIdPagamento())
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com o ID: " + request.getIdPagamento()));

        if (request.getConfirmacao() == EnumConfirmacaoPagamento.SIM) {
            //TODO implementar pagamentoCartao e PIX
//            if (pagamento.getFormaPagamento().equals(EnumFormaPagamento.CREDITO.getDescricao()) || pagamento.getFormaPagamento().equals(EnumFormaPagamento.DEBITO.getDescricao())) {
//                cartao.processar();
//            } else if (pagamento.getFormaPagamento().equals(EnumFormaPagamento.PIX.getDescricao())) {
//                pagamentoPix.processar();
//            }
            pagamento.setStatus(EnumStatus.APROVADO.getDescricao());
        } else if (request.getConfirmacao() == EnumConfirmacaoPagamento.NAO) {
            pagamento.setStatus(EnumStatus.CANCELADO.getDescricao());
        }

        var pFinalizado = pagamentoRepository.save(pagamento);

        return pFinalizado.comprovante();
    }



}
