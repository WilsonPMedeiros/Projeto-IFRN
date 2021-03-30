package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.VendasService;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.model.Vendas;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import com.example.Sistemadegerencimantodeloja.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class VendasServiceImpl implements VendasService {

    @Autowired
    VendasRepository repository;

    @Override
    public List<Vendas> findAll() {
        return repository.findAll();
    }

    @Override
    public Vendas findById(Long id) {
        return null;
    }


    @Override
    public Vendas save(Vendas vendas) {
        return null;
    }


}




