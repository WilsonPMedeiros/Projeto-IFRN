package com.example.Sistemadegerencimantodeloja.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Funcionario {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String login;
    private String sexo;
    private Funcao f;
    private String senha;
    private Endereco endereco;


}
