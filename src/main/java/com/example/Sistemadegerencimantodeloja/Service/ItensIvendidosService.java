package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.ItensVendidos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItensIvendidosService {

    List<ItensVendidos> findAll();
    ItensVendidos findById(Long id);
    ItensVendidos save(ItensVendidos itensVendidos);
    void deleteById(Long id);

}
