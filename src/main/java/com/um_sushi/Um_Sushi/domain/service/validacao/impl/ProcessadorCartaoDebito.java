package com.um_sushi.Um_Sushi.domain.service.validacao.impl;

import com.um_sushi.Um_Sushi.domain.model.Pagamento;
import com.um_sushi.Um_Sushi.domain.service.validacao.ProcessadorPagamento;

public class ProcessadorCartaoDebito implements ProcessadorPagamento {

    @Override
    public void processar(Pagamento pagamento) {
        if (pagamento.getCliente() == null || pagamento.getCliente().getCartao() == null) {
            throw new IllegalStateException("Cartão de débito não cadastrado para este cliente.");
        }

        System.out.println("Processando pagamento com cartão de DÉBITO...");
        System.out.println("Cliente: " + pagamento.getCliente().getNome());
        System.out.println("Número do Cartão: ****-****-****-" + pagamento.getCliente().getCartao());
        System.out.println("Valor a ser debitado: R$ " + pagamento.getValor());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Erro no processamento do cartão de débito.");
        }

        System.out.println("Pagamento com cartão de DÉBITO realizado!");
    }
}
