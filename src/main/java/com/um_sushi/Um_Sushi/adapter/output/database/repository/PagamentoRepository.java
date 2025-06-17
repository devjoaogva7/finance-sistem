package com.um_sushi.Um_Sushi.adapter.output.database.repository;

import com.um_sushi.Um_Sushi.adapter.output.database.entity.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Long> {
}
