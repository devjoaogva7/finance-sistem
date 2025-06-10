package com.um_sushi.Um_Sushi.adapter.output.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    private String rua;
    @Id
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
