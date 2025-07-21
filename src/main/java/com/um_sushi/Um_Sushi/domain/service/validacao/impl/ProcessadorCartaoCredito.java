package com.um_sushi.Um_Sushi.domain.service.validacao.impl;

import com.um_sushi.Um_Sushi.domain.model.Pagamento;
import com.um_sushi.Um_Sushi.domain.service.validacao.ProcessadorPagamento;

public class ProcessadorCartaoCredito implements ProcessadorPagamento {

    @Override
    public void processar(Pagamento pagamento) {
        if (pagamento.getCliente() == null) {
            throw new IllegalStateException("Cartão de crédito não cadastrado para este cliente.");
        }

        System.out.println("Processando pagamento com cartão de CRÉDITO...");
        System.out.println("Cliente: " + pagamento.getCliente().getNome());
        System.out.println("Número do Cartão: ****-****-****-" + pagamento.getCliente().getCartao().getNumero());
        System.out.println("Valor a ser cobrado: R$ " + pagamento.getValor());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Erro no processamento do cartão de crédito.");
        }

        System.out.println("Pagamento com cartão de CRÉDITO aprovado!");
    }
}
