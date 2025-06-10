package com.um_sushi.Um_Sushi.port.input;

import com.um_sushi.Um_Sushi.domain.model.Pedido;

public interface SalvarEstabelecimentoUserCase {

    Pedido salvarPedido(Pedido request);
}
