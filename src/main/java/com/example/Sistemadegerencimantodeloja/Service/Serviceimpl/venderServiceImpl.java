package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;


import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.Service.venderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Sistemadegerencimantodeloja.repository.venderRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class venderServiceImpl implements  venderService{

    @Autowired
    venderRepository venderRepository;

    @Override
    public List<Vender> findAll() {
        return venderRepository.findAll();
    }

    @Override
    public Vender findById(Long id) {
        return venderRepository.findById(id).get();
    }

    @Transactional
    public Vender save(Vender vender) {
        return venderRepository.save(vender);
    }
}
