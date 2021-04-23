package com.example.Sistemadegerencimantodeloja.Service;

import com.example.Sistemadegerencimantodeloja.model.*;

import java.util.Date;
import java.util.List;

public interface venderService {
    List<Vender> findAll();
    Vender findById(Long id);
    Vender save(Vender vendas);
    Iterable<Vender>  buscarNoIntervalo(Date dataI, Date dataF);

}
