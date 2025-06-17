package com.um_sushi.Um_Sushi.adapter.output.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cartao")
public class CartaoEntity {

    @Id
    private BigDecimal numero;
    private String nomeTitular;
    private LocalDate validade;
    private Long cvv;
    private String bandeira;
}
