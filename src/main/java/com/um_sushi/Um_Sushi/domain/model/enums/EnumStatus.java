package com.um_sushi.Um_Sushi.domain.model.enums;

public enum EnumStatus {

    APROVADO("Aprovado"),
    PENDENTE("Pendente"),
    RECUSADO("Recusado"),
    CANCELADO("Cancelado");

    private final String descricao;

    EnumStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
