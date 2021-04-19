package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.FuncaoService;
import com.example.Sistemadegerencimantodeloja.Service.FuncionarioService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import com.example.Sistemadegerencimantodeloja.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return repository.findById(id).get();
    }


    @Transactional
    public Funcionario save(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }




}
