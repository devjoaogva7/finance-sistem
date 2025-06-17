package com.um_sushi.Um_Sushi.adapter.input.mapper;

import com.um_sushi.Um_Sushi.adapter.input.dto.requets.CartaoRequest;
import com.um_sushi.Um_Sushi.adapter.input.dto.requets.FinalizarPagamentoRequest;
import com.um_sushi.Um_Sushi.adapter.input.dto.requets.ProcessarPagamentoRequest;
import com.um_sushi.Um_Sushi.domain.model.Cartao;
import com.um_sushi.Um_Sushi.domain.model.FinalizarPagamento;
import com.um_sushi.Um_Sushi.domain.model.ProcessarPagamento;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface PagamentoMapper {

    Cartao toCartaoRequest(CartaoRequest request);

    ProcessarPagamento toProcessarPagamentoRequest(ProcessarPagamentoRequest request);

    FinalizarPagamento toFinalizarPagamentoRequest(FinalizarPagamentoRequest request);
}
