package com.finance.repository;

import com.finance.model.Regiao;
import java.util.List;
import java.util.Optional;

public interface RegiaoRepository {
    Regiao salvar(Regiao regiao);
    Optional<Regiao> buscarPorId(Long id);
    List<Regiao> listarTodos();
    void deletar(Long id);
} 