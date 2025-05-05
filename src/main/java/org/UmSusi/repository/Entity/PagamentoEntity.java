package org.UmSusi.repository.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pagamento")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    private String status;
    private LocalDateTime datahora;
    private String formaPagamento;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ClienteEntity cliente;
    @OneToOne
    private EstabelecimentoEntity estabelecimento;
    private String cupom;
    @ManyToOne
    private Frete frete;
    @OneToMany
    private List<ProdutoEntity> pedidos;

    public PagamentoEntity() {
    }

    public PagamentoEntity(Long id, Double valor, String status, LocalDateTime datahora, String formaPagamento, ClienteEntity cliente,
                           EstabelecimentoEntity estabelecimento, String cupom, Frete frete, List<ProdutoEntity> pedidos) {
        this.id = id;
        this.valor = valor;
        this.status = status;
        this.datahora = datahora;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
        this.estabelecimento = estabelecimento;
        this.cupom = cupom;
        this.frete = frete;
        this.pedidos = pedidos;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public EstabelecimentoEntity getEstabelecimentoEntity() {
        return estabelecimento;
    }

    public void setEstabelecimentoEntity(EstabelecimentoEntity estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public List<ProdutoEntity> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ProdutoEntity> pedidos) {
        this.pedidos = pedidos;
    }
}

