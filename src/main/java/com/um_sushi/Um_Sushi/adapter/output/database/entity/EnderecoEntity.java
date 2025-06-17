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
@Table(name = "endereco")
public class EnderecoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private Integer numero;
    private Integer cep;
    private String cidade;
    private String bairro;
    private String uf;

    public String toString() {
        return "\n Rua: " + rua +
                ", n" + numero +
                ", bairro: " + bairro +
                ", cidade: " + cidade +
                "/" + uf +
                ", CEP: " + cep;
    }
}
