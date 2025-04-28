package org.UmSusi.controller.dto;

import org.UmSusi.model.enuns.EnumCuponsDisponiveis;
import org.UmSusi.model.enuns.EnumFormaPagamento;

import java.util.List;

public class PagamentoRequestDTO {

    private String formaPagamento;
    private ClienteRequest cliente;
    private String cupom;
    private List<PedidoRequest> pedidos;

    public static class PedidoRequest{
        private String nome;
    }

    public static class ClienteRequest{
        private Long cpf;
        private String nome;
        private String email;
        private String telefone;
        private String endereco;
    }
}
