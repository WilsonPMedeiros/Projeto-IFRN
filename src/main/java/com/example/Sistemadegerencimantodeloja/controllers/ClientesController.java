package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.EnderecoService;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ClienteServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.EnderecoServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class ClientesController {
    @Autowired
    ClienteServiceImpl clienteService;

    @Autowired
    EnderecoServiceImpl enderecoService;




/*    @RequestMapping(value = "/opcoes", method = RequestMethod.GET)
    public String opcoesClientes(){

        return "opcoesCliente.html";
    }*/


    //busca todos os clientes
    @RequestMapping(value = "/opcoes", method = RequestMethod.GET)
    public ModelAndView getClientes(){
        ModelAndView mv = new ModelAndView("/opcoesCliente.html");
        List<Cliente>clientes=clienteService.findAll();
        mv.addObject("clientes", clientes);
        //System.out.println(clientes);
        return mv;
    }

    @GetMapping(value = "/cadastrar")
    public ModelAndView cadastrarCleintes(Cliente cliente){
        ModelAndView mv= new ModelAndView("/cadastrodeCliente");
        mv.addObject("cliente",cliente);
        return mv;
    }
    @PostMapping("/cadastrar")
    public String salvaCliente(Cliente cliente, Endereco endereco){
        enderecoService.save(endereco);
        cliente.setEnd(endereco);
        clienteService.save(cliente);

        // Cadastra e atualiza
        return "redirect:/opcoes";
    }


}
