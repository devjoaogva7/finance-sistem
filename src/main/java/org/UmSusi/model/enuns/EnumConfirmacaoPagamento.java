package org.UmSusi.model.enuns;

public enum EnumConfirmacaoPagamento {
    SIM, NAO;

    public static EnumConfirmacaoPagamento fromString(String valor) {
        try {
            return EnumConfirmacaoPagamento.valueOf(valor.trim().toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Valor inválido para confirmação: " + valor + ". Use 'SIM' ou 'NAO'.");
        }
    }
}