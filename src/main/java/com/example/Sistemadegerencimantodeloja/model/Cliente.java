package com.example.Sistemadegerencimantodeloja.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String sexo;
    private Endereco end;



}
