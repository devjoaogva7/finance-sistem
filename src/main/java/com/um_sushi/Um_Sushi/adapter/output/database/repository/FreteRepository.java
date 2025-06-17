package com.um_sushi.Um_Sushi.adapter.output.database.repository;

import com.um_sushi.Um_Sushi.adapter.output.database.entity.FreteEntity;
import com.um_sushi.Um_Sushi.domain.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<FreteEntity, Long> {
    FreteEntity findFirstByOrderByIdAsc();
}
