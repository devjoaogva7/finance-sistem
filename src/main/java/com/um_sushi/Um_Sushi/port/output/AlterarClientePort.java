package com.um_sushi.Um_Sushi.port.output;

import com.um_sushi.Um_Sushi.domain.model.Cartao;
import com.um_sushi.Um_Sushi.domain.model.Cliente;

public interface AlterarClientePort {

    void alterarCartao(Cliente cliente, Cartao cartao);
}
