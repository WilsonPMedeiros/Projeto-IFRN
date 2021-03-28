package com.example.Sistemadegerencimantodeloja.TesteUnitario;

import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.model.Vendas;
import com.example.Sistemadegerencimantodeloja.model.factory.VendasFactory;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class vendaTeste {

    @MockBean
    VendasFactory vendasFactory;

    private List<Produtos> produtos;
    private Produtos produto;
    private Cliente cliente;
    private Funcionario funcionario;
    private Vendas vendas;


    @BeforeEach
    public void setUp(){
        cliente.setNome("gileno");
        produto.setDescricao("banana");
        funcionario.setNome("Andressa");
        this.produtos= new LinkedList<>();
        produtos.add(produto);
        Vendas v= this.vendasFactory.criarVendas(cliente,funcionario, (Produtos) produtos);

    }

    @Test
    public  void testandoACoisa (){

    }
}
