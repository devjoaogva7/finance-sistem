package com.finance.model;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private Regiao regiao;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, Regiao regiao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.regiao = regiao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }
} 