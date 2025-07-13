package com.um_sushi.Um_Sushi.adapter.input.dto.requets;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ClienteCadastroRequest {

    @NotNull(message = "CPF não pode ser nulo")
    @Positive(message = "CPF deve ser um número positivo")
    private Long cpf;

    @NotBlank(message = "Nome não pode estar em branco")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Email não pode estar em branco")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Telefone não pode estar em branco")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Telefone inválido")
    private String telefone;

    @NotNull(message = "Endereço não pode ser nulo")
    @Valid
    private EnderecoRequest endereco;

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class EnderecoRequest {
        @NotBlank(message = "Rua não pode estar em branco")
        @Size(min = 3, max = 100, message = "Rua deve ter entre 3 e 100 caracteres")
        private String rua;

        @NotNull(message = "Número não pode ser nulo")
        @Positive(message = "Número deve ser positivo")
        private Integer numero;

        @NotNull(message = "CEP não pode ser nulo")
        @Digits(integer = 8, fraction = 0, message = "CEP deve ter 8 dígitos")
        private Integer cep;

        @NotBlank(message = "Cidade não pode estar em branco")
        @Size(min = 3, max = 50, message = "Cidade deve ter entre 3 e 50 caracteres")
        private String cidade;

        @NotBlank(message = "Bairro não pode estar em branco")
        @Size(min = 3, max = 50, message = "Bairro deve ter entre 3 e 50 caracteres")
        private String bairro;

        @NotBlank(message = "UF não pode estar em branco")
        @Size(min = 2, max = 2, message = "UF deve ter 2 caracteres")
        private String uf;
    }
}