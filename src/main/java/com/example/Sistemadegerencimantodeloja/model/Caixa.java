package com.example.Sistemadegerencimantodeloja.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="tb_caixa")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "entrada", nullable = false)
    private double entrada;

    @Column(name = "saida", nullable = false)
    private double saida;

    @Column(name = "saldo", nullable = false)
    private double saldo;


}
