package org.UmSusi.repository.Entity;

import jakarta.persistence.*;

import java.util.List;

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

    public ClienteEntity() {
    }

    public ClienteEntity(Long cpf, String nome, String email, String telefone, String endereco, List<CartaoEntity> cartao) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cartao = cartao;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<CartaoEntity> getCartao() {
        return cartao;
    }

    public void setCartao(List<CartaoEntity> cartao) {
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return  "\n     - cpf: " + cpf +
                "\n     - nome: " + nome +
                "\n     - email: " + email +
                "\n     - telefone: " + telefone  +
                "\n     - endereco: " + endereco;
    }
}
