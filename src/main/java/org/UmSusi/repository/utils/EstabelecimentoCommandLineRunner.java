package org.UmSusi.repository.utils;

import org.UmSusi.repository.Entity.EstabelecimentoEntity;
import org.UmSusi.repository.EstabelecimentoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;

@Component
public class EstabelecimentoCommandLineRunner implements CommandLineRunner {


    private final EstabelecimentoRepository estabelecimentoRepository;

    public EstabelecimentoCommandLineRunner(EstabelecimentoRepository estabelecimentoRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (estabelecimentoRepository.count() == 0) {
            EstabelecimentoEntity estabelecimento = new EstabelecimentoEntity();
            estabelecimento.setCnpj(15576315825589L);
            estabelecimento.setNome("UM SUSHI");
            estabelecimento.setContaBancaria("12345-6");
            estabelecimento.setEndereco("Rua dos Camelos");
            estabelecimento.setPixCopiaCola("00020126360014BR.GOV.BCB.PIX0114+5599999999995204000053039865802BR5909UmSUSHI6009SAO62100506abcdef6304A13F");

            // Carregando a imagem QR Code como byte[]
            try {
                byte[] imagem = Files.readAllBytes(new ClassPathResource("qr-code.png").getFile().toPath());
                estabelecimento.setImagemQrCode(imagem);
            } catch (IOException e) {
                System.err.println("Erro ao carregar o QR Code: " + e.getMessage());
                return;
            }

            estabelecimentoRepository.save(estabelecimento);
            System.out.println("Estabelecimento salvo com sucesso.");
        } else {
            System.out.println("Estabelecimento já existe. Nenhuma ação tomada.");
        }
    }
}
