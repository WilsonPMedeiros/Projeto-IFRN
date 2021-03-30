package com.example.Sistemadegerencimantodeloja.model.factory;

import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.model.Vendas;
import org.springframework.stereotype.Component;

import java.sql.ClientInfoStatus;
import java.util.List;

@Component
public class VendasFactory {


    /*public Vendas criarVendas(Cliente cliente, Funcionario funcionario) {

        Vendas vendas= Vendas.builder()
                .cliente(cliente)
                .funcionario(funcionario)
                .build();
        return vendas;
    } */


    public Vendas criarVenda(
            Cliente cliente, Funcionario funcionario, Produtos produtos){

        Vendas vendas = Vendas.builder()
                .cliente(cliente)
                .funcionario(funcionario)
                .build();
        return vendas;
    }

}
