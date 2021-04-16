package com.example.Sistemadegerencimantodeloja.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="tb_caixa")
@Data
@Builder
public class Caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "entrega", nullable = false)
    private double entrada;

    @Column(name = "saida", nullable = false)
    private double saida;

    @Column(name = "saldo", nullable = false)
    private double saldo;

}
