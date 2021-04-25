package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.model.Estoque;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.EstoqueServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.itensServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.Sistemadegerencimantodeloja.model.itens;

import javax.xml.ws.Action;
import java.util.List;

@Controller
public class ItensController {

    @Autowired
    itensServiceImpl itensService;

    @Autowired
    EstoqueServiceImpl estoqueService;

    @Autowired
    EstoqueRepository estoqueRepository;

    @RequestMapping(value = "/opcaoestoque", method = RequestMethod.GET)
    public ModelAndView estoque(){
        ModelAndView mv = new ModelAndView("/opcaoEstoque.html");

        List<itens> produto= itensService.findAll();
        mv.addObject("produtos", produto);
        return mv;
    }

    @GetMapping(value = "/cadastrarProduto")
    public ModelAndView cadastrarProdutos(itens produto, Estoque estoque){
        ModelAndView mv= new ModelAndView("/cadastrodeproduto");
        mv.addObject("produto",produto);
        mv.addObject("estoque",estoque);
        return mv;
    }
    @GetMapping(value = "/removerProduto/{id}")
    public String deletarProduto(@PathVariable("id") long id){
        itens i = itensService.findById(id);
        Estoque e = estoqueRepository.findByItem(i);
        estoqueService.deleteById(e.getId());
        itensService.deleteById(id);
        return "redirect:/opcaoestoque";
    }

    @PostMapping("/cadastrarProduto")
    public String salvaProduto(itens produto, Estoque estoque){
        System.out.println("Esse é o esstoque "+estoque);
        estoqueService.save(estoque);
        itensService.save(produto);
        estoque.setItem(produto);
        estoqueService.save(estoque);
        System.out.println("Esse é o esstoque "+produto);
        return "redirect:/opcaoestoque";
    }

    @RequestMapping(value = "/opcaoestoque{valorVenda}", method = RequestMethod.POST)
    public ModelAndView menorValor(@RequestParam("valorVendaInput") double valorVenda) {
        ModelAndView mv = new ModelAndView("/opcaoEstoqueFiltro.html");
        List<itens> produto= (List<itens>) estoqueService.buscarProdutosComMenorValor(valorVenda);
        System.out.println("Resultado da query " +produto);
        mv.addObject("produtos", produto);
        return mv;
    }
}
