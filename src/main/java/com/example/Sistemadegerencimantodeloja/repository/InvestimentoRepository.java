package com.example.Sistemadegerencimantodeloja.repository;

import com.example.Sistemadegerencimantodeloja.model.Estoque;
import com.example.Sistemadegerencimantodeloja.model.Investimento;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> , QuerydslPredicateExecutor<Investimento>  {
}
