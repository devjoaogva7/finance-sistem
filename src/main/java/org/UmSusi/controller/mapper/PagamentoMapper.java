package org.UmSusi.controller.mapper;

import org.UmSusi.controller.dto.FinalizarPagamentoDTO;
import org.UmSusi.controller.dto.ProcessarPagamentoDTO;
import org.UmSusi.model.FinalizarPagamentoModel;
import org.UmSusi.model.ProcessarPagamentoModel;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface PagamentoMapper {


    ProcessarPagamentoModel toPagamentoModel(ProcessarPagamentoDTO request);

    FinalizarPagamentoModel toFinalizarModel(FinalizarPagamentoDTO request);
}
