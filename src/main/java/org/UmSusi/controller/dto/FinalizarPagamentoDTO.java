package org.UmSusi.controller.dto;

import org.UmSusi.model.enuns.EnumConfirmacaoPagamento;

public class FinalizarPagamentoDTO {

    private Long idPagamento;
    private EnumConfirmacaoPagamento confirmacao;

    public FinalizarPagamentoDTO(Long idPagamento, EnumConfirmacaoPagamento confirmacao) {
        this.idPagamento = idPagamento;
        this.confirmacao = confirmacao;
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public EnumConfirmacaoPagamento getConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(EnumConfirmacaoPagamento confirmacao) {
        this.confirmacao = confirmacao;
    }
}
