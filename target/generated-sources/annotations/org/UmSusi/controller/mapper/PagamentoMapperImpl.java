package org.UmSusi.controller.mapper;

import javax.annotation.processing.Generated;
import org.UmSusi.controller.dto.ClienteRequestDTO;
import org.UmSusi.controller.dto.FinalizarPagamentoDTO;
import org.UmSusi.controller.dto.PagamentoRequestDTO;
import org.UmSusi.model.ClienteModel;
import org.UmSusi.model.FinalizarPagamentoModel;
import org.UmSusi.model.PagamentoModel;
import org.UmSusi.model.enuns.EnumConfirmacaoPagamento;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-04T20:24:49-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class PagamentoMapperImpl implements PagamentoMapper {

    @Override
    public PagamentoModel toPagamentoModel(PagamentoRequestDTO request) {
        if ( request == null ) {
            return null;
        }

        PagamentoModel pagamentoModel = new PagamentoModel();

        pagamentoModel.setFormaPagamento( request.getFormaPagamento() );
        pagamentoModel.setCliente( clienteRequestDTOToClienteModel( request.getCliente() ) );
        pagamentoModel.setCupom( request.getCupom() );

        return pagamentoModel;
    }

    @Override
    public FinalizarPagamentoModel toFinalizarModel(FinalizarPagamentoDTO request) {
        if ( request == null ) {
            return null;
        }

        Long idPagamento = null;
        EnumConfirmacaoPagamento confirmacao = null;

        idPagamento = request.getIdPagamento();
        confirmacao = request.getConfirmacao();

        FinalizarPagamentoModel finalizarPagamentoModel = new FinalizarPagamentoModel( idPagamento, confirmacao );

        return finalizarPagamentoModel;
    }

    protected ClienteModel clienteRequestDTOToClienteModel(ClienteRequestDTO clienteRequestDTO) {
        if ( clienteRequestDTO == null ) {
            return null;
        }

        ClienteModel clienteModel = new ClienteModel();

        clienteModel.setCpf( clienteRequestDTO.getCpf() );
        clienteModel.setNome( clienteRequestDTO.getNome() );
        clienteModel.setEmail( clienteRequestDTO.getEmail() );
        clienteModel.setTelefone( clienteRequestDTO.getTelefone() );
        clienteModel.setEndereco( clienteRequestDTO.getEndereco() );

        return clienteModel;
    }
}
