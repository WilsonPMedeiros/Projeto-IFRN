package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.EnderecoServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.EstoqueServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ProdutosServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Endereco;
import com.example.Sistemadegerencimantodeloja.model.Estoque;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProdutosController {

    @Autowired
    ProdutosServiceImpl produtoService;
    @Autowired
    EstoqueServiceImpl estoqueService;

    @RequestMapping(value = "/opcaoestoque", method = RequestMethod.GET)
    public ModelAndView estoque(){
        ModelAndView mv = new ModelAndView("/opcaoEstoque.html");

        List<Produtos> produto= produtoService.findAll();

        mv.addObject("produtos", produto);
        return mv;
    }

    @GetMapping(value = "/cadastrarProduto")
    public ModelAndView cadastrarCleintes(Produtos produto, Estoque estoque){
        ModelAndView mv= new ModelAndView("/cadastrodeproduto");
        mv.addObject("produto",produto);
        mv.addObject("estoque",estoque);
        return mv;
    }
    @GetMapping(value = "/removerProduto/{id}")
    public String deletarProduto(@PathVariable("id") long id){
        produtoService.deleteById(id);
        return "redirec:/opcoesEstoque.html";
    }
    @PostMapping("/cadastrarProduto")
    public String salvaProduto(Produtos produto, Estoque estoque){
        estoque.setProduto(produto);
        System.out.println("Esse é o esstoque "+estoque);
        estoqueService.save(estoque);
        produtoService.save(produto);
        System.out.println("Esse é o esstoque "+produto);
        return "redirect:/opcaoestoque";
    }

}
