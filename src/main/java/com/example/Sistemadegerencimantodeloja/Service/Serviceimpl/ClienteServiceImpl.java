package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;



import com.example.Sistemadegerencimantodeloja.Service.ClienteService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return null;
    }


    @Transactional
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}

