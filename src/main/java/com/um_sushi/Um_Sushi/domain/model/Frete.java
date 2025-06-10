package com.um_sushi.Um_Sushi.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Frete {

    private String nome;
    private BigDecimal preco;
}
