package org.UmSusi.model;

import lombok.Data;

// Modelo do cartão de débito
@Data
public class CartaoDebitoModel {
    // Número do cartão
    private String numero;

    // Nome do dono do cartão
    private String titular;

    // Data que o cartão expira
    private String dataValidade;

    // Código de segurança
    private String cvv;

    // Dinheiro disponível na conta
    private Double saldo;

    // Tipo do cartão (Visa, Mastercard)
    private String bandeira;
} 