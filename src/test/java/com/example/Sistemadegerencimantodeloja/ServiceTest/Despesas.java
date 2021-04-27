package com.example.Sistemadegerencimantodeloja.ServiceTest;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.DespesasServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.InvestimentoServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Investimento;
import com.example.Sistemadegerencimantodeloja.repository.DespesasRepository;
import com.example.Sistemadegerencimantodeloja.repository.InvestimentoRepository;
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
class DespesasServiceImpllT {

    @MockBean
    DespesasRepository repository;


    @Autowired
    DespesasServiceImpl despesasService;


    private List<Despesas> despesas;
    private  Despesas despesa;
    private Date data;



    @BeforeEach
    public void setup(){
        this.despesas= new LinkedList<>();

        this.despesa = Despesas.builder()
                .descricao("Mesa")
                .valor(100)
                .data(new Date())
                .build();

        this.despesas.add(this.despesa);
        this.data = this.despesa.getData();


    }

    @Test
    public void testServiceNaoENulo(){
        assertThat(this.despesasService).isNotNull();
    }

    @Test
    public void testBuscarNoIntervalo(){
        when(this.despesasService.buscarNoIntervalo(this.data, this.data))
                .thenReturn(this.despesas);

        List<Despesas> despesasRetornadas = (List<Despesas>) this.despesasService.buscarNoIntervalo(this.data, this.data);
        assertThat(despesasRetornadas).containsExactlyElementsOf(this.despesas);


    }
}
