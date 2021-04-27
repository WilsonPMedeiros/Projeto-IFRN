package com.example.Sistemadegerencimantodeloja.repository;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCpf(String nome);

}


