package com.um_sushi.Um_Sushi.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Long cpf;
    private String nome;
    private String email;
    private String telefone;
    private ClienteCadastro.Endereco endereco;
    private Cartao cartao;
}
