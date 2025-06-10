package com.um_sushi.Um_Sushi.adapter.input.mapper;

import com.um_sushi.Um_Sushi.adapter.input.dto.PedidoRequest;
import com.um_sushi.Um_Sushi.adapter.input.dto.PedidoResponse;
import com.um_sushi.Um_Sushi.domain.model.Pedido;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface EstabelecimentoMapper {

    Pedido toPedidoRequest(PedidoRequest request);

    PedidoResponse toPedidoResponse(Pedido response);
}
