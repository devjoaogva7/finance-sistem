package org.UmSusi.model.enuns;

public enum EnumStatus {

    APROVADO(1, "Aprovado"),
    PENDENTE(2, "Pendente"),
    RECUSADO(3, "Recusado"),
    CANCELADO(4, "Cancelado");

    private int valor;
    private String descricao;

    EnumStatus(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public static String fromValue(Object value){
        if (value instanceof Integer inValue){
            switch (inValue){
                case 1:
                    return APROVADO.descricao;
                case 2:
                    return PENDENTE.descricao;
                case 3:
                    return RECUSADO.descricao;
                case 4:
                    return CANCELADO.descricao;
            }
        }
        return null;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
