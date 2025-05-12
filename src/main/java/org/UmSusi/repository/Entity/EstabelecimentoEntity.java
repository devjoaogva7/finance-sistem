package org.UmSusi.repository.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.util.Arrays;

@Entity
@Table(name = "estabelecimento")
public class EstabelecimentoEntity {

    @Id
    private Long cnpj;
    private String nome;
    private String contaBancaria;
    private String endereco;
    private String pixCopiaCola;
    @Lob
    private byte[] imagemQrCode;

    public EstabelecimentoEntity() {
    }

    public EstabelecimentoEntity(Long cnpj, String nome, String contaBancaria, String endereco, String pixCopiaCola, byte[] imagemQrCode) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.contaBancaria = contaBancaria;
        this.endereco = endereco;
        this.pixCopiaCola = pixCopiaCola;
        this.imagemQrCode = imagemQrCode;
    }

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

    public String getPixCopiaCola() {
        return pixCopiaCola;
    }

    public byte[] getImagemQrCode() {
        return imagemQrCode;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPixCopiaCola(String pixCopiaCola) {
        this.pixCopiaCola = pixCopiaCola;
    }

    public void setImagemQrCode(byte[] imagemQrCode) {
        this.imagemQrCode = imagemQrCode;
    }

    @Override
    public String toString() {
        return  "\n     - cnpj: " + cnpj +
                "\n     - nome: " + nome +
                "\n     - endereco: " + endereco;
    }
}
