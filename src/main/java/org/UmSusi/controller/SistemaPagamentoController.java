package org.UmSusi.controller;

import org.UmSusi.controller.dto.FinalizarPagamentoDTO;
import org.UmSusi.controller.dto.PagamentoRequestDTO;
import org.UmSusi.controller.mapper.PagamentoMapper;
import org.UmSusi.repository.Entity.PagamentoEntity;
import org.UmSusi.service.SistemaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class SistemaPagamentoController {

    @Autowired
    private SistemaPagamentoService service;

    @Autowired
    private PagamentoMapper mapper;

    @PostMapping("/processando")
    public ResponseEntity<String> processarPagamento(@RequestBody PagamentoRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.processarPagamento(mapper.toEntity(request)));
    }

    @PostMapping("/finalizar-pagamento")
    public ResponseEntity<String> finalizarPagamento(@RequestBody FinalizarPagamentoDTO dto) {
        String mensagem = service.finalizarPagamento(dto);
        return ResponseEntity.ok(mensagem);
    }
}
