package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.ProdutosService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import com.example.Sistemadegerencimantodeloja.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosServiceImpl implements ProdutosService {


    @Autowired
    ProdutosRepository repository;

    @Override
    public List<Produtos> findAll() {
        return repository.findAll();
    }

    @Override
    public Produtos findById(Long id) {
        return null;
    }


    @Override
    public Produtos save(Produtos produtos) {
        return null;
    }
}
