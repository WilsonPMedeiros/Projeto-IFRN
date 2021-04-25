package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.CaixaService;
import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.repository.CaixaRepository;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.DatabaseMetaData;
import java.util.Date;
import java.util.List;

@Service
public class CaixaServiceImpl implements CaixaService {

    @Autowired
    CaixaRepository repository;

    @Override
    public List<Caixa> findAll() {
        return repository.findAll();
    }

    @Override
    public Caixa findById(Long id) {
        return null;
    }


   @Transactional
    public Caixa save(Caixa caixa) {
        return repository.save(caixa);
    }

    @Override
    public Iterable<Caixa> buscarNoIntervalo(Date dataI, Date dataF) {
        QCaixa qCaixa = QCaixa.caixa;
        BooleanExpression expression = qCaixa.data.between(dataI,dataF);
        System.out.println(expression.toString());
        return repository.findAll(expression);
    }


    @Override
    public Iterable<Caixa> buscarSaldo() {
        QCaixa qCaixa= QCaixa.caixa;
        OrderSpecifier<Double> expression=qCaixa.saldo.asc();
        System.out.println("Soma dos saldos "+  expression.toString());
        return repository.findAll(expression);
        }
    }

