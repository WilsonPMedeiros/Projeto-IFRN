package com.example.Sistemadegerencimantodeloja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tb_endereco")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "num", nullable = false)
    private int num;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "uf", nullable = false)
    private String uf;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "cep", nullable = false)
    private  String cep;
    /*@OneToOne(fetch = FetchType.LAZY, mappedBy = "end")
    private  Cliente cliente;*/

   /* @OneToOne(fetch = FetchType.LAZY, mappedBy = "endereco")
    private  Funcionario funcionario;*/


}
