package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;


import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.Service.venderService;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Sistemadegerencimantodeloja.repository.venderRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class venderServiceImpl implements  venderService{

    @Autowired
    venderRepository venderRepository;

    @Override
    public List<Vender> findAll() {
        return venderRepository.findAll();
    }

    @Override
    public Vender findById(Long id) {
        return venderRepository.findById(id).get();
    }

    @Transactional
    public Vender save(Vender vender) {
        return venderRepository.save(vender);
    }

    @Override
    public Iterable<Vender> buscarNoIntervalo(Date dataI, Date dataF) {
        QVender qVendas = QVender.vender;
        // Date date1 = Date.from(dataI.atZone(ZoneId.systemDefault()).toInstant());
        //Date date2 = Date.from(dataF.atZone(ZoneId.systemDefault()).toInstant());
        BooleanExpression expression = qVendas.data_Venda.between(dataI,dataF);
        System.out.println(expression.toString());
        return venderRepository.findAll(expression);
    }
}
