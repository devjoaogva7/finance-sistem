package com.um_sushi.Um_Sushi.domain.service;

import com.um_sushi.Um_Sushi.domain.model.ClienteCadastro;
import com.um_sushi.Um_Sushi.port.output.SalvarClientePort;
import com.um_sushi.Um_Sushi.port.output.ConsultarClientePort;
import com.um_sushi.Um_Sushi.port.output.AlterarClientePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {
    private ClienteService clienteService;
    private SalvarClientePort salvarClientePort;
    private ConsultarClientePort consultarClientePort;
    private AlterarClientePort alterarClientePort;

    @BeforeEach
    void setUp() {
        salvarClientePort = mock(SalvarClientePort.class);
        consultarClientePort = mock(ConsultarClientePort.class);
        alterarClientePort = mock(AlterarClientePort.class);
        clienteService = new ClienteService(salvarClientePort, consultarClientePort, alterarClientePort);
    }

    @Test
    void testSalvarClienteCadastro() {
        ClienteCadastro cadastro = new ClienteCadastro();
        when(salvarClientePort.salvar(cadastro)).thenReturn("Cliente salvo com sucesso");
        String resultado = clienteService.salvar(cadastro);
        assertEquals("Cliente salvo com sucesso", resultado);
        verify(salvarClientePort, times(1)).salvar(cadastro);
    }
} 