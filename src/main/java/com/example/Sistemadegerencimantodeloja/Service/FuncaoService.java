package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Funcao;

import java.util.List;

public interface FuncaoService {

    List<Funcao> findAll();
    Funcao findById(Long id);
    Funcao save(Funcao funcao);
}
