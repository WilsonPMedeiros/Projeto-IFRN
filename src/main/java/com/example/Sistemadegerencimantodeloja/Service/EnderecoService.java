package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Endereco;

import java.util.List;

public interface EnderecoService {
    List<Endereco> findAll();
    Endereco findById(Long id);
    Endereco save(Endereco end);
}
