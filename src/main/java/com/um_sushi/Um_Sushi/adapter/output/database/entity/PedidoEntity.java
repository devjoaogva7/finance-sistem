package com.um_sushi.Um_Sushi.adapter.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "pedido_produtos",
            joinColumns = @JoinColumn(name = "pedido_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "produtos_id"))
    private Set<ProdutoEntity> produtos = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private ClienteEntity cliente;
    private Double valor;

    @Override
    public String toString() {
        return "\n     - produtos: " + produtos +
                "\n     - valor: " + valor;
    }
}
