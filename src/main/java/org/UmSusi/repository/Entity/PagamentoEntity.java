package org.UmSusi.repository.Entity;

import jakarta.persistence.*;
import org.UmSusi.model.Cliente;
import org.UmSusi.model.Estabelecimento;
import org.UmSusi.model.Frete;
import org.UmSusi.model.Pedido;
import org.UmSusi.model.enuns.EnumCuponsDisponiveis;
import org.UmSusi.model.enuns.EnumFormaPagamento;
import org.UmSusi.model.enuns.EnumStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    private EnumStatus status;
    private LocalDateTime datahora;
    private EnumFormaPagamento formaPagamento;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;
    private EnumCuponsDisponiveis cupom;
    @ManyToOne
    @JoinColumn(name = "frete_id")
    private Frete frete;
    @OneToMany
    @JoinColumn(name = "pagamento_id")
    private List<Pedido> pedido;

    public PagamentoEntity() {
    }

    public PagamentoEntity(Long id, Double valor, EnumStatus status, LocalDateTime datahora, EnumFormaPagamento formaPagamento, Cliente cliente, Estabelecimento estabelecimento, EnumCuponsDisponiveis cupom, Frete frete, List<Pedido> pedido) {
        this.id = id;
        this.valor = valor;
        this.status = status;
        this.datahora = datahora;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
        this.estabelecimento = estabelecimento;
        this.cupom = cupom;
        this.frete = frete;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public EnumFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public EnumCuponsDisponiveis getCupom() {
        return cupom;
    }

    public void setCupom(EnumCuponsDisponiveis cupom) {
        this.cupom = cupom;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }
}
