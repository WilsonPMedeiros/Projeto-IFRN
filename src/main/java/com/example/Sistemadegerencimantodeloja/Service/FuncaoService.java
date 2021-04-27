package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Funcao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FuncaoService {

    List<Funcao> findAll();
    Funcao findById(Long id);
    Funcao save(Funcao funcao);
    void deleteById(Long id);
}
