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
}

