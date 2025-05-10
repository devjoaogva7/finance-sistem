package org.UmSusi.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import jakarta.persistence.EntityNotFoundException;
import org.UmSusi.model.FinalizarPagamentoModel;
import org.UmSusi.model.PagamentoModel;
import org.UmSusi.model.Pedido;
import org.UmSusi.model.QrCodeResponseModel;
import org.UmSusi.model.enuns.EnumConfirmacaoPagamento;
import org.UmSusi.model.enuns.EnumFormaPagamento;
import org.UmSusi.model.enuns.EnumStatus;
import org.UmSusi.repository.Entity.EstabelecimentoEntity;
import org.UmSusi.repository.Entity.PagamentoEntity;
import org.UmSusi.repository.Entity.ProdutoEntity;
import org.UmSusi.repository.EstabelecimentoRepository;
import org.UmSusi.repository.PedidoRepository;
import org.UmSusi.repository.SistemaPagamentoRepository;
import org.UmSusi.repository.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class SistemaPagamentoService {

    @Autowired
    private SistemaPagamentoRepository pagamentoRepository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
    @Autowired
    private EntityMapper mapper;
    @Autowired
    private PedidoRepository pedidoRepository;

    public String processarPagamento(PagamentoModel request) {
        PagamentoEntity savedEntity = pagamentoRepository.save(mapper.toPagamentoEntity(request));
        return "Pagamento processado com ID: " + savedEntity.getId() + ". Status: \"PENDENTE\", aguardando confirmação.";
    }

    public byte[] gerarQrCodeComoImagem() {
        EstabelecimentoEntity estabelecimento = estabelecimentoRepository.findById(15576315825589L)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado com o ID: 15576315825589"));

        return gerarImagemQrCode(estabelecimento.getPix());
    }

    public String finalizarPagamento(FinalizarPagamentoModel request) {
        PagamentoEntity pagamento = pagamentoRepository.findById(request.getIdPagamento())
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com o ID: " + request.getIdPagamento()));

        EstabelecimentoEntity estabelecimento = estabelecimentoRepository.findById(15576315825589L)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado com o ID: 15576315825589"));

        if (request.getConfirmacao() == EnumConfirmacaoPagamento.SIM) {
            pagamento.setStatus(EnumStatus.APROVADO.getDescricao());
        } else if (request.getConfirmacao() == EnumConfirmacaoPagamento.NAO) {
            pagamento.setStatus(EnumStatus.CANCELADO.getDescricao());
        }

        pagamento.setEstabelecimentoEntity(estabelecimento);

        var pFinalizado = pagamentoRepository.save(pagamento);

        return comprovante(
                pFinalizado.getCliente().getNome(),
                pFinalizado.getCliente().getCpf(),
                pFinalizado.getEstabelecimentoEntity().getNome(),
                pFinalizado.getEstabelecimentoEntity().getCnpj(),
                pFinalizado.getValor(),
                pFinalizado.getFormaPagamento(),
                pFinalizado.getDatahora(),
                pFinalizado.getPedidos()
        );
    }

    private String comprovante(String cliente, Long cpf, String estabelecimento, Long cnpj, Double valor, String formaPagamento, LocalDateTime dataPagamento, List<ProdutoEntity> pedidoEntity) {
        return String.format(
                "===== COMPROVANTE DE PAGAMENTO =====\n" +
                        "Cliente: %s\n" +
                        "CPF: %d\n" +
                        "Estabelecimento: %s\n" +
                        "CNPJ: %d\n" +
                        "Forma de Pagamento: %s\n" +
                        "Data do Pagamento: %s\n" +
                        "Pedido: %s\n" +
                        "Valor: R$ %.2f\n" +
                        "====================================",
                cliente,
                cpf,
                estabelecimento,
                cnpj,
                formaPagamento,
                dataPagamento,
                pedidoEntity,
                valor
        );
    }

    // 🔥 Novo método para calcular o valor total do pedido
    public BigDecimal calcularValorTotalPedido(Long pedidoId) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoId);
        if (pedidoOptional.isEmpty()) {
            throw new RuntimeException("Pedido não encontrado com ID: " + pedidoId);
        }
        Pedido pedido = pedidoOptional.get();
        return pedido.calcularValorTotal();
    }

    private byte[] gerarImagemQrCode(String codigoPix) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            BitMatrix matrix = new QRCodeWriter().encode(codigoPix, BarcodeFormat.QR_CODE, 250, 250);
            MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar imagem do QR Code", e);
        }
    }
}
