package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Produtos;

import java.util.List;

public interface ProdutosService {

    List<Produtos> findAll();
    Produtos findById(Long id);
    Produtos save(Produtos produtos);
    void deleteById(Long id);
}
