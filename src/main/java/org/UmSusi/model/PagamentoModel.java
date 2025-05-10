package org.UmSusi.model;

import org.UmSusi.model.enuns.EnumCuponsDisponiveis;
import org.UmSusi.model.enuns.EnumFormaPagamento;

public class PagamentoModel {
    private FormaPagamento formaPagamento;
    private ClienteModel cliente;
    private EnumCuponsDisponiveis cupom;
    private double valor;

    public PagamentoModel() {
    }

    public PagamentoModel(EnumFormaPagamento tipoPagamento, ClienteModel cliente, 
                         EnumCuponsDisponiveis cupom, double valor, String... parametros) {
        this.formaPagamento = PagamentoFactory.criarPagamento(tipoPagamento, parametros);
        this.cliente = cliente;
        this.cupom = cupom;
        this.valor = valor;
    }

    public boolean processarPagamento() {
        return formaPagamento.processarPagamento(valor);
    }

    public String gerarComprovante() {
        return formaPagamento.gerarComprovante();
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
