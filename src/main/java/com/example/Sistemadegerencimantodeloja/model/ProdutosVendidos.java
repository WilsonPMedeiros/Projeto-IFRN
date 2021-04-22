package com.example.Sistemadegerencimantodeloja.model;

import javax.persistence.*;

@Entity
@Table(name="tb_produtos_vendidos")
public class ProdutosVendidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor_custo", nullable = false)
    private double valorCusto;

    @Column(name = "valor_venda", nullable = false)
    private double valorVenda;

    @Column(name = "grupo", nullable = false)
    private String grupo;

    //@OneToOne()


}
