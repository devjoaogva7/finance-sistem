package org.UmSusi.repository.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cartao")
public class CartaoEntity {

    @Id
    private Long numero;
    private String nomeTitular;
    private String validade;
    private String cvv;
    private String bandeira;
}
