package org.UmSusi.repository.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "pedido_id")
    private List<ProdutoEntity> produtoEntities;
    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private ClienteEntity cliente;
    private Double valor;

    public PedidoEntity() {
    }

    public PedidoEntity(Long id, List<ProdutoEntity> produtoEntities, ClienteEntity cliente, Double valor) {
        this.id = id;
        this.produtoEntities = produtoEntities;
        this.cliente = cliente;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public List<ProdutoEntity> getProdutoEntities() {
        return produtoEntities;
    }

    public void setProdutoEntities(List<ProdutoEntity> produtoEntities) {
        this.produtoEntities = produtoEntities;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return  "\n     - produtos: " + produtoEntities +
                "\n     - valor: " + valor;
    }
}
