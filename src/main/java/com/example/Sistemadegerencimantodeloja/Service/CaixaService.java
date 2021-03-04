package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Caixa;

import java.util.List;

public interface CaixaService {

    List<Caixa> findAll();
    Caixa findById(Long id);
    Caixa save(Caixa caixa);
}
