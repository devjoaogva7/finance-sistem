package com.um_sushi.Um_Sushi.port.input;

import com.um_sushi.Um_Sushi.domain.model.FinalizarPagamento;

public interface FinalizarPagamentoUserCase {

    String finalizarPagamento(FinalizarPagamento request);
}
