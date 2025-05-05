package org.UmSusi.service;

import org.UmSusi.model.FinalizarPagamentoModel;
import org.UmSusi.model.PagamentoModel;
import org.UmSusi.model.enuns.EnumConfirmacaoPagamento;
import org.UmSusi.model.enuns.EnumStatus;
import org.UmSusi.repository.Entity.EstabelecimentoEntity;
import org.UmSusi.repository.Entity.PagamentoEntity;
import org.UmSusi.repository.Entity.ProdutoEntity;
import org.UmSusi.repository.EstabelecimentoRepository;
import org.UmSusi.repository.SistemaPagamentoRepository;
import org.UmSusi.repository.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SistemaPagamentoService {

    @Autowired
    private SistemaPagamentoRepository pagamentoRepository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
    @Autowired
    private EntityMapper mapper;

    public String processarPagamento(PagamentoModel request) {

        //TODO chamar  o metodo do frete e do desconto no valor da compra
        //TODO salvar o valor do pagamento, o frete
        PagamentoEntity savedEntity = pagamentoRepository.save(mapper.toPagamentoEntity(request));

        return "Pagamento processado com ID: " + savedEntity.getId() +
                ". Status: \"PENDENTE\", aguardando confirmação.";
    }

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

    public String finalizarPagamento(FinalizarPagamentoModel request) {
        PagamentoEntity pagamento = pagamentoRepository.findById(request.getIdPagamento())
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com o ID: " + request.getIdPagamento()));

        EstabelecimentoEntity estabelecimento = estabelecimentoRepository.findById(15576315825589L)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado com o ID: 15576315825589"));

        if (request.getConfirmacao() == EnumConfirmacaoPagamento.SIM) {
            pagamento.setStatus(EnumStatus.APROVADO.getDescricao());
        } else if (request.getConfirmacao() == EnumConfirmacaoPagamento.NAO) {
            pagamento.setStatus(EnumStatus.CANCELADO.getDescricao());
        }

        pagamento.setEstabelecimentoEntity(estabelecimento);

        var pFinalizado = pagamentoRepository.save(pagamento);


        return comprovante(
                pFinalizado.getCliente().getNome(),
                pFinalizado.getCliente().getCpf(),
                pFinalizado.getEstabelecimentoEntity().getNome(),
                pFinalizado.getEstabelecimentoEntity().getCnpj(),
                pFinalizado.getValor(),
                pFinalizado.getFormaPagamento(),
                pFinalizado.getDatahora(),
                pFinalizado.getPedidos()
        );
    }

    //TODO implementar metodo do frete
    //TODO imeplementar metodo para descontar o cupom no valor da compra

}
