package org.UmSusi.controller.dto;

import org.UmSusi.model.enuns.EnumCuponsDisponiveis;
import org.UmSusi.model.enuns.EnumFormaPagamento;


public class ProcessarPagamentoDTO {

    private EnumFormaPagamento formaPagamento;
    private EnumCuponsDisponiveis cupom;
    private String cpf;

    public ProcessarPagamentoDTO() {
    }

    public ProcessarPagamentoDTO(EnumFormaPagamento formaPagamento, EnumCuponsDisponiveis cupom, String cpf) {
        this.formaPagamento = formaPagamento;
        this.cupom = cupom;
        this.cpf = cpf;
    }

    public EnumFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public EnumCuponsDisponiveis getCupom() {
        return cupom;
    }

    public String getCpf() {
        return cpf;
    }
}
