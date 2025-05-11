package org.UmSusi.controller.dto;

import org.UmSusi.model.enuns.EnumCuponsDisponiveis;
import org.UmSusi.model.enuns.EnumFormaPagamento;


public class ProcessarPagamentoDTO {

    private EnumFormaPagamento formaPagamento;
    private Integer parcelas;
    private EnumCuponsDisponiveis cupom;
    private String cpf;

    public ProcessarPagamentoDTO() {
    }

    public ProcessarPagamentoDTO(EnumFormaPagamento formaPagamento, Integer parcelas, EnumCuponsDisponiveis cupom, String cpf) {
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

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public EnumCuponsDisponiveis getCupom() {
        return cupom;
    }

    public void setCupom(EnumCuponsDisponiveis cupom) {
        this.cupom = cupom;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
