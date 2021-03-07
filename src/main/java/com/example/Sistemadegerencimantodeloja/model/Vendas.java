package com.example.Sistemadegerencimantodeloja.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_vendas")
@Data
@Builder
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "desconto", nullable = false)
    private double desconto;

    @Column(name = "preco_venda", nullable = false)
    private double preco_venda;

    @Column(name = "preco_total", nullable = false)
    private double preco_total;

    @Column(name = "data_Venda", nullable = false)
    private Date data_Venda;

    @Column(name = "forma_pagamento", nullable = false)
    private String forma_pagamento;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_produto")
    private Produtos p;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

}
