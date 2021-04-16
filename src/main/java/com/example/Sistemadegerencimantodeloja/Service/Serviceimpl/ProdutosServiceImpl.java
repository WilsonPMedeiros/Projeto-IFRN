package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.ProdutosService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import com.example.Sistemadegerencimantodeloja.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return repository.findById(id).get();
    }


    @Transactional
    public Produtos save(Produtos produtos) {
        return repository.save(produtos);}

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
