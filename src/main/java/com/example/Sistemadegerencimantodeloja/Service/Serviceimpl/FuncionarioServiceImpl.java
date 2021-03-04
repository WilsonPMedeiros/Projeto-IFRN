package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.FuncaoService;
import com.example.Sistemadegerencimantodeloja.Service.FuncionarioService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import com.example.Sistemadegerencimantodeloja.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {


    @Autowired
    FuncionarioRepository repository;

    @Override
    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    @Override
    public Funcionario findById(Long id) {
        return null;
    }


    @Override
    public Funcionario save(Funcionario funcionario) {
        return null;
    }
}
