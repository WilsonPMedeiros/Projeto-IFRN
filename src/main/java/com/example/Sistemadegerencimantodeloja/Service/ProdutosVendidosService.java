package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Produtos;

import java.util.List;

public interface ProdutosVendidosService {

    List<Produtos> findAll();
    Produtos findById(Long id);
    Produtos save(Produtos produtos);
    void deleteById(Long id);
}
