package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.EnderecoServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.FuncionarioServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Endereco;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FuncionarioController {
    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @Autowired
    EnderecoServiceImpl enderecoService;

    @RequestMapping(value = "/opcoesFuncionario", method = RequestMethod.GET)
    public ModelAndView getClientes(){
        ModelAndView mv = new ModelAndView("/opcoesFuncionarios.html");
        List<Funcionario>funcionarios=funcionarioService.findAll();
        mv.addObject("funcionarios", funcionarios);
        return mv;
    }

    @GetMapping(value = "/cadastrarFuncionario")
    public ModelAndView cadastrarCleintes(Funcionario funcionario, Endereco endereco){
        ModelAndView mv= new ModelAndView("/cadastroFuncionario.html");
        mv.addObject("funcionario",funcionario);
        return mv;
    }


    @PostMapping("/cadastrarFuncionario")
    public String salvaFuncionario(Funcionario funcionario, Endereco endereco) {
        enderecoService.save(endereco);
        funcionario.setEndereco(endereco);
        funcionarioService.save(funcionario);
        return "redirect:/opcoesFuncionario";

    }

    @GetMapping(value = "/removerProduto/{id}")
    public String deletarFuncionario(@PathVariable("id") long id){
        funcionarioService.deleteById(id);
        return "redirec:/opcoesFuncionario";
    }
}
