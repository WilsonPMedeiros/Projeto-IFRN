package com.example.Sistemadegerencimantodeloja.ServiceTest;

import com.example.Sistemadegerencimantodeloja.Service.ClienteService;
import com.example.Sistemadegerencimantodeloja.Service.VendasService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Funcao;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.example.Sistemadegerencimantodeloja.model.Vender;
import com.example.Sistemadegerencimantodeloja.model.factory.ClienteFactory;
import com.example.Sistemadegerencimantodeloja.repository.venderRepository;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.venderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VendasServiceImplIT {

    @Autowired
    ClienteService clienteService;

    @MockBean
    venderRepository repository;

    @Autowired
    venderServiceImpl venderService;


    @Autowired
    ClienteFactory clienteFactory;

    private List<Cliente> clientes;
    private Long idCliente1;
    private String cpfcliente;
    private List<Vender> venders;
    private Date data;
    private Vender venda;


    @BeforeEach
    public void setup(){
        this.clientes = new LinkedList<>();
        Cliente cliente1 = this.clienteFactory.criarCliente(
                "Juliete", "88888888898", "F",
                "ju@tads.ifrn.com.br", "3281-2121"
        );

        this.clientes.add(cliente1);
        this.cpfcliente = this.clientes.get(0).getCpf();


        Funcionario funcionario = Funcionario.builder()
                .cpf("11111")
                .sexo("F")
                .nome("lisiane")
                .telefone("123")
                .login("lisiane@gmail.com")
                .build();

         this.venda = Vender.builder()
                .cliente(cliente1)
                .funcionario(funcionario)
                .data_Venda(new Date())
                .preco_venda(100)
                .desconto(50)
                .preco_total(50)
                .build();
        this.venders = new LinkedList<>();
        this.venders.add(this.venda);
        this.data = venda.getData_Venda();
    }

    @Test
    public void testServiceNaoENulo(){
        assertThat(this.venderService).isNotNull();
    }

    @Test
    public void testBuscarNoIntervalo(){
        when(this.venderService.buscarNoIntervalo(this.data, this.data))
                .thenReturn(this.venders);

        List<Vender> vendasRetornadas = (List<Vender>) this.venderService.buscarNoIntervalo(this.data, this.data);
        assertThat(vendasRetornadas).containsExactlyElementsOf(this.venders);


    }

}
