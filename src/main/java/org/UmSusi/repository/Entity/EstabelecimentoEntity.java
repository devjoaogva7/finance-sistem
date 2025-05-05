package org.UmSusi.repository.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "estabelecimento")
public class EstabelecimentoEntity {

    @Id
    private Long cnpj;
    private String nome;
    private String contaBancaria;
    private String endereco;
    private String pix;

    public EstabelecimentoEntity() {
    }

    public EstabelecimentoEntity(Long cnpj, String nome, String contaBancaria, String endereco, String pix) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.contaBancaria = contaBancaria;
        this.endereco = endereco;
        this.pix = pix;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }
}
