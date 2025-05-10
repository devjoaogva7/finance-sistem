package org.UmSusi.controller.dto;

import org.UmSusi.model.enuns.EnumCuponsDisponiveis;
import org.UmSusi.model.enuns.EnumFormaPagamento;


public class PagamentoRequestDTO {

    private EnumFormaPagamento formaPagamento;
    private ClienteRequestDTO cliente;
    private EnumCuponsDisponiveis cupom;

    public PagamentoRequestDTO(EnumFormaPagamento formaPagamento, ClienteRequestDTO cliente, EnumCuponsDisponiveis cupom) {
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

    public ClienteRequestDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRequestDTO cliente) {
        this.cliente = cliente;
    }

    public EnumCuponsDisponiveis getCupom() {
        return cupom;
    }

    public void setCupom(EnumCuponsDisponiveis cupom) {
        this.cupom = cupom;
    }
}
