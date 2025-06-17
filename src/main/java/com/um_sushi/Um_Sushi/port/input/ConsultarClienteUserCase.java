package com.um_sushi.Um_Sushi.port.input;

import com.um_sushi.Um_Sushi.domain.model.Cliente;

import java.util.Optional;

public interface ConsultarClienteUserCase {

    Optional<Cliente> buscarPorCpf(Long cpf);
}
