package org.UmSusi.controller.mapper;

import javax.annotation.processing.Generated;
import org.UmSusi.controller.dto.PagamentoRequestDTO;
import org.UmSusi.repository.Entity.PagamentoEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T20:36:15-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class PagamentoMapperImpl implements PagamentoMapper {

    @Override
    public PagamentoEntity toEntity(PagamentoRequestDTO pagamentoDTO) {
        if ( pagamentoDTO == null ) {
            return null;
        }

        PagamentoEntity pagamentoEntity = new PagamentoEntity();

        return pagamentoEntity;
    }
}
