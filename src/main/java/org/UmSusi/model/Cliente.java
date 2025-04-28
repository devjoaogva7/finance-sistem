package org.UmSusi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cpf;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Cartao> cartao;
    private List<String> pix;


}
