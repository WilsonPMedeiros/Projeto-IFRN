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
    private int id;
    private String descricao;
    private double valor_custo;
    private double valor_venda;
    private String grupo;
}
