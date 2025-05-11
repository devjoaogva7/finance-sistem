package org.UmSusi.repository;

import org.UmSusi.repository.Entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
    PedidoEntity findByClienteCpf(Long cpf);
}
