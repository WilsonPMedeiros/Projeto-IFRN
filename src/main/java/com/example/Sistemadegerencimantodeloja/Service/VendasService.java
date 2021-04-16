package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.model.Vendas;

import java.util.Date;
import java.util.List;

public interface VendasService {

    List<Vendas> findAll();
    Vendas findById(Long id);
    Vendas save(Vendas vendas);
    Vendas add(Produtos produtos);
    Iterable<Vendas>  buscarNoIntervalo(Date dataI, Date dataF);

    ///Vendas add(Produtos produto);
}
