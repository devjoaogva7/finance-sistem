package com.um_sushi.Um_Sushi.adapter.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    private Long cpf;
    private String nome;
    private String email;
    private String telefone;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco")
    private EnderecoEntity endereco;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cartao")
    private CartaoEntity cartao;

    @Override
    public String toString() {
        return "\n     - cpf: " + cpf +
                "\n     - nome: " + nome +
                "\n     - email: " + email +
                "\n     - telefone: " + telefone +
                "\n     - endereco: " + endereco;
    }
}
