package com.example.Sistemadegerencimantodeloja.repository;

import com.example.Sistemadegerencimantodeloja.model.ItensVendidos;
import com.example.Sistemadegerencimantodeloja.model.Vender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ItensVendidosRepository extends JpaRepository<ItensVendidos, Long>, QuerydslPredicateExecutor<ItensVendidos> {
    List<ItensVendidos> findByVendas(Vender vender);
}
