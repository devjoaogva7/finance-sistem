package com.um_sushi.Um_Sushi.domain.model.enums;

public enum EnumFormaPagamento {

    PIX("PIX"),
    CREDITO("CREDITO"),
    DEBITO("DEBITO");

    private String descricao;

    EnumFormaPagamento(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
