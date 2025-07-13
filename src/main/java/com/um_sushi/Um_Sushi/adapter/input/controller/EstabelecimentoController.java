package com.um_sushi.Um_Sushi.adapter.input.controller;

import com.um_sushi.Um_Sushi.adapter.input.dto.requets.PedidoRequest;
import com.um_sushi.Um_Sushi.adapter.input.dto.responses.PedidoResponse;
import com.um_sushi.Um_Sushi.adapter.input.dto.responses.ProdutoResponse;
import com.um_sushi.Um_Sushi.adapter.input.mapper.EstabelecimentoMapper;
import com.um_sushi.Um_Sushi.port.input.ConsultarEstabelecimentoUserCase;
import com.um_sushi.Um_Sushi.port.input.SalvarEstabelecimentoUserCase;
import jakarta.validation.Valid; // Adicionar este import
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/um-sushi")
public class EstabelecimentoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EstabelecimentoController.class);

    private final SalvarEstabelecimentoUserCase salvarEstabelecimentoUserCase;
    private final ConsultarEstabelecimentoUserCase consultasEstabelecimentoUserCase;

    private final EstabelecimentoMapper mapper;

    @PostMapping("/pedido")
    public ResponseEntity<PedidoResponse> salvarPedido(@Valid @RequestBody PedidoRequest request) {
        LOGGER.info("Fazendo pedido: " + request);

        String id = salvarEstabelecimentoUserCase
                .salvarPedido(mapper.toPedidoRequest(request));

        return ResponseEntity.status(HttpStatus.OK).body(PedidoResponse.builder().id(id).build());
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoResponse>> listarProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toListProdutos(
                consultasEstabelecimentoUserCase.consultarProdutos()));
    }
}