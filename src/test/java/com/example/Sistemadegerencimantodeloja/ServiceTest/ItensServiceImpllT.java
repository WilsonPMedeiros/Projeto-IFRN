package com.example.Sistemadegerencimantodeloja.ServiceTest;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.DespesasServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.EstoqueServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.itens;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.itensServiceImpl;
import com.example.Sistemadegerencimantodeloja.repository.DespesasRepository;
import com.example.Sistemadegerencimantodeloja.repository.EstoqueRepository;
import com.example.Sistemadegerencimantodeloja.repository.ItensRepository;
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
public class ItensServiceImpllT {

    @MockBean
    ItensRepository repository;


    @Autowired
    itensServiceImpl itensService;

    @Autowired
    EstoqueServiceImpl estoqueService;


    private List<itens> itens;
    private  itens iten;
    private double valor;



    @BeforeEach
    public void setup(){
        this.itens= new LinkedList<>();

        this.iten = com.example.Sistemadegerencimantodeloja.model.itens.builder()
                .descricao("Blusa")
                .grupo("Blusa")
                .valorCusto(100)
                .valorVenda(200)
                .build();

        this.itens.add(this.iten);
        this.valor = 300;


    }

    @Test
    public void testServiceNaoENulo(){
        assertThat(this.estoqueService).isNotNull();
    }

    @Test
    public void testBuscarProdutosComMenorValor(){
        when(this.estoqueService.buscarProdutosComMenorValor(this.valor))
                .thenReturn(this.itens);

        List<itens> itensRetornadas = (List<itens>) this.estoqueService.buscarProdutosComMenorValor(this.valor);
        assertThat(itensRetornadas).containsExactlyElementsOf(this.itens);


    }
}
