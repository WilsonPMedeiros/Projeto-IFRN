package com.example.Sistemadegerencimantodeloja.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Estoque {
    private int id;
    private int quantidade;
}
