package com.um_sushi.Um_Sushi.adapter.input.dto;

import com.um_sushi.Um_Sushi.domain.model.enums.EnumConfirmacaoPagamento;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinalizarPagamentoRequest {

    private Long idPagamento;
    private EnumConfirmacaoPagamento confirmacao;
}
