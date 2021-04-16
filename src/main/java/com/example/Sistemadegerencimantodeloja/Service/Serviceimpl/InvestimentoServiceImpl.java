package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.InvestimentoService;
import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.repository.InvestimentoRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class InvestimentoServiceImpl implements InvestimentoService{

    @Autowired
    InvestimentoRepository investimentoRepository;


    public List<Investimento> findAll() {
        return investimentoRepository.findAll();
    }


    public Investimento findById(Long id) {return investimentoRepository.findById(id).get();
    }

    @Override
    public Iterable<Investimento> buscarNoIntervalo(java.util.Date dataI, Date dataF) {
        QInvestimento qInvestimento = QInvestimento.investimento;
        BooleanExpression expression = qInvestimento.data.between(dataI,dataF);
        System.out.println(expression.toString());
        return investimentoRepository.findAll(expression);
    }

    @Transactional
    public Investimento save(Investimento investimento) {
        return investimentoRepository.save(investimento);
    }
}
