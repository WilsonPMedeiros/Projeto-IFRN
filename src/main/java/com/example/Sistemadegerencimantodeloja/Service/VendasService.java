package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Vendas;

import java.util.List;

public interface VendasService {

    List<Vendas> findAll();
    Vendas findById(Long id);
    Vendas save(Vendas vendas);
}
