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
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "senha", nullable = false)
    private String senha;

    /* Ver como referenciar na tabela */
    private Funcao f;
    private Endereco endereco;



}
