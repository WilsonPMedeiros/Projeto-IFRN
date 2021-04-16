package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Investimento;

import java.sql.Date;
import java.util.List;

public interface InvestimentoService {

    List<Investimento> findAll();
    Investimento findById(Long id);
    Investimento save(Investimento investimento);
    List<Investimento> findData(Date inicio, Date fim);
}
