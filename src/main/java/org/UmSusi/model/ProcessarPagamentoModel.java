package org.UmSusi.model;

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
public class ProcessarPagamentoModel {

    private EnumFormaPagamento formaPagamento;
    private Integer parcelas;
    private EnumCuponsDisponiveis cupom;
    private Long cpf;
}
