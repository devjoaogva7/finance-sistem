package com.um_sushi.Um_Sushi.domain.service.validacao;

import com.um_sushi.Um_Sushi.domain.model.Pagamento;

public interface ProcessadorPagamento {

    void processar(Pagamento pagamento);
}
