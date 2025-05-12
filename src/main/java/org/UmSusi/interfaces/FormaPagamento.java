package org.UmSusi.interfaces;

import org.UmSusi.repository.Entity.PagamentoEntity;

public interface FormaPagamento {

    void processar(PagamentoEntity pagamento);
} 