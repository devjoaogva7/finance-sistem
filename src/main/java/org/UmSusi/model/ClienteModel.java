package org.UmSusi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {
    private Long cpf;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
}
