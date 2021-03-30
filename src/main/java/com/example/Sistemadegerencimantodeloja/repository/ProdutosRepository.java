package com.example.Sistemadegerencimantodeloja.repository;

import com.example.Sistemadegerencimantodeloja.model.Estoque;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProdutosRepository extends JpaRepository<Produtos, Long>, QuerydslPredicateExecutor<Produtos> {

}
