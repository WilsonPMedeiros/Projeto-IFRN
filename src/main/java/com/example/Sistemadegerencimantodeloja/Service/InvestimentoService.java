package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Caixa;
import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Investimento;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

public interface InvestimentoService {

    List<Investimento> findAll();
    Investimento findById(Long id);
    Investimento save(Investimento investimento);
    void deleteById(Long id);
    Iterable<Investimento>  buscarNoIntervalo(java.util.Date dataI, Date dataF);
}
