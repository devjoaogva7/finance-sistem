package com.um_sushi.Um_Sushi.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Produto {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
    private String descricao;
}
