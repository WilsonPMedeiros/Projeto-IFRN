package com.example.Sistemadegerencimantodeloja.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vender {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "desconto")
    private double desconto;

    @Column(name = "preco_venda")
    private double preco_venda;

    @Column(name = "preco_total")
    private double preco_total;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_Venda")
    private Date data_Venda;
/*
    @Column(name = "forma_pagamento")
    private String forma_pagamento;*/

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;




}
