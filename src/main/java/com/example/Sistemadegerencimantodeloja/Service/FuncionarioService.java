package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.example.Sistemadegerencimantodeloja.model.Investimento;

import java.util.List;

public interface FuncionarioService {

    List<Funcionario> findAll();
    Funcionario findById(Long id);
   Funcionario save(Funcionario funcionario);
   void deleteById(Long id);

}
