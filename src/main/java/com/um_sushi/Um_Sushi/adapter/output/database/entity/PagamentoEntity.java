package com.um_sushi.Um_Sushi.adapter.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pagamento")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime datahora;
    private String formaPagamento;
    @OneToOne
    private ClienteEntity cliente;
    @OneToOne
    private EstabelecimentoEntity estabelecimento;
    private String cupom;
    @OneToOne(cascade = CascadeType.PERSIST)
    private FreteEntity frete;
    @OneToOne
    private PedidoEntity pedido;
    private BigDecimal valor;
    private Integer parcelas;

    public String comprovante() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        StringBuilder itensPedido = new StringBuilder();
        if (pedido != null && pedido.getProdutos() != null) {
            for (ProdutoEntity produto : pedido.getProdutos()) {
                itensPedido.append(produto.getNome())
                        .append(" - R$ ").append(String.format("%.2f", produto.getPreco()))
                        .append("\n");
            }
        }

        String formattedDate = datahora != null ? datahora.format(formatter) : "não disponível";
        int qtdParcelas = parcelas != null ? parcelas : 1;
        BigDecimal total = valor != null ? valor : BigDecimal.ZERO;
        BigDecimal valorParcela = qtdParcelas > 1 ? total.divide(BigDecimal.valueOf(qtdParcelas), 2, RoundingMode.HALF_UP) : total;

        return String.format(
                "===== COMPROVANTE DE PAGAMENTO =====\n" +
                        "Cliente: %s\n" +
                        "CPF: %s\n" +
                        "Estabelecimento: %s\n" +
                        "CNPJ: %s\n" +
                        "Forma de Pagamento: %s\n" +
                        "Data do Pagamento: %s\n" +
                        "------------------------------------\n" +
                        "Itens do Pedido:\n%s" +
                        "------------------------------------\n" +
                        "Valor Total: R$ %.2f\n" +
                        "Parcelas: %d\n" +
                        "%s" + // Valor da parcela (se houver)
                        "Frete: R$ %.2f\n" +
                        "====================================",
                cliente != null ? cliente.getNome() : "não disponível",
                cliente != null ? String.valueOf(cliente.getCpf()) : "não disponível",
                estabelecimento != null ? estabelecimento.getNome() : "não disponível",
                estabelecimento != null ? String.valueOf(estabelecimento.getCnpj()) : "não disponível",
                formaPagamento != null ? formaPagamento : "não disponível",
                formattedDate,
                itensPedido.toString(),
                total,
                qtdParcelas,
                qtdParcelas > 1 ? String.format("Valor por Parcela: R$ %.2f\n", valorParcela) : "",
                frete != null ? frete.getPreco() : BigDecimal.ZERO
        );
    }
}

