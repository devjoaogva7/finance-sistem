package com.um_sushi.Um_Sushi.port.output;

import com.um_sushi.Um_Sushi.domain.model.Pagamento;

import java.util.Optional;

public interface ConsultarPagamentoPort {
    Optional<Pagamento> consultarPeloId(Long id);
}
