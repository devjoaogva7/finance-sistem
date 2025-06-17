package com.um_sushi.Um_Sushi.adapter.output.database.repository;

import com.um_sushi.Um_Sushi.adapter.output.database.entity.ProdutoEntity;
import com.um_sushi.Um_Sushi.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    ProdutoEntity findByNome(String nome);
}
