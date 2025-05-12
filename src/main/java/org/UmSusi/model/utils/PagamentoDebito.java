package org.UmSusi.model.utils;

import org.UmSusi.interfaces.FormaPagamento;
import org.UmSusi.repository.Entity.PagamentoEntity;

public class PagamentoDebito implements FormaPagamento {

    @Override
    public void processar(PagamentoEntity pagamento) {

    }
}
