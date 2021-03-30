package com.example.Sistemadegerencimantodeloja.model.factory;

import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.model.Vendas;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutosFactory {

    public Produtos criarProduto(
            String grupo, double valorC, double valorV, String desc){

        Produtos produto = Produtos.builder()
                .grupo(grupo)
                .valorCusto(valorC)
                .valorVenda(valorV)
                .descricao(desc)
                .build();
        return produto;
    }
}
