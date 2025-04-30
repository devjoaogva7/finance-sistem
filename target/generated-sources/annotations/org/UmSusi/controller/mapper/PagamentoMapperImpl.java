package org.UmSusi.controller.mapper;

import javax.annotation.processing.Generated;
import org.UmSusi.controller.dto.PagamentoRequestDTO;
import org.UmSusi.repository.Entity.PagamentoEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-29T19:31:30-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
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
