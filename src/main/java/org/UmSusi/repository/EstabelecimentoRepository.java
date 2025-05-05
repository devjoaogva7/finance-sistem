package org.UmSusi.repository;

import org.UmSusi.repository.Entity.EstabelecimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoEntity, Long> {
}
