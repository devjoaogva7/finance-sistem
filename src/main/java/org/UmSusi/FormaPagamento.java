package org.UmSusi;

public interface FormaPagamento {

    //vai validar a chave pix, o cvv e
    void validarDados();

    void autenticar();

    // Vai retornar o tipo do meio de pagamento (Pix, Credito, Debito)
    String getTipo();

    // Vai mostrar todos os dados que comprovem o pagamento
    String comprovante();
}