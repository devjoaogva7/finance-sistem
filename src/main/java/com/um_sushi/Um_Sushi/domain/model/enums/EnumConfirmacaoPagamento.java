package com.um_sushi.Um_Sushi.domain.model.enums;

public enum EnumConfirmacaoPagamento {

    SIM("sim"),
    NAO("nao");

    private final String valor;

    EnumConfirmacaoPagamento(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static EnumConfirmacaoPagamento fromString(String valor) {
        try {
            return EnumConfirmacaoPagamento.valueOf(valor.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Valor inválido para confirmação: " + valor + ". Use 'SIM' ou 'NAO'.");
        }
    }
}
