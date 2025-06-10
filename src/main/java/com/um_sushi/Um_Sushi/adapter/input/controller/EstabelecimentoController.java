package com.um_sushi.Um_Sushi.adapter.input.controller;

import com.um_sushi.Um_Sushi.adapter.input.dto.PedidoRequest;
import com.um_sushi.Um_Sushi.adapter.input.dto.PedidoResponse;
import com.um_sushi.Um_Sushi.adapter.input.mapper.EstabelecimentoMapper;
import com.um_sushi.Um_Sushi.port.input.SalvarEstabelecimentoUserCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/um-sushi")
public class EstabelecimentoController {

    private SalvarEstabelecimentoUserCase salvarEstabelecimentoUserCase;
    private EstabelecimentoMapper mapper;

    @PostMapping("/pedido")
    public ResponseEntity<PedidoResponse> salvarPedido(@RequestBody PedidoRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toPedidoResponse(salvarEstabelecimentoUserCase
                .salvarPedido(mapper.toPedidoRequest(request))));
    }
}
