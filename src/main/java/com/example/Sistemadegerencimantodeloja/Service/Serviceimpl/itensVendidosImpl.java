package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.ItensIvendidosService;
import com.example.Sistemadegerencimantodeloja.model.ItensVendidos;
import com.example.Sistemadegerencimantodeloja.repository.ItensVendidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class itensVendidosImpl implements ItensIvendidosService {

    @Autowired
    ItensVendidosRepository itensVendidosRepository;

    @Override
    public List<ItensVendidos> findAll() {
        return itensVendidosRepository.findAll();
    }


    @Override
    public ItensVendidos findById(Long id) {
        return itensVendidosRepository.findById(id).get();
    }

    @Transactional
    public ItensVendidos save(ItensVendidos itensVendidos) {
        return itensVendidosRepository.save(itensVendidos);
    }
}
