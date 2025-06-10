package com.um_sushi.Um_Sushi.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estabelecimento {

    private Long cnpj;
    private String nome;
    private String contaBancaria;
    private String endereco;
    private String pixCopiaCola;
    private byte[] imagemQrCode;
}
