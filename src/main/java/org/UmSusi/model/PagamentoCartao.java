package org.UmSusi.model;

import org.UmSusi.interfaces.FormaPagamento;
import org.UmSusi.model.enuns.EnumFormaPagamento;

public class PagamentoCartao implements FormaPagamento {

    @Override
    public void processar(String confirmacao) {
        if (confirmacao.equals(EnumFormaPagamento.CREDITO.getDescricao())) {
        }
    }
}
