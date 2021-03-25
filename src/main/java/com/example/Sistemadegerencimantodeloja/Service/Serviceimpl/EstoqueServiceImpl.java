package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.EstoqueService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Estoque;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import com.example.Sistemadegerencimantodeloja.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstoqueServiceImpl implements EstoqueService {


    @Autowired
    EstoqueRepository repository;

    @Override
    public List<Estoque> findAll() {
        return repository.findAll();
    }

    @Override
    public Estoque findById(Long id) {
        return null;
    }


    @Transactional
    public Estoque save(Estoque estoque) {
        return repository.save(estoque);
    }

    @Override
    public void deleteById(Long id) {
       repository.deleteById(id);
    }
}
