package com.um_sushi.Um_Sushi.domain.service;

import com.um_sushi.Um_Sushi.domain.model.Pedido;
import com.um_sushi.Um_Sushi.domain.model.Produto;
import com.um_sushi.Um_Sushi.port.input.ConsultarClienteUserCase;
import com.um_sushi.Um_Sushi.port.input.ConsultarEstabelecimentoUserCase;
import com.um_sushi.Um_Sushi.port.input.SalvarEstabelecimentoUserCase;
import com.um_sushi.Um_Sushi.port.output.ConsultarEstabelecimentoPort;
import com.um_sushi.Um_Sushi.port.output.SalvarEstabelecimentoPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstabalecimentoService implements SalvarEstabelecimentoUserCase, ConsultarEstabelecimentoUserCase {

    private final SalvarEstabelecimentoPort salvarEstabelecimentoPort;
    private final ConsultarEstabelecimentoPort consultarEstabelecimentoPort;
    private final ConsultarClienteUserCase consultarClienteUserCase;

    @Override
    @Transactional
    public String salvarPedido(Pedido request) {
        consultarClienteUserCase.buscarPorCpf(request.getCliente().getCpf());
        request.setValor(calcularProdutos(request));
        return salvarEstabelecimentoPort.salvarPedido(request);
    }

    private BigDecimal calcularProdutos(Pedido pedido) {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (Produto p : pedido.getProdutos()) {
            Produto produto = consultarEstabelecimentoPort.buscarProdutoPeloNome(p.getNome()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            valorTotal = valorTotal.add(produto.getPreco().multiply(BigDecimal.valueOf(p.getQuantidade())));
        }
        return valorTotal;
    }

    @Override
    public List<Produto> consultarProdutos() {
        return consultarEstabelecimentoPort.consultarProdutos();
    }
}
