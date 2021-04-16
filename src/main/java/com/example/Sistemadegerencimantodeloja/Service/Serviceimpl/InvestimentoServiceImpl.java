package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.InvestimentoService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Investimento;
import com.example.Sistemadegerencimantodeloja.model.QInvestimento;
import com.example.Sistemadegerencimantodeloja.repository.InvestimentoRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

public class InvestimentoServiceImpl implements InvestimentoService{

    @Autowired
    InvestimentoRepository investimentoRepository;

    @Autowired
    EntityManager manager;

    public List<Investimento> findAll() {
        return investimentoRepository.findAll();
    }


    public Investimento findById(Long id) {return investimentoRepository.findById(id).get();
    }

    public List<Investimento> findData(Date inicio, Date fim){

        return investimentoRepository.findAll(); }

    @Transactional
    public Investimento save(Investimento investimento) {
        return investimentoRepository.save(investimento);
    }
}
