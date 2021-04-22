package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.ItensVendidos;

import java.util.List;

public interface ItensIvendidosService {

    List<ItensVendidos> findAll();
    ItensVendidos findById(Long id);
    ItensVendidos save(ItensVendidos itensVendidos);

}
