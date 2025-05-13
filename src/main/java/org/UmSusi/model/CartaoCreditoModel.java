package org.UmSusi.model;

import lombok.Data;

// Modelo do cartão de crédito
@Data
public class CartaoCreditoModel {
    // Número do cartão
    private String numero;

    // Nome do dono do cartão
    private String titular;

    // Data que o cartão expira
    private String dataValidade;

    // Código de segurança
    private String cvv;

    // Limite do cartão
    private Double limite;

    // Tipo do cartão (Visa, Mastercard)
    private String bandeira;
} 