package com.example.Sistemadegerencimantodeloja.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tb_funcao")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "salario")
    private double salario;

    @Column(name = "nome")
    private String nome;

    /*
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "f")
    private Funcionario funcionario;*/
}
