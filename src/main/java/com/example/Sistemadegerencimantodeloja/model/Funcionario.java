package com.example.Sistemadegerencimantodeloja.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.sql.rowset.CachedRowSet;

@Entity
@Table(name="tb_funcionario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_funcao")
    private Funcao f;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_end")
    private Endereco endereco;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "funcionario")
    private Vendas vendas;


}
