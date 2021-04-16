package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Caixa;
import com.example.Sistemadegerencimantodeloja.model.Vendas;

import java.util.Date;
import java.util.List;

public interface CaixaService {

    List<Caixa> findAll();
    Caixa findById(Long id);
    Caixa save(Caixa caixa);
    Iterable<Caixa>  buscarNoIntervalo(Date dataI, Date dataF);
}
