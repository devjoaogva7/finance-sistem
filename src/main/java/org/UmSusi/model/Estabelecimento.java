package org.UmSusi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estabelecimento")
public class Estabelecimento {

    @Id
    private Long cnpj;
    private String nome;
    private String contaBancaria;
    private String endereco;

    public Long getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }

    public String getEndereco() {
        return endereco;
    }
}
