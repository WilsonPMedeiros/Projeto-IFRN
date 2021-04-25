package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Estoque;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.model.itens;

import java.util.List;

public interface EstoqueService {

    List<Estoque> findAll();
    Estoque findById(Long id);
    Estoque save(Estoque estoque);
    void deleteById(Long id);
    Iterable<itens>  buscarProdutosComMenorValor(Double valor);


    Iterable<itens> buscarProdutosComMenorValor(double v);
}
