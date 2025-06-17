package com.um_sushi.Um_Sushi.adapter.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
    private String descricao;

    @Override
    public String toString() {
        return "\n         - nome: " + nome +
                "\n         - preco: " + preco +
                "\n         - descricao: " + descricao +
                "\n         - quantidade: " + quantidade;
    }
}
