package com.example.Sistemadegerencimantodeloja.repository;
import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface VendasRepository extends JpaRepository<Vendas, Long>, QuerydslPredicateExecutor<Vendas> {

}
