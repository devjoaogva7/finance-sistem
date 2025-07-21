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

    private Long id;
    private Cliente cliente;
    private List<Produto> produtos;
    private BigDecimal valor;
}
