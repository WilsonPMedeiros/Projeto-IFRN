package com.example.Sistemadegerencimantodeloja.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tb_estoque")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_produto")
    private Produtos produto;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
            @JoinColumn(name = "id_produto")
    List<Produtos> menorValor;
}
