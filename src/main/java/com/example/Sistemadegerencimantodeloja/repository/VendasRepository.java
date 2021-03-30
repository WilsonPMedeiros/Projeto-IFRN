package com.example.Sistemadegerencimantodeloja.repository;

import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.model.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<Vendas, Long> {

}
