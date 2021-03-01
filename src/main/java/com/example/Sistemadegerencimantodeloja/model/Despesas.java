package com.example.Sistemadegerencimantodeloja.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_despesas")
@Embeddable
@Data
@Builder
public class Despesas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String descricao;
    private Date data;
    private double valor;
}
