package com.um_sushi.Um_Sushi.adapter.output.database;

import com.um_sushi.Um_Sushi.adapter.output.database.entity.PedidoEntity;
import com.um_sushi.Um_Sushi.adapter.output.database.mapper.RepositoryMapper;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.*;
import com.um_sushi.Um_Sushi.domain.model.Estabelecimento;
import com.um_sushi.Um_Sushi.domain.model.Frete;
import com.um_sushi.Um_Sushi.domain.model.Pedido;
import com.um_sushi.Um_Sushi.domain.model.Produto;
import com.um_sushi.Um_Sushi.port.output.ConsultarEstabelecimentoPort;
import com.um_sushi.Um_Sushi.port.output.SalvarEstabelecimentoPort;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EntityManager entityManager;

    private RepositoryMapper mapper;

    @Override
    public String salvarPedido(Pedido request) {

        PedidoEntity pedido = mapper.toSavePedidoEntity(request);
        entityManager.persist(pedido);
        return "Id do pedido: " + pedido.getId();
    }

    @Override
    public Optional<Estabelecimento >buscarDadosEstabelicentoPorId(Long id) {
        return Optional.ofNullable(mapper.toEstabelecimentoModel(estabelecimentoRepository.findFirstByOrderByCnpjAsc()));
    }

    @Override
    public Optional<Frete> buscarFretePorId(Long id) {

        return Optional.ofNullable(mapper.toFreteModel(freteRepository.findFirstByOrderByIdAsc()));
    }

    @Override
    public Optional<Pedido> buscarPedidoPorCpfCliente(Long cpf) {
        return Optional.ofNullable(mapper.toPedidoModel(pedidoRepository.findByClienteCpf(cpf)));
    }

    @Override
    public Optional<Produto> buscarProdutoPeloNome(String nome) {
        return Optional.ofNullable(mapper.toProdutoModel(produtoRepository.findByNome(nome)));
    }

    @Override
    public List<Produto> consultarProdutos() {
        return mapper.toListProdutosModel(produtoRepository.findAll());
    }
}
