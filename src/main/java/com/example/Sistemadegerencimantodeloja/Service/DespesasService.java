package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Caixa;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Despesas;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
public interface DespesasService {

    List<Despesas> findAll();
    Despesas findById(Long id);
    Despesas save(Despesas despesas);
    Iterable<Despesas>  buscarNoIntervalo(Date dataI, Date dataF);
    void deleteById(Long id);
}
