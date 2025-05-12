package org.UmSusi.model.enuns;

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
