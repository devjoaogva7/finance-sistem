package org.UmSusi.repository.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "estabelecimento")
public class EstabelecimentoEntity {

    @Id
    private Long cnpj;
    private String nome;
    private String contaBancaria;
    private String endereco;
    private String pixCopiaCola;
    @Lob
    private byte[] imagemQrCode;

    @Override
    public String toString() {
        return "\n     - cnpj: " + cnpj +
                "\n     - nome: " + nome +
                "\n     - endereco: " + endereco;
    }
}
