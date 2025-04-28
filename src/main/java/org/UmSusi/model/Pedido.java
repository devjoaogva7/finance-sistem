package org.UmSusi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Pedido {

    @Id
    private Long id;
    @OneToMany
    @JoinColumn(name = "pedido_id")
    private List<Produto> produtos;
}
