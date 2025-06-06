package org.UmSusi.repository.Entity;

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
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    private Long cpf;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartao")
    private List<CartaoEntity> cartao;

    @Override
    public String toString() {
        return "\n     - cpf: " + cpf +
                "\n     - nome: " + nome +
                "\n     - email: " + email +
                "\n     - telefone: " + telefone +
                "\n     - endereco: " + endereco;
    }
}
