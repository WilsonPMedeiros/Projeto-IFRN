package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface venderService {
    List<Vender> findAll();
    Vender findById(Long id);
    Vender save(Vender vendas);
    Iterable<Vender>  buscarNoIntervalo(Date dataI, Date dataF);
    void deleteById(Long id);

}
