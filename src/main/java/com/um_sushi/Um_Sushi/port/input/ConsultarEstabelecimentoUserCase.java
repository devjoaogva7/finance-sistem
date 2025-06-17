package com.um_sushi.Um_Sushi.port.input;

import com.um_sushi.Um_Sushi.domain.model.Pedido;
import com.um_sushi.Um_Sushi.domain.model.Produto;

import java.util.List;

public interface ConsultarEstabelecimentoUserCase {

    List<Produto> consultarProdutos();
}
