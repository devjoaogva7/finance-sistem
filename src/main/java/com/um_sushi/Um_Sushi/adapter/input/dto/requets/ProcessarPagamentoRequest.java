package com.um_sushi.Um_Sushi.adapter.input.dto.requets;

import com.um_sushi.Um_Sushi.domain.model.enums.EnumCuponsDisponiveis;
import com.um_sushi.Um_Sushi.domain.model.enums.EnumFormaPagamento;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessarPagamentoRequest {

    private EnumFormaPagamento formaPagamento;
    private Integer parcelas;
    private EnumCuponsDisponiveis cupom;
    private Long cpf;
}
