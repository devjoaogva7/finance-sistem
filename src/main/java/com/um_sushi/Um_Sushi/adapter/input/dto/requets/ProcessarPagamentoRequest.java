package com.um_sushi.Um_Sushi.adapter.input.dto.requets;

import com.um_sushi.Um_Sushi.domain.model.enums.EnumCuponsDisponiveis;
import com.um_sushi.Um_Sushi.domain.model.enums.EnumFormaPagamento;
import jakarta.validation.constraints.*; 
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessarPagamentoRequest {

    @NotNull(message = "Forma de pagamento não pode ser nula")
    private EnumFormaPagamento formaPagamento;

    @Min(value = 1, message = "Número de parcelas deve ser no mínimo 1")
    @Max(value = 12, message = "Número de parcelas deve ser no máximo 12") 

    private Integer parcelas; // Pode ser nulo se não for crédito, mas se for crédito, será validado na lógica
                              // de negócio

    // O cupom pode ser nulo se não houver cupom a ser aplicado
    private EnumCuponsDisponiveis cupom;

    @NotNull(message = "CPF não pode ser nulo")
    @Positive(message = "CPF deve ser um número positivo")
    private Long cpf;
}