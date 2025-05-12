package org.UmSusi.repository;

import org.UmSusi.repository.Entity.FreteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreteRepository extends JpaRepository<FreteEntity, Long> {
    FreteEntity findFirstByOrderByIdAsc();
}
