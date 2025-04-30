package org.UmSusi.service;

import org.UmSusi.controller.dto.FinalizarPagamentoDTO;
import org.UmSusi.model.enuns.EnumConfirmacaoPagamento;
import org.UmSusi.repository.Entity.PagamentoEntity;
import org.UmSusi.model.Pedido;
import org.UmSusi.model.enuns.EnumFormaPagamento;
import org.UmSusi.model.enuns.EnumStatus;
import org.UmSusi.repository.SistemaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SistemaPagamentoService {

    @Autowired
    private SistemaPagamentoRepository pagamentoRepository;

    public String processarPagamento(PagamentoEntity request) {
        request.setStatus(EnumStatus.PENDENTE);
        request.setDatahora(LocalDateTime.now());

        pagamentoRepository.save(request);

        return "O pagamento foi processado e está com o status \"PENDENTE\", aguardando confirmação.";
    }

    private String comprovante(String cliente, String cpf, String estabelecimento, String cnpj, Double valor, EnumFormaPagamento formaPagamento, LocalDate dataPagamento, List<Pedido> pedido) {
        return String.format(
                "===== COMPROVANTE DE PAGAMENTO =====\n" +
                        "Cliente: %s\n" +
                        "CPF: %s\n" +
                        "Estabelecimento: %s\n" +
                        "CNPJ: %s\n" +
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
                pedido,
                valor
        );
    }

    public String finalizarPagamento(FinalizarPagamentoDTO dto) {
        PagamentoEntity pagamento = pagamentoRepository.findById(dto.getIdPagamento())
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com o ID: " + dto.getIdPagamento()));

        if (dto.getConfirmacao() == EnumConfirmacaoPagamento.SIM) {
            pagamento.setStatus(EnumStatus.APROVADO);
        } else if (dto.getConfirmacao() == EnumConfirmacaoPagamento.NAO) {
            pagamento.setStatus(EnumStatus.CANCELADO);
        }

        pagamentoRepository.save(pagamento);
        return "Status do pagamento atualizado para: " + pagamento.getStatus().getDescricao();
    }
}
