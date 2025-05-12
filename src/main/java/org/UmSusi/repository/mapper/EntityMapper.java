package org.UmSusi.repository.mapper;

import org.UmSusi.model.ClienteModel;
import org.UmSusi.model.ProcessarPagamentoModel;
import org.UmSusi.model.enuns.EnumStatus;
import org.UmSusi.repository.Entity.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class EntityMapper {

    public EntityMapper() {
    }

    public PagamentoEntity toPagamentoEntity(ProcessarPagamentoModel model, BigDecimal valorTotal, ClienteEntity cliente, EstabelecimentoEntity estabelecimento, FreteEntity frete, PedidoEntity pedido) {
        PagamentoEntity pagamento = new PagamentoEntity();

        pagamento.setValor(valorTotal);
        pagamento.setStatus(EnumStatus.PENDENTE.getDescricao());
        pagamento.setDatahora(LocalDateTime.now());
        pagamento.setFormaPagamento(model.getFormaPagamento().getDescricao());
        pagamento.setCliente(cliente);
        pagamento.setEstabelecimento(estabelecimento);
        pagamento.setCupom(model.getCupom().getNome());
        pagamento.setFrete(frete);
        pagamento.setPedido(pedido);

        return pagamento;
    }

    public ClienteEntity toClienteEntity(ClienteModel model) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setCpf(model.getCpf());
        cliente.setNome(model.getNome());
        cliente.setTelefone(model.getTelefone());
        cliente.setEndereco(model.getEndereco());
        cliente.setEmail(model.getEmail());
        return cliente;
    }
}
