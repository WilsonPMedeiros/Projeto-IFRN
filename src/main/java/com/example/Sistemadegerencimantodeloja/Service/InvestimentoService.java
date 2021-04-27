package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Caixa;
import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Investimento;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Service
public interface InvestimentoService {

    List<Investimento> findAll();
    Investimento findById(Long id);
    Investimento save(Investimento investimento);
    void deleteById(Long id);
    Iterable<Investimento>  buscarNoIntervalo(java.util.Date dataI, Date dataF);
}
