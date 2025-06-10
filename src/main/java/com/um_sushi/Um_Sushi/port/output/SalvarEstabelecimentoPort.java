package com.um_sushi.Um_Sushi.port.output;

import com.um_sushi.Um_Sushi.domain.model.Pedido;

public interface SalvarEstabelecimentoPort {

    Pedido salvarPedido(Pedido request);
}
