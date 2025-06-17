package com.um_sushi.Um_Sushi.adapter.input.dto.requets;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CartaoRequest {

    private Long cpf;
    private BigDecimal numero;
    private String nomeTitular;
    private LocalDate validade;
    private Long cvv;
    private String bandeira;
}
