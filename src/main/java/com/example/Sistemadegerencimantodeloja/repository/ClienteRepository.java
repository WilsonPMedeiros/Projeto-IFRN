package com.example.Sistemadegerencimantodeloja.repository;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCpf(String nome);

}


