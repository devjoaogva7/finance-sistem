package com.um_sushi.Um_Sushi.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Cartao {

    private Long cpf;
    private BigDecimal numero;
    private String nomeTitular;
    private LocalDate validade;
    private Long cvv;
    private String bandeira;
}
