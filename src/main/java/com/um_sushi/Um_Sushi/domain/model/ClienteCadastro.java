package com.um_sushi.Um_Sushi.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ClienteCadastro {

    private Long cpf;
    private String nome;
    private String email;
    private String telefone;
    private Endereco endereco;
    private Cartao cartao;

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class Endereco {
        private Long id;
        private String rua;
        private Integer numero;
        private Integer cep;
        private String cidade;
        private String bairro;
        private String uf;
    }
}
