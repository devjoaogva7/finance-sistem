package org.UmSusi.model.enuns;

import java.time.LocalDate;

public enum EnumCuponsDisponiveis {

    BEMVINDO10("BEMVINDO10", LocalDate.of(2025, 12, 31), 10.0),
    FRETEGRATIS("FRETEGRATIS", LocalDate.of(2025, 7, 1), 100.0), // Pode tratar como frete grátis
    SUPER20("SUPER20", LocalDate.of(2025, 8, 15), 20.0),
    PRIMEIRACOMPRA("PRIMEIRACOMPRA", LocalDate.of(2025, 12, 31), 15.0),
    BLACK50("BLACK50", LocalDate.of(2025, 11, 30), 50.0),
    VERAO2025("VERAO2025", LocalDate.of(2025, 3, 21), 25.0),
    VIP30("VIP30", LocalDate.of(2025, 9, 30), 30.0),
    NATAL2025("NATAL2025", LocalDate.of(2025, 12, 25), 20.0);

    private final String nome;
    private final LocalDate validade;
    private final double descontoPercentual;

    EnumCuponsDisponiveis(String nome, LocalDate validade, double descontoPercentual) {
        this.nome = nome;
        this.validade = validade;
        this.descontoPercentual = descontoPercentual;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public double getDescontoPercentual() {
        return descontoPercentual;
    }

    public boolean isValido() {
        return !LocalDate.now().isAfter(validade);
    }

    public static EnumCuponsDisponiveis buscarPorNome(String nome) {
        for (EnumCuponsDisponiveis cupom : values()) {
            if (cupom.getNome().equalsIgnoreCase(nome)) {
                return cupom;
            }
        }
        return null;
    }
}
