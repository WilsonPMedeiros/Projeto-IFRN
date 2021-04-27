package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Produtos;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProdutosVendidosService {

    List<Produtos> findAll();
    Produtos findById(Long id);
    Produtos save(Produtos produtos);
    void deleteById(Long id);
}
