package com.um_sushi.Um_Sushi.adapter.output.database.repository;

import com.um_sushi.Um_Sushi.adapter.output.database.entity.EstabelecimentoEntity;
import com.um_sushi.Um_Sushi.domain.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoEntity, Long> {

    EstabelecimentoEntity findFirstByOrderByCnpjAsc();
}
