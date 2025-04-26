package org.UmSusi.model;

import org.UmSusi.FormaPagamento;
import org.UmSusi.model.enuns.EnumCuponsDisponiveis;
import org.UmSusi.model.enuns.EnumStatusPagamento;

import java.time.LocalDate;
import java.util.List;

public class Pagamento {

    private Long id;
    private Float valor;
    private EnumStatusPagamento status;
    private LocalDate data;
    private FormaPagamento formaPagamento;
    private Cliente cliente;
    private Estabelecimento estabelecimento;
    private EnumCuponsDisponiveis cupom;
    private Frete frete;
    private List<Pedidos> pedido;

    public Pagamento(Long id, Float valor, EnumStatusPagamento status, LocalDate data, FormaPagamento formaPagamento, Cliente cliente,
                     Estabelecimento estabelecimento, EnumCuponsDisponiveis cupom,Frete frete, List<Pedidos> pedido) {
        this.id = id;
        this.valor = valor;
        this.status = status;
        this.data = data;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
        this.estabelecimento = estabelecimento;
        this.cupom = cupom;
        this.frete = frete;
        this.pedido = pedido;
    }
}
