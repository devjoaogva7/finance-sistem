package org.UmSusi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "chaves_pix")
public class ChavePix {

    @Id
    private Long numeroCartao;

    public ChavePix() {
    }

    public ChavePix(Long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Long getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChavePix)) return false;
        ChavePix chavePix = (ChavePix) o;
        return Objects.equals(numeroCartao, chavePix.numeroCartao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCartao);
    }

    @Override
    public String toString() {
        return "ChavePix{" +
                "numeroCartao=" + numeroCartao +
                '}';
    }
}
