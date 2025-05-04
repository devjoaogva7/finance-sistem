package org.UmSusi.controller.mapper;

import org.UmSusi.controller.dto.PagamentoRequestDTO;
import org.UmSusi.model.PagamentoModel;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface PagamentoMapper {


    PagamentoModel toModel(PagamentoRequestDTO request);
}
