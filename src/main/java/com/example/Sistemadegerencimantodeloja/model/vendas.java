package com.example.Sistemadegerencimantodeloja.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_vendas")
@Embeddable
@Data
@Builder
public class vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
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
