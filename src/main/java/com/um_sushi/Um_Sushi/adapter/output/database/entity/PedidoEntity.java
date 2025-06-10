package com.um_sushi.Um_Sushi.adapter.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "\n     - produtos: " + produtoEntities +
                "\n     - valor: " + valor;
    }
}
