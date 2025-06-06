package com.finance.repository;

import com.finance.model.Regiao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class RegiaoRepositoryImpl implements RegiaoRepository {
    private final List<Regiao> regioes = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Regiao salvar(Regiao regiao) {
        if (regiao.getId() == null) {
            regiao.setId(idGenerator.getAndIncrement());
            regioes.add(regiao);
        } else {
            regioes.removeIf(r -> r.getId().equals(regiao.getId()));
            regioes.add(regiao);
        }
        return regiao;
    }

    @Override
    public Optional<Regiao> buscarPorId(Long id) {
        return regioes.stream()
                .filter(regiao -> regiao.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Regiao> listarTodos() {
        return new ArrayList<>(regioes);
    }

    @Override
    public void deletar(Long id) {
        regioes.removeIf(regiao -> regiao.getId().equals(id));
    }
} 