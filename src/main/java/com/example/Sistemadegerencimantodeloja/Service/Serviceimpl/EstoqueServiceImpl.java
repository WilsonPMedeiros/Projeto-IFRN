package com.example.Sistemadegerencimantodeloja.Service.Serviceimpl;

import com.example.Sistemadegerencimantodeloja.Service.EstoqueService;
import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.repository.ClienteRepository;
import com.example.Sistemadegerencimantodeloja.repository.EstoqueRepository;
import com.example.Sistemadegerencimantodeloja.repository.ItensRepository;
import com.example.Sistemadegerencimantodeloja.repository.ProdutosRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.Sistemadegerencimantodeloja.model.itens;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstoqueServiceImpl implements EstoqueService {


    @Autowired
    EstoqueRepository repository;

    @Autowired
    EntityManager manager;

    @Autowired
    ItensRepository itensRepository;

    @Autowired
    ProdutosRepository produtosRepository;

    @Override
    public List<Estoque> findAll() {
        return repository.findAll();
    }

    @Override
    public Estoque findById(Long id) {
        return null;
    }


    @Transactional
    public Estoque save(Estoque estoque) {
        return repository.save(estoque);
    }

    @Override
    public void deleteById(Long id) {
       repository.deleteById(id);
    }

    @Override
    public Iterable<itens> buscarProdutosComMenorValor(Double valor) {
        return null;
    }

    @Override
    public Iterable<itens> buscarProdutosComMenorValor(double v) {
        Qitens qProdutos = Qitens.itens;
        // Verifica se a quantidade de unidades é menor ou igual ao volume mínimo
        BooleanExpression expression = qProdutos.valorVenda.loe(v);
        System.out.println(expression.toString());
        return itensRepository.findAll(expression);
    }

}
