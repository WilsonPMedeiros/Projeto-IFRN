package com.example.Sistemadegerencimantodeloja.repository;

import com.example.Sistemadegerencimantodeloja.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CaixaRepository extends JpaRepository<Caixa, Long>, QuerydslPredicateExecutor<Caixa> {
}
