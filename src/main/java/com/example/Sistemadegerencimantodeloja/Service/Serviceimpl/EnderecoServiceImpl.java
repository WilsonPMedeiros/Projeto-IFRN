package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.EnderecoService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Endereco;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import com.example.Sistemadegerencimantodeloja.repository.EnderecoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    EnderecoRepositoy repository;

    @Override
    public List<Endereco> findAll() {
        return repository.findAll();
    }

    @Override
    public Endereco findById(Long id) {
        return null;
    }


    @Override
    public Endereco save(Endereco endereco) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
