package com.example.Sistemadegerencimantodeloja.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
public class Investimento {
    private int id;
    private String descricao;
    private Date data;
    private double valor;
}
