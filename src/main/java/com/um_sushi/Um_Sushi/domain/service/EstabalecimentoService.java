package com.um_sushi.Um_Sushi.domain.service;

import com.um_sushi.Um_Sushi.domain.model.Pedido;
import com.um_sushi.Um_Sushi.port.input.SalvarEstabelecimentoUserCase;
import com.um_sushi.Um_Sushi.port.output.SalvarEstabelecimentoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstabalecimentoService implements SalvarEstabelecimentoUserCase {

    private SalvarEstabelecimentoPort salvarEstabelecimentoPort;

    @Override
    public Pedido salvarPedido(Pedido request) {
        return salvarEstabelecimentoPort.salvarPedido(request);
    }
}
