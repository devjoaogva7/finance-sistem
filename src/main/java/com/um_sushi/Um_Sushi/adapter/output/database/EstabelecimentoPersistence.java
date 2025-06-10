package com.um_sushi.Um_Sushi.adapter.output.database;

import com.um_sushi.Um_Sushi.adapter.output.database.mapper.RepositoryMapper;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.EstabelecimentoRepository;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.FreteRepository;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.PagamentoRepository;
import com.um_sushi.Um_Sushi.domain.model.Estabelecimento;
import com.um_sushi.Um_Sushi.domain.model.Frete;
import com.um_sushi.Um_Sushi.domain.model.Pedido;
import com.um_sushi.Um_Sushi.port.output.ConsultarEstabelecimentoPort;
import com.um_sushi.Um_Sushi.port.output.SalvarEstabelecimentoPort;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EstabelecimentoPersistence implements ConsultarEstabelecimentoPort, SalvarEstabelecimentoPort {

    @Autowired
    private FreteRepository freteRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
    @Autowired
    private EntityManager entityManager;
    private RepositoryMapper mapper;

    @Override
    public Pedido salvarPedido(Pedido request) {
        //TODO concertar
        // PedidoEntity pedido = mapper.toSavePedidoEntity(request);
        //entityManager.persist(pedido);
        return null; //Todo mapper  implementar o resto;
    }

    @Override
    public Estabelecimento buscarDadosEstabelicentoPorId(Long id) {

        //TODO buscar estabelecimento com findFirstByOrderByCnpjAsc() do repositorio de estabelecimento
        return null;
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        //Todo implementar
        return null;
    }


    @Override
    public Frete buscarFretePorId(Long idFreteValorUnico) {
        //TODO buscar estabelecimento com findFirstByOrderByCnpjAsc() do repositorio de estabelecimento
        return null;
    }
}
