package org.UmSusi.model.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.UmSusi.interfaces.FormaPagamento;
import org.UmSusi.repository.Entity.EstabelecimentoEntity;
import org.UmSusi.repository.Entity.PagamentoEntity;

import java.io.ByteArrayOutputStream;

public class PagamentoPix implements FormaPagamento {

    @Override
    public void processar(PagamentoEntity pagamento) {

    }

    private byte[] gerarImagemQrCode() {

        EstabelecimentoEntity estabelecimento = new EstabelecimentoEntity();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            BitMatrix matrix = new QRCodeWriter().encode(estabelecimento.getPixCopiaCola(), BarcodeFormat.QR_CODE, 250, 250);
            MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar imagem do QR Code", e);
        }
    }
}
