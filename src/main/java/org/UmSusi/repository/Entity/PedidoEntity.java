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
    private Double valor;

    public PedidoEntity() {
    }

    public PedidoEntity(Long id, List<ProdutoEntity> produtoEntities, Double valor) {
        this.id = id;
        this.produtoEntities = produtoEntities;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
