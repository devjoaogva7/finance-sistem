package com.um_sushi.Um_Sushi.adapter.input.mapper;

import com.um_sushi.Um_Sushi.adapter.input.dto.requets.PedidoRequest;
import com.um_sushi.Um_Sushi.adapter.input.dto.responses.PedidoResponse;
import com.um_sushi.Um_Sushi.adapter.input.dto.responses.ProdutoResponse;
import com.um_sushi.Um_Sushi.domain.model.Pedido;
import com.um_sushi.Um_Sushi.domain.model.Produto;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface EstabelecimentoMapper {

    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "produtos", source = "produtos")
    Pedido toPedidoRequest(PedidoRequest request);

    PedidoResponse toPedidoResponse(Pedido response);

    List<ProdutoResponse> toListProdutos(List<Produto> produtos);
}
