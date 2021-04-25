package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;


import com.example.Sistemadegerencimantodeloja.Service.DespesasService;
import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.repository.DespesasRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DespesasServiceImpl implements DespesasService {

    @Autowired
    DespesasRepository repository;

    @Override
    public List<Despesas> findAll() {

        return repository.findAll();
    }

    @Override
    public Despesas findById(Long id) {
        return repository.findById(id).get();
    }


    @Override
    public Despesas save(Despesas despesas) {
        return repository.save(despesas);
    }

    @Override
    public Iterable<Despesas> buscarNoIntervalo(Date dataI, Date dataF) {
        QDespesas qDespesas = QDespesas.despesas;
        BooleanExpression expression = qDespesas.data.between(dataI,dataF);
        System.out.println(expression.toString());
        return repository.findAll(expression);
    }
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
