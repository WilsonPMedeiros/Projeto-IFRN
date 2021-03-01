package com.example.Sistemadegerencimantodeloja.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_funcionario")
@Embeddable
@Data
@Builder
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
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
