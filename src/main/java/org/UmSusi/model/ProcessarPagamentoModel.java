package org.UmSusi.model;

import org.UmSusi.model.enuns.EnumCuponsDisponiveis;
import org.UmSusi.model.enuns.EnumFormaPagamento;

public class ProcessarPagamentoModel {

    private EnumFormaPagamento formaPagamento;
    private Integer parcelas;
    private EnumCuponsDisponiveis cupom;
    private Long cpf;

    public ProcessarPagamentoModel() {
    }

    public ProcessarPagamentoModel(EnumFormaPagamento formaPagamento, Integer parcelas, EnumCuponsDisponiveis cupom, Long cpf) {
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
        this.cupom = cupom;
        this.cpf = cpf;
    }

    public EnumFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public EnumCuponsDisponiveis getCupom() {
        return cupom;
    }

    public void setCupom(EnumCuponsDisponiveis cupom) {
        this.cupom = cupom;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }
}
