package com.example.Sistemadegerencimantodeloja.model;


import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Produtos {

    private int id;
    private String descricao;
    private double valor_custo;
    private double valor_venda;
    private String grupo;
}
