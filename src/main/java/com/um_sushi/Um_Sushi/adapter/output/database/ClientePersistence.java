package com.um_sushi.Um_Sushi.adapter.output.database;

import com.um_sushi.Um_Sushi.adapter.output.database.entity.ClienteEntity;
import com.um_sushi.Um_Sushi.adapter.output.database.mapper.RepositoryMapper;
import com.um_sushi.Um_Sushi.adapter.output.database.repository.ClienteRepository;
import com.um_sushi.Um_Sushi.domain.model.Cartao;
import com.um_sushi.Um_Sushi.domain.model.Cliente;
import com.um_sushi.Um_Sushi.domain.model.ClienteCadastro;
import com.um_sushi.Um_Sushi.port.output.AlterarClientePort;
import com.um_sushi.Um_Sushi.port.output.ConsultarClientePort;
import com.um_sushi.Um_Sushi.port.output.SalvarClientePort;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ClientePersistence implements SalvarClientePort, ConsultarClientePort, AlterarClientePort {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private EntityManager entityManager;

    private RepositoryMapper mapper;

    @Override
    public String salvar(ClienteCadastro request) {
        ClienteEntity cliente = mapper.toSaveClienteEntity(request);
        entityManager.persist(cliente);

        return "Cliente " + cliente.getNome() + " foi cadastrado com sucesso.";
    }

    @Override
    public Optional<Cliente> buscarPorCpf(Long cpf) {
        return repository.findById(cpf).map(mapper::toClienteModelo);
    }

    @Override
    public void alterarCartao(Cliente cliente, Cartao cartao) {
        repository.findById(cliente.getCpf())
                .map(entity -> {
                    mapper.updateCartaoClienteEntity(cartao, entity);
                    return entity;
                })
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado para alterar cartão"));
    }
}
