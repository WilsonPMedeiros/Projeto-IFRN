package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Despesas;

import java.util.List;

public interface DespesasService {

    List<Despesas> findAll();
    Despesas findById(Long id);
    Despesas save(Despesas despesas);
}
