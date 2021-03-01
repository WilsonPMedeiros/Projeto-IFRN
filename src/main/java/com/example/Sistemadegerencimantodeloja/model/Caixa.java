package com.example.Sistemadegerencimantodeloja.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="tb_caixa")
@Embeddable
@Data
@Builder
public class Caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private Date data;
    private double entrada;
    private double saida;
    private double saldo;

}
