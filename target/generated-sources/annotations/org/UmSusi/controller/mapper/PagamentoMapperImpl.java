package org.UmSusi.controller.mapper;

import javax.annotation.processing.Generated;
import org.UmSusi.controller.dto.FinalizarPagamentoDTO;
import org.UmSusi.controller.dto.ProcessarPagamentoDTO;
import org.UmSusi.model.FinalizarPagamentoModel;
import org.UmSusi.model.ProcessarPagamentoModel;
import org.UmSusi.model.enuns.EnumConfirmacaoPagamento;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-12T22:29:11-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class PagamentoMapperImpl implements PagamentoMapper {

    @Override
    public ProcessarPagamentoModel toPagamentoModel(ProcessarPagamentoDTO request) {
        if ( request == null ) {
            return null;
        }

        ProcessarPagamentoModel processarPagamentoModel = new ProcessarPagamentoModel();

        processarPagamentoModel.setFormaPagamento( request.getFormaPagamento() );
        processarPagamentoModel.setCupom( request.getCupom() );
        if ( request.getCpf() != null ) {
            processarPagamentoModel.setCpf( Long.parseLong( request.getCpf() ) );
        }
        processarPagamentoModel.setParcelas( request.getParcelas() );

        return processarPagamentoModel;
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
}
