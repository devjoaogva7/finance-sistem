package org.UmSusi.model;

import org.UmSusi.model.enuns.EnumCuponsDisponiveis;
import org.UmSusi.model.enuns.EnumFormaPagamento;

public class PagamentoModel {

    private EnumFormaPagamento formaPagamento;
    private ClienteModel cliente;
    private EnumCuponsDisponiveis cupom;

    public PagamentoModel() {
    }

    public PagamentoModel(EnumFormaPagamento formaPagamento, ClienteModel cliente, EnumCuponsDisponiveis cupom) {
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
        this.cupom = cupom;
    }

    public EnumFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public EnumCuponsDisponiveis getCupom() {
        return cupom;
    }

    public void setCupom(EnumCuponsDisponiveis cupom) {
        this.cupom = cupom;
    }
}
