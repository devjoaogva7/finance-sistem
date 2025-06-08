package org.UmSusi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.UmSusi.model.enuns.EnumCuponsDisponiveis;
import org.UmSusi.model.enuns.EnumFormaPagamento;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessarPagamentoDTO {

    private EnumFormaPagamento formaPagamento;
    private Integer parcelas;
    private EnumCuponsDisponiveis cupom;
    private String cpf;
}
