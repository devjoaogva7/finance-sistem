package org.UmSusi.controller;

import org.UmSusi.controller.dto.PagamentoRequestDTO;
import org.UmSusi.controller.mapper.PagamentoMapper;
import org.UmSusi.service.SistemaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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
    public ResponseEntity<String> finalizarPagamento(String simOuNao) {
        return null;
    }

    // 🔥 Novo endpoint para calcular o total do pedido
    @GetMapping("/pedido/{id}/total")
    public ResponseEntity<BigDecimal> calcularValorTotalPedido(@PathVariable Long id) {
        BigDecimal valorTotal = service.calcularValorTotalPedido(id);
        return ResponseEntity.ok(valorTotal);
    }
}
