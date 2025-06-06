package com.finance.repository;

import com.finance.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class ClienteRepositoryImpl implements ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Cliente salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(idGenerator.getAndIncrement());
            clientes.add(cliente);
        } else {
            clientes.removeIf(c -> c.getId().equals(cliente.getId()));
            clientes.add(cliente);
        }
        return cliente;
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    @Override
    public void deletar(Long id) {
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }
} 