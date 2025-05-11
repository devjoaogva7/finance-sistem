package org.UmSusi.repository.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
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

    public PagamentoEntity() {
    }

    public PagamentoEntity(Long id, String status, LocalDateTime datahora, String formaPagamento, ClienteEntity cliente, EstabelecimentoEntity estabelecimento, String cupom, FreteEntity frete, PedidoEntity pedido, BigDecimal valor) {
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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = datahora != null ? datahora.format(formatter) : "não disponível";

        return "Dados do Pagamento: " +
                "\n  - id: " + id +
                "\n  - Status: " + status +
                "\n  - Data e Hora: " + formattedDate +
                "\n  - Forma de Pagamento: " + formaPagamento +
                "\n  - Cliente: " + (cliente != null ? cliente.toString() : "não disponível") +
                "\n  - Estabelecimento: " + (estabelecimento != null ? estabelecimento.toString() : "não disponível") +
                "\n  - Cupom: " + (cupom != null ? cupom : "não disponível") +
                "\n  - Frete: " + (frete != null ? frete.toString() : "não disponível") +
                "\n  - Pedido: " + (pedido != null ? pedido.toString() : "não disponível") +
                "\n  - Valor Total: R$ " + String.format("%.2f", valor);
    }
}

