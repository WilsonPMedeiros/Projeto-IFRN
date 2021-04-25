package com.example.Sistemadegerencimantodeloja.ServiceTest;


import com.example.Sistemadegerencimantodeloja.Service.ClienteService;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.venderServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.CaixaServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Caixa;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.example.Sistemadegerencimantodeloja.model.Vender;
import com.example.Sistemadegerencimantodeloja.model.factory.ClienteFactory;
import com.example.Sistemadegerencimantodeloja.repository.CaixaRepository;
import com.example.Sistemadegerencimantodeloja.repository.venderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CaixaServiceImpllT {

    @MockBean
    CaixaRepository repository;


    @Autowired
    CaixaServiceImpl caixaService;


    private List<Caixa> caixas;
    private  Caixa caixa;
    private Date data;



    @BeforeEach
    public void setup(){
        this.caixas = new LinkedList<>();

        this.caixa = Caixa.builder()
                .data(new Date())
                .saldo(100)
                .entrada(200)
                .saida(100)
                .build();

        this.caixas.add(this.caixa);
        this.data = this.caixa.getData();


    }

    @Test
    public void testServiceNaoENulo(){
        assertThat(this.caixaService).isNotNull();
    }

    @Test
    public void testBuscarNoIntervalo(){
        when(this.caixaService.buscarNoIntervalo(this.data, this.data))
                .thenReturn(this.caixas);

        List<Caixa> caixaRetornadas = (List<Caixa>) this.caixaService.buscarNoIntervalo(this.data, this.data);
        assertThat(caixaRetornadas).containsExactlyElementsOf(this.caixas);


    }
}
