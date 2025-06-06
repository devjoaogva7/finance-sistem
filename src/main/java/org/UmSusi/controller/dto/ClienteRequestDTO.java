package org.UmSusi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {

    private Long cpf;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
}
