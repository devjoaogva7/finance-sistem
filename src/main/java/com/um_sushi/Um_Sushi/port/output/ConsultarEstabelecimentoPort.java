package com.um_sushi.Um_Sushi.port.output;

import com.um_sushi.Um_Sushi.domain.model.Estabelecimento;
import com.um_sushi.Um_Sushi.domain.model.Frete;
import com.um_sushi.Um_Sushi.domain.model.Pedido;

public interface ConsultarEstabelecimentoPort {

    Estabelecimento buscarDadosEstabelicentoPorId(Long id);

    Pedido buscarPedidoPorCpfCliente(Long cpf);

    Frete buscarFretePorId(Long idFreteValorUnico);
}
