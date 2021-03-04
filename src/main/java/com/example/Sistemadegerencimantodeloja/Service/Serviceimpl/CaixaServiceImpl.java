package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.CaixaService;
import com.example.Sistemadegerencimantodeloja.Service.ClienteService;
import com.example.Sistemadegerencimantodeloja.model.Caixa;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.repository.CaixaRepository;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public Caixa save(Caixa caixa) {
        return null;
    }
}
