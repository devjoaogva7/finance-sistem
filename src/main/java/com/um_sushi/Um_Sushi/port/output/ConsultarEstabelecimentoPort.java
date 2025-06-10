package com.um_sushi.Um_Sushi.port.output;

import com.um_sushi.Um_Sushi.domain.model.Estabelecimento;
import com.um_sushi.Um_Sushi.domain.model.Frete;
import com.um_sushi.Um_Sushi.domain.model.Pedido;

public interface ConsultarEstabelecimentoPort {

    Estabelecimento buscarDadosEstabelicentoPorId(Long id);

    Pedido buscarPedidoPorId(Long id);

    Frete buscarFretePorId(Long idFreteValorUnico);
}
