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
    private Long id;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "entrega", nullable = false)
    private double entrada;

    @Column(name = "saida", nullable = false)
    private double saida;

    @Column(name = "saldo", nullable = false)
    private double saldo;

}
