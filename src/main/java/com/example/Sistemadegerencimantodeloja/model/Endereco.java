package com.example.Sistemadegerencimantodeloja.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_endereco")
@Data
@Builder
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "num", nullable = false)
    private int num;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "uf", nullable = false)
    private String uf;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "end")
    private  Cliente cliente;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "endereco")
    private  Funcionario funcionario;


}
