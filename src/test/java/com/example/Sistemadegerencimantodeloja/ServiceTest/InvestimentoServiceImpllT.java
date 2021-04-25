package com.example.Sistemadegerencimantodeloja.ServiceTest;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.CaixaServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Caixa;
import com.example.Sistemadegerencimantodeloja.model.Investimento;
import com.example.Sistemadegerencimantodeloja.repository.CaixaRepository;
import com.example.Sistemadegerencimantodeloja.repository.InvestimentoRepository;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.InvestimentoServiceImpl;
import io.cucumber.java.sl.In;
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
public class InvestimentoServiceImpllT {


    @MockBean
    InvestimentoRepository repository;


    @Autowired
    InvestimentoServiceImpl investimentoService;


    private List<Investimento> investimentos;
    private  Investimento investimento;
    private Date data;



    @BeforeEach
    public void setup(){
        this.investimentos= new LinkedList<>();

        this.investimento = Investimento.builder()
                .descricao("Mesa")
                .valor(100)
                .data(new Date())
                .build();

        this.investimentos.add(this.investimento);
        this.data = this.investimento.getData();


    }

    @Test
    public void testServiceNaoENulo(){
        assertThat(this.investimentoService).isNotNull();
    }

    @Test
    public void testBuscarNoIntervalo(){
        when(this.investimentoService.buscarNoIntervalo(this.data, this.data))
                .thenReturn(this.investimentos);

        List<Investimento> investimentoRetornado = (List<Investimento>) this.investimentoService.buscarNoIntervalo(this.data, this.data);
        assertThat(investimentoRetornado).containsExactlyElementsOf(this.investimentos);


    }
}
