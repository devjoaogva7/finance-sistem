package com.um_sushi.Um_Sushi.adapter.input.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PedidoResponse {

    private ClienteResponse cliente;
    private List<ProdutoResponse> produtos;
    private Double valor;

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class ClienteResponse {
        private Long cpf;
        private String nome;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class ProdutoResponse {

        private Long id;
        private String nome;
        private BigDecimal preco;
        private Integer quantidade;
        private String descricao;
    }

}
