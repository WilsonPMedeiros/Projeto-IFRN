package com.example.Sistemadegerencimantodeloja.utils;


import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    ClienteRepository repository;

    @Autowired
    CaixaRepository repositoryCaixa;

    @Autowired
    InvestimentoRepository repositoryIn;

    @Autowired
    ProdutosRepository repositoryProduto;

    @Autowired
    EnderecoRepositoy repositoryEnd;

    @Autowired
    EstoqueRepository repositoryEstoque;

    @Autowired
    VendasRepository repositoryvend;

    @Autowired
    FuncaoRepository repositoryFuncao;

    @Autowired
    DespesasRepository repositorydesp;

    @Autowired
    FuncionarioRepository repositoryFuncionario;

    //@PostConstruct
    public void salvarCliente(){

        List<Cliente> clientes = new LinkedList<>();
        // Cliente 1
        Cliente cliente = Cliente.builder()
                .nome("Maria")
                .cpf("700.000.000-00")
                .sexo("F")
                .telefone("3333-3333")
                .email("maria_tads@ifrn.com")
                .end(Endereco.builder()
                        .logradouro("Carlos Alexandre")
                        .num(10)
                        .bairro("Frei Damião")
                        .cidade("Nova Cruz")
                        .uf("RN")
                        .cep("59215000")
                        .build())
                .build();

        // Cliente 1
        Cliente cliente2 = Cliente.builder()
                .nome("João")
                .cpf("711.111.111-11")
                .sexo("M")
                .telefone("3333-3333")
                .email("joao_tads@ifrn.com")
                .end(Endereco.builder()
                        .logradouro("Carlos Alexandre")
                        .num(10)
                        .bairro("Frei Damião")
                        .cidade("Nova Cruz")
                        .uf("RN")
                        .cep("59215000")
                        .build())
                .build();

        clientes.add(cliente);
        clientes.add(cliente2);

        for(Cliente client: clientes) {
            Cliente clienteSalvo = repository.save(client);
            System.out.println("[SAIDA] ID: " + clienteSalvo.getId().toString());
        }

    }


    //@PostConstruct
    public void salvarEndereco(){

        List<Endereco> enderecos = new LinkedList<>();

        // Endereco 1
        Endereco endereco1 = Endereco.builder()
                .logradouro("Maria Lêda Mouzinho")
                .num(15)
                .bairro("Alto das Flores")
                .cidade("Nova Cruz")
                .uf("RN")
                .cep("59215000")
                .build();

        // Endereco 2
        Endereco endereco2 = Endereco.builder()
                .logradouro("Tenente José de Freitas")
                .num(100)
                .bairro("Frei Damião")
                .cidade("Nova Cruz")
                .uf("RN")
                .cep("59215000")
                .build();

        enderecos.add(endereco1);
        enderecos.add(endereco2);

        for(Endereco end: enderecos) {
            Endereco enderecoSalvo = repositoryEnd.save(end);
            System.out.println("[SAIDA] ID: " + enderecoSalvo.getId().toString());
        }
    }

    //@PostConstruct
    public void salvarCaixa(){

        List<Caixa> caixas = new LinkedList<>();

        // Caixa 1
        Caixa caixa1 = Caixa.builder()
                .data(new Date())
                .entrada(100)
                .saida(50)
                .saldo(50)
                .build();

        // Caixa 2
        Caixa caixa2 = Caixa.builder()
                .data(new Date())
                .entrada(200.00)
                .saida(10.00)
                .saldo(190.0)
                .build();

        // Caixa 3
        Caixa caixa3 = Caixa.builder()
                .data(new Date())
                .entrada(200)
                .saida(10)
                .saldo(190)
                .build();


         caixas.add(caixa1);
         caixas.add(caixa2);
         caixas.add(caixa3);

        for(Caixa caixa: caixas) {
            Caixa caixaSalvo = repositoryCaixa.save(caixa);
            System.out.println("[SAIDA] ID: " + caixaSalvo.getId().toString());
        }

    }


    //@PostConstruct
    public void salvarInvestiment(){

        List<Investimento> in = new LinkedList<>();
        Investimento i = Investimento.builder()
                .data(new Date())
                .descricao("Mesa")
                .valor(10)
                .build();

        Investimento ii = Investimento.builder()
                .data(new Date())
                .descricao("Cadeira")
                .valor(10)
                .build();


        in.add(i);
        in.add(ii);

        for(Investimento investimento: in) {
            Investimento inSalvo = repositoryIn.save(investimento);
            System.out.println("[SAIDA] ID: " + inSalvo.getId().toString());
        }
    }


    //@PostConstruct
    public void salvarProdutos(){

        List<Produtos> prods = new LinkedList<>();


        Produtos p = Produtos.builder()
                .descricao("Blusa estampada")
                .valorCusto(10)
                .valorVenda(20)
                .grupo("Blusa")
                .build();

        Produtos pp = Produtos.builder()
                .descricao("Blusa lisa")
                .valorCusto(20)
                .valorVenda(40)
                .grupo("Blusa")
                .build();

        prods.add(p);
        prods.add(pp);

        for(Produtos produto: prods) {
            Produtos prodSalvo = repositoryProduto.save(produto);
            System.out.println("[SAIDA] ID: " + prodSalvo.getId().toString());
        }
    }

    //@PostConstruct
    public void salvarEstoque(){

        List<Estoque> es = new LinkedList<>();
        Estoque e = Estoque.builder()
                .quantidade(10)
                .build();

        Estoque e2 = Estoque.builder()
                .quantidade(10)
                .build();


        es.add(e);
        es.add(e2);

        for(Estoque estoque: es) {
            Estoque estoqueSalvo = repositoryEstoque.save(estoque);
            System.out.println("[SAIDA] ID: " + estoqueSalvo.getId().toString());
        }
    }

    //@PostConstruct
    public void salvarFuncao(){

        List<Funcao> funs = new LinkedList<>();


        Funcao f = Funcao.builder()
                .nome("Vendedor")
                .salario(1200)
                .build();

        Funcao f2 = Funcao.builder()
                .nome("Administrador")
                .salario(2000)
                .build();

        funs.add(f);
        funs.add(f2);

        for(Funcao funcao: funs) {
            Funcao funcSalvo = repositoryFuncao.save(funcao);
            System.out.println("[SAIDA] ID: " + funcSalvo.getId().toString());
        }
    }

    //@PostConstruct
    public void salvarFuncionario(){

        List<Funcionario> funcs = new LinkedList<>();


        Funcionario fun1 = Funcionario.builder()
                .nome("Roberta")
                .sexo("F")
                .cpf("111111111")
                .login("Roberta@gmail.com")
                .senha("1234")
                .telefone("7777-7777")
                .endereco(Endereco.builder()
                        .logradouro("Carlos Alexandre")
                        .num(10)
                        .bairro("Frei Damião")
                        .cidade("Nova Cruz")
                        .uf("RN")
                        .cep("59215000")
                        .build())
                .build();

        Funcionario fun2 = Funcionario.builder()
                .nome("Luana")
                .sexo("F")
                .cpf("222222222222")
                .login("Luana@gmail.com")
                .senha("1234")
                .telefone("7777-7777")
                .endereco(Endereco.builder()
                        .logradouro("Carlos Alexandre")
                        .num(10)
                        .bairro("Frei Damião")
                        .cidade("Nova Cruz")
                        .uf("RN")
                        .cep("59215000")
                        .build())
                .build();


        funcs.add(fun1);
        funcs.add(fun2);

        for(Funcionario funcionario: funcs) {
            Funcionario funcsSalvo = repositoryFuncionario.save(funcionario);
            System.out.println("[SAIDA] ID: " + funcsSalvo.getId().toString());
        }
    }

    //@PostConstruct
    public void salvarDespesas(){

        List<Despesas> desps = new LinkedList<>();
        Despesas desp1 = Despesas.builder()
                .descricao("Energia")
                .data(new Date())
                .valor(100)
                .build();

        Despesas desp2 = Despesas.builder()
                .descricao("Material de limpeza")
                .data(new Date())
                .valor(200)
                .build();

        desps.add(desp1);
        desps.add(desp2);

        for(Despesas despesas: desps) {
            Despesas despSalvo = repositorydesp.save(despesas);
            System.out.println("[SAIDA] ID: " + despSalvo.getId().toString());
        }
    }

    //@PostConstruct
    public void salvarVendas(){

        List<Produtos> prods = new LinkedList<>();


        Produtos p = Produtos.builder()
                .descricao("Blusa estampada")
                .valorCusto(10)
                .valorVenda(20)
                .grupo("Blusa")
                .build();

        Produtos pp = Produtos.builder()
                .descricao("Blusa lisa")
                .valorCusto(20)
                .valorVenda(40)
                .grupo("Blusa")
                .build();

        prods.add(p);
        prods.add(pp);

        List<Vendas> vends = new LinkedList<>();
        Vendas v1 = Vendas.builder()
                .data_Venda(new Date())
                .preco_total(100)
                .desconto(10)
                .forma_pagamento("Á vista")
                .build();

        Vendas v2 = Vendas.builder()
                .data_Venda(new Date())
                .preco_total(200)
                .desconto(20)
                .forma_pagamento("Cartão")
                .cliente(Cliente.builder()
                        .nome("Maria")
                        .cpf("700.000.000-00")
                        .sexo("F")
                        .telefone("3333-3333")
                        .email("maria_tads@ifrn.com")
                        .end(Endereco.builder()
                                .logradouro("Carlos Alexandre")
                                .num(10)
                                .bairro("Frei Damião")
                                .cidade("Nova Cruz")
                                .uf("RN")
                                .cep("59215000")
                                .build())
                        .build())
                .funcionario(Funcionario.builder()
                        .nome("Roberta")
                        .sexo("F")
                        .cpf("111111111")
                        .login("Roberta@gmail.com")
                        .senha("1234")
                        .telefone("7777-7777")
                        .endereco(Endereco.builder()
                                .logradouro("Carlos Alexandre")
                                .num(10)
                                .bairro("Frei Damião")
                                .cidade("Nova Cruz")
                                .uf("RN")
                                .cep("59215000")
                                .build())
                        .build())
                .produtos( prods)
                .build();


        vends.add(v1);
        vends.add(v2);

        for(Vendas venda: vends) {
            Vendas vendaSalva = repositoryvend.save(venda);
            System.out.println("[SAIDA] ID: " + vendaSalva.getId().toString());
        }
    }





}
