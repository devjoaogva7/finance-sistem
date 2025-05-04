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

    @ElementCollection
    @CollectionTable(
            name = "cliente_pix",
            joinColumns = @JoinColumn(name = "cliente_cpf")
    )
    @Column(name = "pix")
    private List<String> pix;

    public ClienteEntity() {
    }

    public ClienteEntity(Long cpf, String nome, String email, String telefone, String endereco, List<CartaoEntity> cartao, List<String> pix) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cartao = cartao;
        this.pix = pix;
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

    public List<String> getPix() {
        return pix;
    }

    public void setPix(List<String> pix) {
        this.pix = pix;
    }
}
