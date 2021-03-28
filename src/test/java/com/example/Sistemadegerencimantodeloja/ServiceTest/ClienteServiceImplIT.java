package com.example.Sistemadegerencimantodeloja.ServiceTest;


import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ClienteServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.factory.ClienteFactory;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;



import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class ClienteServiceImplIT {

    @MockBean
    ClienteRepository repository;


    @Autowired
    ClienteServiceImpl clienteService;

    @Autowired
    ClienteFactory clienteFactory;

    private List<Cliente> clientes;
    private Long idCliente1;
    private String cpfcliente;


    @BeforeEach
    public void setup(){
        this.clientes = new LinkedList<>();
        Cliente cliente1 = this.clienteFactory.criarCliente(
                "Juliete", "88888888898", "F",
                "ju@tads.ifrn.com.br", "3281-2121"
        );

        this.clientes.add(cliente1);

        this.idCliente1 = this.clientes.get(0).getId();
        this.cpfcliente = this.clientes.get(0).getCpf();
    }

    @Test
    public void testServiceNaoENulo(){
        assertThat(this.clienteService).isNotNull();
    }

    /*@Test
    public void testFindById(){
                when(this.clienteService.findById(this.idCliente1))
                        .thenReturn(this.clientes.get(0));

        Cliente clienteretomado = clienteService.findById(this.idCliente1);

        assertThat(clienteretomado.getId()).isEqualTo(this.idCliente1);
    }*/

    @Test
    public void testFindByCpf(){
        when(this.clienteService.findByCpf(this.cpfcliente))
                .thenReturn(this.clientes.get(0));


        Cliente clienteretomado = clienteService.findByCpf(this.cpfcliente);
        assertThat(clienteretomado.getCpf()).isEqualTo(this.cpfcliente);

    }




}
