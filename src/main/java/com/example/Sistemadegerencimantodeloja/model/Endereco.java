package com.example.Sistemadegerencimantodeloja.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_endereco")
@Embeddable
@Data
@Builder
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String logradouro;
    private int num;
    private String cidade;
    private String uf;
    private String bairro;
}
