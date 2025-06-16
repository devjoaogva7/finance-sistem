package com.um_sushi.Um_Sushi.adapter.output.database;

import com.um_sushi.Um_Sushi.adapter.output.database.entity.*;
import com.um_sushi.Um_Sushi.adapter.output.database.mapper.RepositoryMapper;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.EstabelecimentoRepository;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.FreteRepository;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.PagamentoRepository;
import com.um_sushi.Um_Sushi.domain.model.*;
import com.um_sushi.Um_Sushi.port.output.FinalizarPagamentoPort;
import com.um_sushi.Um_Sushi.port.output.ProcessarPagamentoPort;
import com.um_sushi.Um_Sushi.port.output.SalvarCartaoPort;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class PagamentoPersistence implements SalvarCartaoPort, ProcessarPagamentoPort, FinalizarPagamentoPort {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private EntityManager entityManager;
    private RepositoryMapper mapper;

    @Override
    public Cartao salvar(Cartao request) {
        CartaoEntity cartao = mapper.toSaveCartaoEntity(request);
        entityManager.persist(cartao);
        return Cartao.builder()
                .numero(cartao.getNumero())
                .nomeTitular(cartao.getNomeTitular())
                .validade(cartao.getValidade())
                .cvv(cartao.getCvv())
                .bandeira(cartao.getBandeira())
                .build();
    }

    @Override
    public String salvar(ProcessarPagamento request, BigDecimal valorTotal, Cliente cliente, Estabelecimento estabelecimento, Frete frete, Pedido pedido) {


        PagamentoEntity pagamento = mapper.toSavePagamentoEntity(request, valorTotal, cliente, estabelecimento, frete, pedido);
        PedidoEntity pedidoGerenciado = entityManager.merge(mapper.toSavePedidoEntity(pedido));
        pagamento.setPedido(pedidoGerenciado);
        entityManager.persist(pagamento);

        return "Pagamento processado com ID: " + pagamento.getId() + ". Status: \"PENDENTE\", aguardando confirmação.";
    }
}
