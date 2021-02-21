package com.example.Sistemadegerencimantodeloja.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Endereco {
    private int id;
    private String logradouro;
    private int num;
    private String cidade;
    private String uf;
    private String bairro;
}
