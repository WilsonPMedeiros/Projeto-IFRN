package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface itensService {
    List<itens> findAll();
    itens findById(Long id);
    itens save(itens itens);
    void deleteById(Long id);

}
