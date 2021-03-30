package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.EstoqueServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Estoque;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EstoqueController {
    @Autowired
    EstoqueServiceImpl estoqueService;

   /* @RequestMapping(value = "/opecaoEstoque", method = RequestMethod.GET)
    public ModelAndView menorValor() {
        ModelAndView mv = new ModelAndView("/opcaoEstoque.html");
        List<Produtos> estoque= (List<Produtos>) estoqueService.buscarProdutosComMenorValor();
        mv.addObject("estoues", estoque);
        return mv;
    }*/
}
