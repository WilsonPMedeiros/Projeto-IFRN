package com.example.Sistemadegerencimantodeloja.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="itens")
public class itens {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_itens", nullable = false)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor_custo", nullable = false)
    private double valorCusto;

    @Column(name = "valor_venda", nullable = false)
    private double valorVenda;

    @Column(name = "grupo", nullable = false)
    private String grupo;

}
