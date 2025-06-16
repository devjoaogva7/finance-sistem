package com.um_sushi.Um_Sushi.adapter.input.controller;

import com.um_sushi.Um_Sushi.adapter.input.dto.requets.CartaoRequest;
import com.um_sushi.Um_Sushi.adapter.input.dto.requets.FinalizarPagamentoRequest;
import com.um_sushi.Um_Sushi.adapter.input.dto.requets.ProcessarPagamentoRequest;
import com.um_sushi.Um_Sushi.adapter.input.dto.responses.ProcessarPagamentoResponse;
import com.um_sushi.Um_Sushi.adapter.input.mapper.PagamentoMapper;
import com.um_sushi.Um_Sushi.port.input.FinalizarPagamentoUserCase;
import com.um_sushi.Um_Sushi.port.input.ProcessarPagamentoUserCase;
import com.um_sushi.Um_Sushi.port.input.SalvarCartaoUserCase;
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
@RequestMapping(value = "/v1/pagamento")
public class PagamentoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PagamentoController.class);

    private final SalvarCartaoUserCase salvarCartaoUserCase;
    private final ProcessarPagamentoUserCase processarPagamentoUserCase;
    private final FinalizarPagamentoUserCase finalizarPagamentoUserCase;

    private final PagamentoMapper mapper;

    @PostMapping("/cadastrar-cartao")
    public ResponseEntity<Void> salvarCartao(@RequestBody CartaoRequest request) {
        LOGGER.info("Recebendo operação para cadastrar cartao do cliente: " + request);

        salvarCartaoUserCase.salvar(mapper.toCartaoRequest(request));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/processando")
    public ResponseEntity<ProcessarPagamentoResponse> processarPagamento(@RequestBody ProcessarPagamentoRequest request) {
        LOGGER.info("Dados para iniciar o processamento do pagamento: " + request);

        String m = processarPagamentoUserCase.processarPagamento(mapper.toProcessarPagamentoRequest(request));

        return ResponseEntity.status(HttpStatus.OK).body(ProcessarPagamentoResponse.builder().menssagem(m).build());
    }

    @PostMapping("/finalizar")
    public ResponseEntity<String> finalizarPagamento(@RequestBody FinalizarPagamentoRequest request) {
        LOGGER.info("Dados de confirmação do pagamento: " + request);

        return ResponseEntity.status(HttpStatus.OK).body(
                finalizarPagamentoUserCase.finalizarPagamento(mapper.toFinalizarPagamentoRequest(request))
        );
    }
}
