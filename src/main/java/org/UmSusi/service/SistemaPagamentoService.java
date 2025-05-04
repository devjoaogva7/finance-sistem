package org.UmSusi.service;

import org.UmSusi.controller.dto.FinalizarPagamentoDTO;
import org.UmSusi.model.PagamentoModel;
import org.UmSusi.model.enuns.EnumConfirmacaoPagamento;
import org.UmSusi.model.enuns.EnumFormaPagamento;
import org.UmSusi.model.enuns.EnumStatus;
import org.UmSusi.repository.Entity.PagamentoEntity;
import org.UmSusi.repository.Entity.PedidoEntity;
import org.UmSusi.repository.SistemaPagamentoRepository;
import org.UmSusi.repository.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SistemaPagamentoService {

    @Autowired
    private SistemaPagamentoRepository pagamentoRepository;

    @Autowired
    private EntityMapper mapper;

    public String processarPagamento(PagamentoModel request) {

        PagamentoEntity savedEntity = pagamentoRepository.save(mapper.toPagamentoEntity(request));

        return "Pagamento processado com ID: " + savedEntity.getId() +
                ". Status: \"PENDENTE\", aguardando confirmação.";
    }

    private String comprovante(String cliente, Long cpf, String estabelecimento, Long cnpj, Double valor, EnumFormaPagamento formaPagamento, LocalDate dataPagamento, List<PedidoEntity> pedidoEntity) {
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

    public String finalizarPagamento(FinalizarPagamentoDTO dto) {
        PagamentoEntity pagamento = pagamentoRepository.findById(dto.getIdPagamento())
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com o ID: " + dto.getIdPagamento()));

        if (dto.getConfirmacao() == EnumConfirmacaoPagamento.SIM) {
            pagamento.setStatus(EnumStatus.APROVADO.getDescricao());
        } else if (dto.getConfirmacao() == EnumConfirmacaoPagamento.NAO) {
            pagamento.setStatus(EnumStatus.CANCELADO.getDescricao());
        }

        pagamentoRepository.save(pagamento);
        return "Status do pagamento atualizado para: " + pagamento.getStatus();
    }
}
