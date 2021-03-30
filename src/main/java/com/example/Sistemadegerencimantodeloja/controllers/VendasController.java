package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ClienteServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.FuncionarioServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.VendasServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import com.example.Sistemadegerencimantodeloja.model.Vendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VendasController {

    @Autowired
     VendasServiceImpl vendasService;

    @Autowired
    ClienteServiceImpl clienteService;

    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @RequestMapping(value = "/opcoesVendas", method = RequestMethod.GET)
    public ModelAndView vendas(){
        ModelAndView mv = new ModelAndView("/opcaoVendas.html");
        List<Vendas> vendas=vendasService.findAll();
        mv.addObject("vendas", vendas);
        return mv;
    }

    @GetMapping(value = "/cadastrarVendas")
    public ModelAndView cadastrarVendas(Cliente cliente, Funcionario funcionario){
        ModelAndView mv = new ModelAndView("/vendas.html");
        List<Cliente> clientes=  clienteService.findAll();
        List<Funcionario> funcionarios= funcionarioService.findAll();
        mv.addObject("clientes", clientes);
        mv.addObject("funcionarios", funcionarios);
        return mv;
    }
    @PostMapping(value = "/adicionar")
    public ModelAndView adicionarCompra(Produtos p){
        ModelAndView mv = new ModelAndView("/vendas.html");
        //vendasService.add(p);
        List<Vendas> v= vendasService.findAll();

        mv.addObject("vendas", v);

       return mv;
    }

}
