package com.um_sushi.Um_Sushi.domain.model;

import com.um_sushi.Um_Sushi.domain.model.enums.EnumConfirmacaoPagamento;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class FinalizarPagamento {

    private Long idPagamento;
    private EnumConfirmacaoPagamento confirmacao;
}
