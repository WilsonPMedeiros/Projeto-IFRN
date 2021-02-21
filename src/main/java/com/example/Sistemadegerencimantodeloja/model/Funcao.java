package com.example.Sistemadegerencimantodeloja.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Funcao {
    private int id;
    private double salario;
    private String nome;
}
