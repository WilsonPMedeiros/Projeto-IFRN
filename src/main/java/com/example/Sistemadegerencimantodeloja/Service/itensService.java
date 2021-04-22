package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.*;

import java.util.Date;
import java.util.List;

public interface itensService {
    List<itens> findAll();
    itens findById(Long id);
    itens save(itens itens);

}
