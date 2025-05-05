package org.UmSusi.model;

import org.UmSusi.model.enuns.EnumConfirmacaoPagamento;

public class FinalizarPagamentoModel {

    private Long idPagamento;
    private EnumConfirmacaoPagamento confirmacao;

    public FinalizarPagamentoModel(Long idPagamento, EnumConfirmacaoPagamento confirmacao) {
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
