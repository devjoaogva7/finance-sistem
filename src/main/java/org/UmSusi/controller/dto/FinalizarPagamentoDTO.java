package org.UmSusi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.UmSusi.model.enuns.EnumConfirmacaoPagamento;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinalizarPagamentoDTO {

    private Long idPagamento;
    private EnumConfirmacaoPagamento confirmacao;
}
