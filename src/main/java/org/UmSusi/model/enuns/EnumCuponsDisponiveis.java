package org.UmSusi.model.enuns;

public enum EnumCuponsDisponiveis {

    BEMVINDO10("BEMVINDO10", "Primeira compra", TipoDesconto.PERCENTUAL, 10.0),
    FRETEGRATIS("FRETEGRATIS", "Frete grátis para qualquer pedido", TipoDesconto.FRETE, 100.0),
    SUPER20("SUPER20", "Desconto em compras acima de R$100", TipoDesconto.PERCENTUAL, 20.0),
    PRIMEIRACOMPRA("PRIMEIRACOMPRA", "Cupom exclusivo para novos clientes", TipoDesconto.VALOR_FIXO, 15.0),
    BLACK50("BLACK50", "Promoção estilo Black Friday", TipoDesconto.PERCENTUAL, 50.0),
    VERAO2025("VERAO2025", "Promoção sazonal de verão", TipoDesconto.PERCENTUAL, 25.0),
    VIP30("VIP30", "Desconto para usuários VIP", TipoDesconto.PERCENTUAL, 30.0),
    NATAL2025("NATAL2025", "Cupom de fim de ano", TipoDesconto.VALOR_FIXO, 20.0);

    private final String codigo;
    private final String descricao;
    private final TipoDesconto tipo;
    private final double valor;

    EnumCuponsDisponiveis(String codigo, String descricao, TipoDesconto tipo, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoDesconto getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public boolean isDescontoPercentual() {
        return this.tipo == TipoDesconto.PERCENTUAL;
    }
    
    public static EnumCuponsDisponiveis buscarPorCodigo(String codigo) {
        for (EnumCuponsDisponiveis cupom : values()) {
            if (cupom.getCodigo().equalsIgnoreCase(codigo)) {
                return cupom;
            }
        }
        return null;
    }

}
