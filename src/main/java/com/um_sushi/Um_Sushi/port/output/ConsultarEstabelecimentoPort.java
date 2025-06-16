package com.um_sushi.Um_Sushi.port.output;

import com.um_sushi.Um_Sushi.domain.model.Estabelecimento;
import com.um_sushi.Um_Sushi.domain.model.Frete;
import com.um_sushi.Um_Sushi.domain.model.Pedido;
import com.um_sushi.Um_Sushi.domain.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ConsultarEstabelecimentoPort {

    Optional<Estabelecimento> buscarDadosEstabelicentoPorId(Long id);

    Optional<Frete> buscarFretePorId(Long idFreteValorUnico);

    Optional<Pedido> buscarPedidoPorCpfCliente(Long cpf);

    Optional<Produto> buscarProdutoPeloNome(String nome);

    List<Produto> consultarProdutos();
}
