package org.UmSusi.repository.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public PagamentoEntity() {
    }

    public PagamentoEntity(Long id, String status, LocalDateTime datahora, String formaPagamento, ClienteEntity cliente, EstabelecimentoEntity estabelecimento, String cupom,
                           FreteEntity frete, PedidoEntity pedido, BigDecimal valor, Integer parcelas) {
        this.id = id;
        this.status = status;
        this.datahora = datahora;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
        this.estabelecimento = estabelecimento;
        this.cupom = cupom;
        this.frete = frete;
        this.pedido = pedido;
        this.valor = valor;
        this.parcelas = parcelas;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public EstabelecimentoEntity getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoEntity estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }

    public FreteEntity getFrete() {
        return frete;
    }

    public void setFrete(FreteEntity frete) {
        this.frete = frete;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public String comprovante() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        StringBuilder itensPedido = new StringBuilder();
        if (pedido != null && pedido.getProdutoEntities() != null) {
            for (ProdutoEntity produto : pedido.getProdutoEntities()) {
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

