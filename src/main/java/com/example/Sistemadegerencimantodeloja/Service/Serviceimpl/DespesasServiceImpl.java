package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;


import com.example.Sistemadegerencimantodeloja.Service.DespesasService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }


    @Override
    public Despesas save(Despesas despesas) {
        return null;
    }
}
