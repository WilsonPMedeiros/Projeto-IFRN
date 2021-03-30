package com.example.Sistemadegerencimantodeloja.TesteUnitario;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.VendasServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class vendaTeste {


    @Autowired
    VendasServiceImpl vendasService;

    private List<Produtos> produtos;
    private Produtos produto;
    private Funcionario funcionario;
    private Vendas vendas;
    private Long idVenda1;
    private Cliente cliente;
    private double valor;


    @BeforeEach
    public void setUp(){
       this.produto = Produtos.builder()
                .descricao("Blusa de poá")
                .valorVenda(10)
                .valorCusto(5)
                .grupo("Blusas")
                .build();

        this.cliente = Cliente.builder()
                .nome("Milena")
                .sexo("F")
                .email("milena@tads")
                .telefone("123456789")
                .end(Endereco.builder()
                        .logradouro("travessa 13 maio")
                        .num(114)
                        .uf("RN")
                        .cidade("Nova Cruz")
                        .cep("59215000")
                        .bairro("Centro")
                        .build())
                .build();

        this.funcionario = Funcionario.builder()
                .nome("Gileno")
                .cpf("123456")
                .sexo("M")
                .login("gil@tads")
                .senha("1234")
                .telefone("7894566")
                .endereco(Endereco.builder()
                        .logradouro("travessa 13 maio")
                        .num(114)
                        .uf("RN")
                        .cidade("Nova Cruz")
                        .cep("59215000")
                        .bairro("Centro")
                        .build())
                .build();

        this.vendas = new Vendas(this.funcionario, this.cliente);
    }

    @Test
    public  void addProdutoTest(){
        this.vendas.addProduto(this.produto);
        double valoratual = vendas.getPreco_total();
        assertEquals(this.produto.getValorVenda(), valoratual, 0.1);
    }
}
