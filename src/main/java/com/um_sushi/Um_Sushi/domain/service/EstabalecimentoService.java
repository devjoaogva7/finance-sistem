package com.um_sushi.Um_Sushi.domain.service;

import com.um_sushi.Um_Sushi.domain.model.Pedido;
import com.um_sushi.Um_Sushi.port.input.ConsultarEstabelecimentoUserCase;
import com.um_sushi.Um_Sushi.port.input.SalvarEstabelecimentoUserCase;
import com.um_sushi.Um_Sushi.port.output.ConsultarEstabelecimentoPort;
import com.um_sushi.Um_Sushi.port.output.SalvarEstabelecimentoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstabalecimentoService implements SalvarEstabelecimentoUserCase, ConsultarEstabelecimentoUserCase {

    private SalvarEstabelecimentoPort salvarEstabelecimentoPort;
    private ConsultarEstabelecimentoPort consultarEstabelecimentoPort;

    @Override
    public Pedido salvarPedido(Pedido request) {
        return salvarEstabelecimentoPort.salvarPedido(request);
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        //Todo implementar a busca e colocar validação se aquele usuario é dono pedido atraves do cpf
        return null;
    }
}
