package com.um_sushi.Um_Sushi.adapter.output.database;

import com.um_sushi.Um_Sushi.adapter.output.database.entity.*;
import com.um_sushi.Um_Sushi.adapter.output.database.mapper.RepositoryMapper;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.EstabelecimentoRepository;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.FreteRepository;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.PagamentoRepository;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.PedidoRepository;
import com.um_sushi.Um_Sushi.domain.model.*;
import com.um_sushi.Um_Sushi.port.output.ConsultarPagamentoPort;
import com.um_sushi.Um_Sushi.port.output.FinalizarPagamentoPort;
import com.um_sushi.Um_Sushi.port.output.ProcessarPagamentoPort;
import com.um_sushi.Um_Sushi.port.output.SalvarCartaoPort;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PagamentoPersistence implements SalvarCartaoPort, ProcessarPagamentoPort, FinalizarPagamentoPort, ConsultarPagamentoPort {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
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
        pagamento.setId(null);
        PedidoEntity pedidoGerenciado = pedidoRepository.findById(pedido.getId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pagamento.setPedido(pedidoGerenciado);
        entityManager.persist(pagamento);

        return "Pagamento processado com ID: " + pagamento.getId() + ". Status: \"PENDENTE\", aguardando confirmação.";
    }

    @Override
    public Optional<Pagamento> alterarPagamento(Pagamento pagamento) {

        PagamentoEntity existente = pagamentoRepository.findById(pagamento.getId())
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        mapper.updatePagamentoEntityFromModel(pagamento, existente);

        if (pagamento.getPedido() != null) {
            PedidoEntity pedido = pedidoRepository.findById(pagamento.getPedido().getId())
                    .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
            existente.setPedido(pedido);
        }

        PagamentoEntity atualizado = pagamentoRepository.save(existente);
        return Optional.of(mapper.toModelPagamento(atualizado));
    }

    @Override
    public Optional<Pagamento> consultarPeloId(Long id) {
        return pagamentoRepository.findById(id)
                .map(mapper::toModelPagamento);
    }
}
