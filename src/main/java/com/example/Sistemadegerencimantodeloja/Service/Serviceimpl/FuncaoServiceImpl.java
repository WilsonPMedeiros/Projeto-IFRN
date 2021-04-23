package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.FuncaoService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Funcao;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import com.example.Sistemadegerencimantodeloja.repository.FuncaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncaoServiceImpl implements FuncaoService {


    @Autowired
    FuncaoRepository repository;

    @Override
    public List<Funcao> findAll() {
        return repository.findAll();
    }

    @Override
    public Funcao findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Funcao save(Funcao funcao) {
        return repository.save(funcao);
    }
}
