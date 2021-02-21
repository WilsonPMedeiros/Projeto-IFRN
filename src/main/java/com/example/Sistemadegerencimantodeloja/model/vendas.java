package com.example.Sistemadegerencimantodeloja.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class vendas {

    private int id;
    private double desconto;
    private double preco_venda;
    private double preco_total;
    private Data data_Venda;
    private String forma_pagamento;
    private Cliente cliente;
    private Produtos p;
    private Funcionario funcionario;

}
