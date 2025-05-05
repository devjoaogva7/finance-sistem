package org.UmSusi.model;

public class QrCodeResponseModel {
    private String qrCodeBase64;
    private String codigoPix;

    public QrCodeResponseModel(String qrCodeBase64, String codigoPix) {
        this.qrCodeBase64 = qrCodeBase64;
        this.codigoPix = codigoPix;
    }

    // Getters e Setters
    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }

    public String getCodigoPix() {
        return codigoPix;
    }

    public void setCodigoPix(String codigoPix) {
        this.codigoPix = codigoPix;
    }
}
