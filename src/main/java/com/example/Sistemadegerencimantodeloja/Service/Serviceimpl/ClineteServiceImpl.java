package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;



import com.example.Sistemadegerencimantodeloja.Service.ClienteService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Mostra para o Spring que ele deverá gerenciar essa classe
class ClienteServiceImpl implements ClienteService {

    /* Ponto de injeção do Repository
    Para utilizar as instâncias do ProdutoRepository
     */
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


    @Override
    public Cliente save(Cliente cliente) {
        return null;
    }

}

