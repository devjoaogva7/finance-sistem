package com.um_sushi.Um_Sushi.adapter.input.dto.requets;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PedidoRequest {

    private ClienteRequest cliente;
    private List<ProdutoRequest> produtos;

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class ProdutoRequest {
        private String nome;
        private Integer quantidade;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class ClienteRequest {
        private Long cpf;
    }
}
