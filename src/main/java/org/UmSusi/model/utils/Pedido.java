package org.UmSusi.model.utils;

import org.UmSusi.repository.Entity.FreteEntity;
import org.UmSusi.repository.Entity.PedidoEntity;
import org.UmSusi.repository.Entity.ProdutoEntity;

import java.math.BigDecimal;

public class Pedido {

    public static BigDecimal calcularValorTotalPedido(PedidoEntity pedido, FreteEntity frete) {
        BigDecimal valor = BigDecimal.ZERO;
        for (ProdutoEntity produto : pedido.getProdutoEntities()) {
            valor = valor.add(produto.getPreco().multiply(BigDecimal.valueOf(produto.getQuantidade()))).add(frete.getPreco());
        }

        return valor;
    }
}
