package org.UmSusi.controller.mapper;

import org.UmSusi.controller.dto.PagamentoRequestDTO;
import org.UmSusi.repository.Entity.PagamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {

    PagamentoMapper INSTANCE = Mappers.getMapper(PagamentoMapper.class);

    // Mapeia PagamentoDTO para Pagamento
    PagamentoEntity toEntity(PagamentoRequestDTO pagamentoDTO);
}
