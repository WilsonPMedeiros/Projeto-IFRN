package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.itensService;
import com.example.Sistemadegerencimantodeloja.model.QVendas;
import com.example.Sistemadegerencimantodeloja.model.Vendas;
import com.example.Sistemadegerencimantodeloja.repository.ItensRepository;
import com.example.Sistemadegerencimantodeloja.repository.VendasRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Sistemadegerencimantodeloja.model.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class itensServiceImpl implements itensService{

    @Autowired
    ItensRepository itensRepository;

    @Override
    public List<itens> findAll() {
        return itensRepository.findAll();
    }

    @Override
    public itens findById(Long id) {
        return itensRepository.findById(id).get();
    }

    @Transactional
    public itens save(itens itens) {
        return itensRepository.save(itens);
    }
    @Override
    public void deleteById(Long id) { itensRepository.deleteById(id);
    }



}
