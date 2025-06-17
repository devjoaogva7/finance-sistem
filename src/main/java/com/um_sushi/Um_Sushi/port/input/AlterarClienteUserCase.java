package com.um_sushi.Um_Sushi.port.input;

import com.um_sushi.Um_Sushi.domain.model.Cartao;
import com.um_sushi.Um_Sushi.domain.model.Cliente;

public interface AlterarClienteUserCase {

    void alterarCartao(Cliente cliente, Cartao cartao);
}
