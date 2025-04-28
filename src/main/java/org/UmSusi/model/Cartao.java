package org.UmSusi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cartao {

    @Id
    private Long numero;
}
