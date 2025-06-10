package com.um_sushi.Um_Sushi.adapter.output.database.mapper;

import com.um_sushi.Um_Sushi.adapter.input.dto.PedidoRequest;
import com.um_sushi.Um_Sushi.adapter.output.database.entity.*;
import com.um_sushi.Um_Sushi.domain.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface RepositoryMapper {

    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "endereco", source = "endereco")
    @Mapping(target = "cartao.numero", source = "cartao.numero")
    @Mapping(target = "cartao.nomeTitular", source = "cartao.nomeTitular")
    @Mapping(target = "cartao.validade", source = "cartao.validade")
    @Mapping(target = "cartao.cvv", source = "cartao.cvv")
    @Mapping(target = "cartao.bandeira", source = "cartao.bandeira")
    Cliente toClienteModelo(ClienteEntity clienteEntity);

    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "endereco", source = "endereco")
    ClienteEntity toSaveClienteEntity(ClienteCadastro request);

    @Mapping(target = "rua", source = "endereco.rua")
    @Mapping(target = "numero", source = "endereco.numero")
    @Mapping(target = "cep", source = "endereco.cep")
    @Mapping(target = "cidade", source = "endereco.cidade")
    @Mapping(target = "bairro", source = "endereco.bairro")
    @Mapping(target = "uf", source = "endereco.uf")
    EnderecoEntity toSaveEnderecoEntity(ClienteCadastro request);

    CartaoEntity toSaveCartaoEntity(Cartao request);

    @Mapping(target = "cartao.numero", source = "numero")
    @Mapping(target = "cartao.nomeTitular", source = "nomeTitular")
    @Mapping(target = "cartao.validade", source = "validade")
    @Mapping(target = "cartao.cvv", source = "cvv")
    @Mapping(target = "cartao.bandeira", source = "bandeira")
    void updateCartaoClienteEntity(Cartao cartao, @MappingTarget ClienteEntity entity);

    @Mapping(target = "status", constant = "PENDENTE")
    @Mapping(target = "datahora", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "formaPagamento", expression = "java(request.getFormaPagamento().getDescricao())")
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "estabelecimento", source = "estabelecimento")
    @Mapping(target = "cupom", source = "request.cupom")
    @Mapping(target = "frete", source = "frete")
    @Mapping(target = "pedido", source = "pedido")
    @Mapping(target = "valor", source = "valorTotal")
    @Mapping(target = "parcelas", source = "request.parcelas")
    PagamentoEntity toSavePagamentoEntity(ProcessarPagamento request, BigDecimal valorTotal, Cliente cliente,
                                          Estabelecimento estabelecimento, Frete frete, Pedido pedido);
//TODO Concertar
//    @Mapping(target = "cliente", source = "cliente")
//    @Mapping(target = "produtos", source = "produtos")
//    @Mapping(target = "valor", source = "valor")
//    PedidoEntity toSavePedidoEntity(Pedido request);

//    private PedidoRequest.ClienteRequest cliente;
//    private List<PedidoRequest.ProdutoRequest> produtos;
//
//
//    public static class ProdutoRequest {
//        private String nome;
//        private Integer quantidade;
//    }
//
//    public static class ClienteRequest {
//        private Long cpf;
//        private String nome;
//        private String telefone;
//    }
}
