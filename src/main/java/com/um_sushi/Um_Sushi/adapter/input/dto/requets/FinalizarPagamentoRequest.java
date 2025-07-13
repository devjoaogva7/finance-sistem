package com.um_sushi.Um_Sushi.adapter.input.dto.requets;

import com.um_sushi.Um_Sushi.domain.model.enums.EnumConfirmacaoPagamento;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinalizarPagamentoRequest {

    @NotNull(message = "ID do pagamento não pode ser nulo")
    @Positive(message = "ID do pagamento deve ser um número positivo")
    private Long idPagamento;

    @NotNull(message = "Confirmação não pode ser nula")
    private EnumConfirmacaoPagamento confirmacao;
}