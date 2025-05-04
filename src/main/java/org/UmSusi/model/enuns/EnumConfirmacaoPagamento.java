package org.UmSusi.model.enuns;

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
//    public static String fromString(EnumCuponsDisponiveis valor) {
//        try {
//            return EnumConfirmacaoPagamento.valueOf(valor.wait());
//        } catch (Exception e) {
//            throw new IllegalArgumentException("Valor inválido para confirmação: " + valor + ". Use 'SIM' ou 'NAO'.");
//        }
//    }
}