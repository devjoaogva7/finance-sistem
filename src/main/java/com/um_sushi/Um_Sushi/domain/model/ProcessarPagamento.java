package com.um_sushi.Um_Sushi.domain.model;

import com.um_sushi.Um_Sushi.domain.model.enums.EnumCuponsDisponiveis;
import com.um_sushi.Um_Sushi.domain.model.enums.EnumFormaPagamento;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProcessarPagamento {

    private EnumFormaPagamento formaPagamento;
    private Integer parcelas;
    private EnumCuponsDisponiveis cupom;
    private Long cpf;
}
