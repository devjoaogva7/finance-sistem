package org.UmSusi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Pedido {

    @Id
    private Long id;

    @OneToMany
    @JoinColumn(name = "pedido_id")
    private List<Produto> produtos;

    // Método para calcular o valor total do pedido
    public BigDecimal calcularValorTotal() {
        if (produtos == null || produtos.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal total = BigDecimal.ZERO;
        for (Produto produto : produtos) {
            if (produto.getPreco() != null && produto.getQuantidade() != null) {
                total = total.add(produto.getPreco().multiply(BigDecimal.valueOf(produto.getQuantidade())));
            }
        }
        return total;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
