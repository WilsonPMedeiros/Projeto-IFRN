package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.example.Sistemadegerencimantodeloja.model.Investimento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FuncionarioService {

    List<Funcionario> findAll();
    Funcionario findById(Long id);
   Funcionario save(Funcionario funcionario);
   void deleteById(Long id);

}
