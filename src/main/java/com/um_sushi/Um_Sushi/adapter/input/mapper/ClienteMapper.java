package com.um_sushi.Um_Sushi.adapter.input.mapper;

import com.um_sushi.Um_Sushi.adapter.input.dto.requets.ClienteCadastroRequest;
import com.um_sushi.Um_Sushi.domain.model.ClienteCadastro;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ClienteMapper {

    ClienteCadastro toCadastroRequest(ClienteCadastroRequest request);
}
