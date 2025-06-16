package com.um_sushi.Um_Sushi.adapter.output.database.mapper;

import com.um_sushi.Um_Sushi.adapter.output.database.entity.*;
import com.um_sushi.Um_Sushi.domain.model.*;
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
    @Mapping(target = "cartao", source = "cartao")
    ClienteEntity toSaveClienteEntity(ClienteCadastro request);

    //Nao esta usando
//    @Mapping(target = "rua", source = "endereco.rua")
//    @Mapping(target = "numero", source = "endereco.numero")
//    @Mapping(target = "cep", source = "endereco.cep")
//    @Mapping(target = "cidade", source = "endereco.cidade")
//    @Mapping(target = "bairro", source = "endereco.bairro")
//    @Mapping(target = "uf", source = "endereco.uf")
//    EnderecoEntity toSaveEnderecoEntity(ClienteCadastro request);

    CartaoEntity toSaveCartaoEntity(Cartao request);

    PedidoEntity toSavePedidoEntity(Pedido request);

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

    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "endereco", source = "endereco")
    @Mapping(target = "cartao", source = "cartao")
    @Mapping(target = "cartao.numero", source = "cartao.numero")
    @Mapping(target = "cartao.nomeTitular", source = "cartao.nomeTitular")
    @Mapping(target = "cartao.validade", source = "cartao.validade")
    @Mapping(target = "cartao.cvv", source = "cartao.cvv")
    @Mapping(target = "cartao.bandeira", source = "cartao.bandeira")
    Cliente toClienteModel(ClienteEntity clienteEntity);

    @Mapping(target = "cnpj", source = "cnpj")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "contaBancaria", source = "contaBancaria")
    @Mapping(target = "endereco", source = "endereco")
    @Mapping(target = "pixCopiaCola", source = "pixCopiaCola")
    @Mapping(target = "imagemQrCode", source = "imagemQrCode")
    Estabelecimento toEstabelecimentoModel(EstabelecimentoEntity entity);

    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "preco", source = "preco")
    Frete toFreteModel(FreteEntity entity);

    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "produtos", source = "produtos")
    @Mapping(target = "valor", source = "valor")
    Pedido toPedidoModel(PedidoEntity byClienteCpf);

    Produto toProdutoModel(ProdutoEntity byNome);

    List<Produto> toListProdutosModel(List<ProdutoEntity> all);

    @Mapping(target = "cartao.numero", source = "numero")
    @Mapping(target = "cartao.nomeTitular", source = "nomeTitular")
    @Mapping(target = "cartao.validade", source = "validade")
    @Mapping(target = "cartao.cvv", source = "cvv")
    @Mapping(target = "cartao.bandeira", source = "bandeira")
    void updateCartaoClienteEntity(Cartao cartao, @MappingTarget ClienteEntity entity);
}
