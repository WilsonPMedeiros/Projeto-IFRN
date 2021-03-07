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
    CaixaRepository repositoryCaixa;
    InvestimentoRepository repositoryIn;
    ProdutosRepository repositoryProduto;


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
                .build();

        // Cliente 1
        Cliente cliente2 = Cliente.builder()
                .nome("João")
                .cpf("711.111.111-11")
                .sexo("M")
                .telefone("3333-3333")
                .email("joao_tads@ifrn.com")
                .build();

        clientes.add(cliente);
        clientes.add(cliente2);


        int tam = clientes.size()-1;
        for (int i=0;i<= tam;i++){
            repository.save(clientes.get(i));
        }
    }


    @Autowired
    EnderecoRepositoy repositoy_end;

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
                .build();

        // Endereco 2
        Endereco endereco2 = Endereco.builder()
                .logradouro("Carlos Alexandre")
                .num(10)
                .bairro("Frei Damião")
                .cidade("Nova Cruz")
                .uf("RN")
                .build();

        enderecos.add(endereco1);
        enderecos.add(endereco2);

        int tam = enderecos.size()-1;
        System.out.println("Tamanho: "+tam);
        for (int i=0;i<= tam;i++){
            repositoy_end.save(enderecos.get(i));
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





         repositoryCaixa.save(caixa1);
         repositoryCaixa.save(caixa2);
         repositoryCaixa.save(caixa3);


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

        int tam = in.size()-1;
        System.out.println("Tamanho: "+tam);
        for (int j=0;j<= tam;j++){
            repositoryIn.save(in.get(j));
        }
    }

    //@PostConstruct
    public void salvarInvestimento(){

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

        int tam = in.size()-1;
        System.out.println("Tamanho: "+tam);
        for (int j=0;j<= tam;j++){
            repositoryIn.save(in.get(j));
        }
    }


    //@PostConstruct
    public void salvarProdutos(){

        List<Produtos> prods = new LinkedList<>();


        Produtos p = Produtos.builder()
                .descricao("Blusa estampada")
                .valor_custo(10)
                .valor_venda(20)
                .grupo("Blusa")
                .build();

        Produtos pp = Produtos.builder()
                .descricao("Blusa lisa")
                .valor_custo(20)
                .valor_venda(40)
                .grupo("Blusa")
                .build();




        prods.add(p);
        prods.add(pp);

        int tam = prods.size()-1;
        System.out.println("Tamanho: "+tam);
        for (int a=0;a<= tam;a++){
            repositoryProduto.save(prods.get(a));
        }
    }

    @Autowired
    EstoqueRepository repositoryEstoque;

   // @PostConstruct
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

        int tam = es.size()-1;
        System.out.println("Tamanho: "+tam);
        for (int a=0;a<= tam;a++){
            repositoryEstoque.save(es.get(a));
        }
    }

    @Autowired
    FuncaoRepository repositoryFuncao;

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

        int tam = funs.size()-1;
        System.out.println("Tamanho: "+tam);
        for (int a=0;a<= tam;a++){
            repositoryFuncao.save(funs.get(a));
        }
    }

    @Autowired
    FuncionarioRepository repositoryFuncionario;

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
                .build();

        Funcionario fun2 = Funcionario.builder()
                .nome("Luana")
                .sexo("F")
                .cpf("222222222222")
                .login("Luana@gmail.com")
                .senha("1234")
                .telefone("7777-7777")
                .build();


        funcs.add(fun1);
        funcs.add(fun2);

        int tam = funcs.size()-1;
        System.out.println("Tamanho: "+tam);
        for (int a=0;a<= tam;a++){
            repositoryFuncionario.save(funcs.get(a));
        }
    }



    @Autowired
    DespesasRepository repositorydesp;

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

        int tam = desps.size()-1;
        System.out.println("Tamanho: "+tam);
        for (int a=0;a<= tam;a++){
            repositorydesp.save(desps.get(a));
        }
    }

    @Autowired
    VendasRepository repositoryvend;

    //@PostConstruct
    public void salvarVendas(){

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
                .build();




        vends.add(v1);
        vends.add(v2);

        int tam = vends.size()-1;
        System.out.println("Tamanho: "+tam);
        for (int a=0;a<= tam;a++){
            repositoryvend.save(vends.get(a));
        }
    }





}
