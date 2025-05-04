package org.UmSusi.repository.mapper;

import org.UmSusi.model.ClienteModel;
import org.UmSusi.model.PagamentoModel;
import org.UmSusi.model.enuns.EnumStatus;
import org.UmSusi.repository.Entity.ClienteEntity;
import org.UmSusi.repository.Entity.PagamentoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EntityMapper {

    public EntityMapper() {
    }

    public PagamentoEntity toPagamentoEntity(PagamentoModel model) {
        PagamentoEntity pagamento = new PagamentoEntity();
        pagamento.setStatus(EnumStatus.PENDENTE.getDescricao());
        pagamento.setDatahora(LocalDateTime.now());
        pagamento.setCupom(model.getCupom().getNome());
        pagamento.setFormaPagamento(model.getFormaPagamento().getDescricao());
        pagamento.setCliente(toClienteEntity(model.getCliente()));
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
