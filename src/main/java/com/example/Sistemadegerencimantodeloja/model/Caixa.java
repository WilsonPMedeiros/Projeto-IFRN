package com.example.Sistemadegerencimantodeloja.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
public class Caixa {
    private int id;
    private Date data;
    private double entrada;
    private double saida;
    private double saldo;

}
