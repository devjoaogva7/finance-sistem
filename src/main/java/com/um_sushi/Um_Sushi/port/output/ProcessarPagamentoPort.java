package com.um_sushi.Um_Sushi.port.output;

import com.um_sushi.Um_Sushi.domain.model.*;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProcessarPagamentoPort {

    String salvar(ProcessarPagamento request, BigDecimal valorTotal,
                  Cliente cliente, Estabelecimento estabelecimento, Frete frete, Pedido pedido);

    Optional<Pagamento> alterarPagamento(Pagamento pagamento);
}
