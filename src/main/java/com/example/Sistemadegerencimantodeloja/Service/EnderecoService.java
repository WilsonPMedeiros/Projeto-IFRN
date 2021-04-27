package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Endereco;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnderecoService {
    List<Endereco> findAll();
    Endereco findById(Long id);
    Endereco save(Endereco end);
    void deleteById(Long id);
}
