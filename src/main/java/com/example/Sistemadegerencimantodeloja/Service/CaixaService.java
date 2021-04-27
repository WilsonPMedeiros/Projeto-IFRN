package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Caixa;
import com.querydsl.core.types.dsl.NumberExpression;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface CaixaService {

    List<Caixa> findAll();
    Caixa findById(Long id);
    Caixa save(Caixa caixa);
    Iterable<Caixa>  buscarNoIntervalo(Date dataI, Date dataF);
    Iterable<Caixa> buscarSaldo();
}
