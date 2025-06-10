package com.um_sushi.Um_Sushi.port.input;

import com.um_sushi.Um_Sushi.adapter.input.dto.ProcessarPagamentoResponse;
import com.um_sushi.Um_Sushi.domain.model.ProcessarPagamento;

public interface ProcessarPagamentoUserCase {
    String processarPagamento(ProcessarPagamento request);
}
