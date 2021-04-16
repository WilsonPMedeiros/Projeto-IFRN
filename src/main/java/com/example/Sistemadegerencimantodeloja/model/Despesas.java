package com.example.Sistemadegerencimantodeloja.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_despesas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Despesas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "valor", nullable = false)
    private double valor;
}
