package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.VendasService;
import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.repository.VendasRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.*;



@Service
public class VendasServiceImpl implements VendasService {

    @Autowired
    VendasRepository repository;

    @Override
    public List<Vendas> findAll() {
        return repository.findAll();
    }

    @Override
    public Vendas findById(Long id) {
        return repository.findById(id).get();
    }


    @Override
    public Vendas save(Vendas vendas) {
        return null;
    }

    @Override
    public Vendas add(Produtos produtos) {
        return  Vendas.builder().build();
    }

    @Override
    public Iterable<Vendas> buscarNoIntervalo(Date dataI, Date dataF) {
        QVendas qVendas = QVendas.vendas;
        // Verifica se a quantidade de unidades é menor ou igual ao volume mínimo
       // Date date1 = Date.from(dataI.atZone(ZoneId.systemDefault()).toInstant());
        //Date date2 = Date.from(dataF.atZone(ZoneId.systemDefault()).toInstant());
        BooleanExpression expression = qVendas.data_Venda.between(dataI,dataF);
        System.out.println(expression.toString());
        return repository.findAll(expression);
    }

    public double somarValor(double valor, int quant){
        return valor*quant;
    }



}




