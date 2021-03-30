package com.example.Sistemadegerencimantodeloja.repository;

import com.example.Sistemadegerencimantodeloja.model.Estoque;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>, QuerydslPredicateExecutor<Estoque> {
}
