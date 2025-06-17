package com.um_sushi.Um_Sushi.port.output;

import com.um_sushi.Um_Sushi.domain.model.Cliente;

import java.util.Optional;

public interface ConsultarClientePort {
    Optional<Cliente> buscarPorCpf(Long cpf);
}
