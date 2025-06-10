package com.um_sushi.Um_Sushi.adapter.input.controller;

import com.um_sushi.Um_Sushi.adapter.input.dto.ClienteCadastroRequest;
import com.um_sushi.Um_Sushi.adapter.input.dto.ClienteCadastroResponse;
import com.um_sushi.Um_Sushi.adapter.input.mapper.ClienteMapper;
import com.um_sushi.Um_Sushi.port.input.SalvarClienteUserCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/cliente")
public class ClienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    private final SalvarClienteUserCase salvarClienteUserCase;

    private final ClienteMapper mapper;

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteCadastroResponse> salvar(@RequestBody ClienteCadastroRequest request) {
        LOGGER.info("Recebendo operação para cadastrar cliente: " + request);

        String menssagem = salvarClienteUserCase.salvar(mapper.toCadastroRequest(request));

        return ResponseEntity.status(HttpStatus.OK).body(ClienteCadastroResponse.builder().menssagem(menssagem).build());
    }


}
