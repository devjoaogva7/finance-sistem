package org.UmSusi.model.enuns;

public enum EnumFormaPagamento {

    PIX("Pix"),
    CARTAO_CREDITO("Cartão de Credito"),
    CARTAO_DEBITO("Cartão de Debito");

    private String descricao;

    EnumFormaPagamento(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
