package com.um_sushi.Um_Sushi.adapter.input.dto.requets;

import jakarta.validation.Valid; 
import jakarta.validation.constraints.*; 
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PedidoRequest {

    @NotNull(message = "Cliente não pode ser nulo no pedido")
    @Valid
    private ClienteRequest cliente;

    @NotNull(message = "Lista de produtos não pode ser nula")
    @Size(min = 1, message = "Pedido deve conter pelo menos um produto")
    @Valid
    private List<ProdutoRequest> produtos;

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class ProdutoRequest {
        @NotBlank(message = "Nome do produto não pode estar em branco")
        private String nome;

        @NotNull(message = "Quantidade do produto não pode ser nula")
        @Min(value = 1, message = "Quantidade do produto deve ser no mínimo 1")
        private Integer quantidade;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class ClienteRequest {
        @NotNull(message = "CPF do cliente não pode ser nulo")
        @Positive(message = "CPF do cliente deve ser um número positivo")
        private Long cpf;
    }
}