package com.um_sushi.Um_Sushi.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private Cliente cliente;
    private List<Produto> produtos;
    private Double valor;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Produto {
        private String nome;
        private BigDecimal preco;
        private Integer quantidade;
        private String descricao;
    }
}
