package org.UmSusi.repository;

import org.UmSusi.repository.Entity.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaPagamentoRepository extends JpaRepository<PagamentoEntity, Long> {
}
