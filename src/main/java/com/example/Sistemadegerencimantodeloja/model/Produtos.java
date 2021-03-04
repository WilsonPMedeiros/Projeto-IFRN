package com.example.Sistemadegerencimantodeloja.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_produtos")
@Embeddable
@Data
@Builder
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor_custo", nullable = false)
    private double valor_custo;

    @Column(name = "valor_venda", nullable = false)
    private double valor_venda;

    @Column(name = "grupo", nullable = false)
    private String grupo;
}
