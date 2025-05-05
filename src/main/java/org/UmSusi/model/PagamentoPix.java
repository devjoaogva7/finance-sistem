package org.UmSusi.model;

import org.UmSusi.model.enuns.EnumFormaPagamento;

public class PagamentoPix implements FormaPagamento {
    private String chavePix;
    private String qrCode;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
        this.qrCode = gerarQrCode();
    }

    @Override
    public boolean processarPagamento(double valor) {
        // Aqui seria implementada a lógica real de processamento do PIX
        // Por enquanto, vamos apenas simular um pagamento bem-sucedido
        return true;
    }

    @Override
    public String gerarComprovante() {
        return String.format("Comprovante PIX\nChave: %s\nQR Code: %s", chavePix, qrCode);
    }

    @Override
    public EnumFormaPagamento getTipoPagamento() {
        return EnumFormaPagamento.PIX;
    }

    private String gerarQrCode() {
        // Aqui seria implementada a geração real do QR Code
        // Por enquanto, vamos retornar um valor simulado
        return "00020126580014BR.GOV.BCB.PIX0136123e4567-e89b-12d3-a456-426614174000520400005303986540510.005802BR5913Teste%20Loja%206008BRASILIA62070503***6304E2CA";
    }

    public String getChavePix() {
        return chavePix;
    }

    public String getQrCode() {
        return qrCode;
    }
} 