package com.um_sushi.Um_Sushi.adapter.input.dto.requets;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CartaoRequest {

    @NotNull(message = "CPF não pode ser nulo")
    @Positive(message = "CPF deve ser um número positivo")
    private Long cpf;

    @NotNull(message = "Número do cartão não pode ser nulo")
    @Digits(integer = 16, fraction = 0, message = "Número do cartão deve ter até 16 dígitos")
    @Positive(message = "Número do cartão deve ser positivo")
    private BigDecimal numero;

    @NotBlank(message = "Nome do titular não pode estar em branco")
    @Size(min = 3, max = 100, message = "Nome do titular deve ter entre 3 e 100 caracteres")
    private String nomeTitular;

    @NotNull(message = "Validade não pode ser nula")
    @Future(message = "Validade do cartão deve ser no futuro")
    private LocalDate validade;

    @NotNull(message = "CVV não pode ser nulo")
    @Digits(integer = 3, fraction = 0, message = "CVV deve ter 3 ou 4 dígitos")
    @Positive(message = "CVV deve ser positivo")
    private Long cvv;

    @NotBlank(message = "Bandeira não pode estar em branco")
    private String bandeira;
}