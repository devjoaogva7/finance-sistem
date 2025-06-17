package com.um_sushi.Um_Sushi.adapter.output.database.repository;

import com.um_sushi.Um_Sushi.adapter.output.database.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    PedidoEntity findByClienteCpf(Long cpf);
}
