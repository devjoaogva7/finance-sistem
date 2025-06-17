package com.um_sushi.Um_Sushi.domain.service;

import com.um_sushi.Um_Sushi.domain.model.Cartao;
import com.um_sushi.Um_Sushi.domain.model.Cliente;
import com.um_sushi.Um_Sushi.domain.model.ClienteCadastro;
import com.um_sushi.Um_Sushi.port.input.AlterarClienteUserCase;
import com.um_sushi.Um_Sushi.port.input.ConsultarClienteUserCase;
import com.um_sushi.Um_Sushi.port.input.SalvarCartaoUserCase;
import com.um_sushi.Um_Sushi.port.input.SalvarClienteUserCase;
import com.um_sushi.Um_Sushi.port.output.AlterarClientePort;
import com.um_sushi.Um_Sushi.port.output.ConsultarClientePort;
import com.um_sushi.Um_Sushi.port.output.SalvarClientePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService implements SalvarClienteUserCase, ConsultarClienteUserCase, AlterarClienteUserCase {

    private final SalvarClientePort salvarClientePort;
    private final ConsultarClientePort consultarClientePort;
    private final AlterarClientePort alterarClientePort;

    @Override
    @Transactional
    public String salvar(ClienteCadastro request) {
        return salvarClientePort.salvar(request);
    }

    @Override
    public Optional<Cliente> buscarPorCpf(Long cpf) {
       return Optional.ofNullable(consultarClientePort.buscarPorCpf(cpf).orElseThrow(() -> new RuntimeException("Cliente não encontrado, com o cpf: " + cpf)));
    }

    @Override
    @Transactional
    public void alterarCartao(Cliente cliente, Cartao request) {
        consultarClientePort.buscarPorCpf(cliente.getCpf()).ifPresentOrElse( c -> {
            alterarClientePort.alterarCartao(c, request);
        }, () -> {
            throw new IllegalArgumentException(("Cliente com CPF " + cliente.getCpf() + " não encontrado."));
        });
    }
}
