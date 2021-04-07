package com.example.Sistemadegerencimantodeloja.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_funcao")
@Data
@Builder
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "salario", nullable = false)
    private double salario;

    @Column(name = "nome", nullable = false)
    private String nome;

    /*
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "f")
    private Funcionario funcionario;*/
}
