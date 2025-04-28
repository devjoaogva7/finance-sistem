package org.UmSusi.service;

import org.UmSusi.model.Pedido;
import org.UmSusi.repository.PedidoRepository;
import org.UmSusi.repository.Entity.PagamentoEntity;
import org.UmSusi.model.enuns.EnumFormaPagamento;
import org.UmSusi.model.enuns.EnumStatus;
import org.UmSusi.repository.SistemaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SistemaPagamentoService {

    @Autowired
    private SistemaPagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public String processarPagamento(PagamentoEntity request) {
        request.setStatus(EnumStatus.PENDENTE);
        request.setDatahora(LocalDateTime.now());

        pagamentoRepository.save(request);

        return "O pagamento foi processado e está com o status \"PENDENTE\", aguardando confirmação.";
    }

    private String comprovante(String cliente, String cpf, String estabelecimento, String cnpj, Double valor, EnumFormaPagamento formaPagamento, LocalDate dataPagamento, List<Pedido> pedido) {
        return String.format(
                "===== COMPROVANTE DE PAGAMENTO =====\n" +
                        "Cliente: %s\n" +
                        "CPF: %s\n" +
                        "Estabelecimento: %s\n" +
                        "CNPJ: %s\n" +
                        "Forma de Pagamento: %s\n" +
                        "Data do Pagamento: %s\n" +
                        "Pedido: %s\n" +
                        "Valor: R$ %.2f\n" +
                        "====================================",
                cliente,
                cpf,
                estabelecimento,
                cnpj,
                formaPagamento,
                dataPagamento,
                pedido,
                valor
        );
    }

    // 🔥 Novo método para calcular o valor total do pedido
    public BigDecimal calcularValorTotalPedido(Long pedidoId) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoId);
        if (pedidoOptional.isEmpty()) {
            throw new RuntimeException("Pedido não encontrado com ID: " + pedidoId);
        }
        Pedido pedido = pedidoOptional.get();
        return pedido.calcularValorTotal();
    }
}
