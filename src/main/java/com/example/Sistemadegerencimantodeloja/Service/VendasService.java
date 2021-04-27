package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.model.Vendas;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface VendasService{

    List<Vendas> findAll();
    Vendas findById(Long id);
    Vendas save(Vendas vendas);
    Iterable<Vendas>  buscarNoIntervalo(Date dataI, Date dataF);

    //Vendas add(Produtos produto);
}
