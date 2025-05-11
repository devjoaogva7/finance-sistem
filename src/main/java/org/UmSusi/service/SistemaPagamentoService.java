package org.UmSusi.service;

import org.UmSusi.model.*;
import org.UmSusi.repository.*;
import org.UmSusi.repository.Entity.*;
import org.UmSusi.repository.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

        ClienteEntity cliente = clienteRepository.getReferenceById(request.getCpf());
        EstabelecimentoEntity estabelecimento = estabelecimentoRepository.findFirstByOrderByCnpjAsc();
        FreteEntity frete = freteRepository.findFirstByOrderByIdAsc();
        PedidoEntity pedido = pedidoRepository.findByClienteCpf(request.getCpf());
        BigDecimal valorTotal = PedidoModel.calcularValorTotalPedido(pedido, frete);

        PagamentoEntity savedEntity = pagamentoRepository.save(mapper.toPagamentoEntity(request, valorTotal, cliente, estabelecimento, frete, pedido));

        return savedEntity.toString();
    }

//    public String finalizarPagamento(FinalizarPagamentoModel request) {
//
//        PagamentoEntity pagamento = pagamentoRepository.findById(request.getIdPagamento())
//                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com o ID: " + request.getIdPagamento()));
//
//        EstabelecimentoEntity estabelecimento = estabelecimentoRepository.findById(15576315825589L)
//                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado com o ID: 15576315825589"));
//
//        if (request.getConfirmacao() == EnumConfirmacaoPagamento.SIM) {
//            if (pagamento.getFormaPagamento().equals(EnumFormaPagamento.CREDITO.getDescricao()) || pagamento.getFormaPagamento().equals(EnumFormaPagamento.DEBITO.getDescricao())) {
//                PagamentoCartao cartao = new PagamentoCartao();
//                cartao.processar(pagamento.getFormaPagamento());
//            } else if (pagamento.getFormaPagamento().equals(EnumFormaPagamento.PIX.getDescricao())) {
//                PagamentoPix pagamentoPix = new PagamentoPix();
//                pagamentoPix.processar();
//            }
//            pagamento.setStatus(EnumStatus.APROVADO.getDescricao());
//        } else if (request.getConfirmacao() == EnumConfirmacaoPagamento.NAO) {
//            pagamento.setStatus(EnumStatus.CANCELADO.getDescricao());
//        }
//
//        pagamento.setEstabelecimentoEntity(estabelecimento);
//
//        var pFinalizado = pagamentoRepository.save(pagamento);
//
//        return comprovante(
//                pFinalizado.getCliente().getNome(),
//                pFinalizado.getCliente().getCpf(),
//                pFinalizado.getEstabelecimentoEntity().getNome(),
//                pFinalizado.getEstabelecimentoEntity().getCnpj(),
//                pFinalizado.getValor(),
//                pFinalizado.getFormaPagamento(),
//                pFinalizado.getDatahora(),
//                pFinalizado.getPedidos()
//        );
//    }

    private String comprovante(String cliente, Long cpf, String estabelecimento, Long cnpj, Double valor, String formaPagamento, LocalDateTime dataPagamento, List<ProdutoEntity> pedidoEntity) {
        return String.format(
                "===== COMPROVANTE DE PAGAMENTO =====\n" +
                        "Cliente: %s\n" +
                        "CPF: %d\n" +
                        "Estabelecimento: %s\n" +
                        "CNPJ: %d\n" +
                        "Forma de Pagamento: %s\n" +
                        "Data do Pagamento: %s\n" +
                        "Pedido: %s\n" +
                        "Valor: R$ %.2f\n" +
                        "====================================",
                cliente,
                cpf,
                estabelecimento,
                cnpj,
                formaPagamento,
                dataPagamento,
                pedidoEntity,
                valor
        );
    }

}
