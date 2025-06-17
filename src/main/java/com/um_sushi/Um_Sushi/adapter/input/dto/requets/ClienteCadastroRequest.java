package com.um_sushi.Um_Sushi.adapter.input.dto.requets;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ClienteCadastroRequest {

    private Long cpf;
    private String nome;
    private String email;
    private String telefone;
    private EnderecoRequest endereco;

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class EnderecoRequest {
        private String rua;
        private Integer numero;
        private Integer cep;
        private String cidade;
        private String bairro;
        private String uf;
    }
}
