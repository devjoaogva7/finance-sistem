package com.um_sushi.Um_Sushi.adapter.input.dto.responses;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponse {

    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
    private String descricao;

}
