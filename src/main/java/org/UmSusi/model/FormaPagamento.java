package org.UmSusi.model;

import org.UmSusi.model.enuns.EnumFormaPagamento;

public interface FormaPagamento {
    boolean processarPagamento(double valor);
    String gerarComprovante();
    EnumFormaPagamento getTipoPagamento();
} 