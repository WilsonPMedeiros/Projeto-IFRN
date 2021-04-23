package com.example.Sistemadegerencimantodeloja.controllers;


import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.FuncaoServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Endereco;
import com.example.Sistemadegerencimantodeloja.model.Funcao;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FuncaoController {

    @Autowired
    FuncaoServiceImpl funcaoService;

    @RequestMapping(value = "/opcoesFuncao", method = RequestMethod.GET)
    public ModelAndView getClientes(){
        ModelAndView mv = new ModelAndView("/opcoesFuncao.html");
        List<Funcao> funcoes=funcaoService.findAll();
        mv.addObject("funcoes", funcoes);
        return mv;
    }

    @GetMapping(value = "/opcoes/excluirFuncao/{id}")
    public String deletarFuncao(@PathVariable("id") long id){
        funcaoService.deleteById(id);
        return "redirect:/opcoesFuncao";
    }

    @GetMapping(value = "/cadastrarFuncao")
    public ModelAndView cadastrarFuncao(Funcao funcao){
        ModelAndView mv= new ModelAndView("/CadastrarFuncao.html");
        return mv;
    }

    @PostMapping(value = "/cadastrarFuncao")
    public String salvaFuncao(Funcao funcao){
        double f = (double) funcao.getSalario();
        funcao.setSalario(f);
        funcaoService.save(funcao);
        return "redirect:/opcoesFuncao";
    }

    @GetMapping("/editarFuncao{id}")
    public ModelAndView editarfuncao(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("/EditarFuncao.html");
        Funcao funcao = funcaoService.findById(id);
        mv.addObject("funcao", funcao);
        return  mv;
    }

    @PostMapping("/editarFuncao{id}")
    public String editarfuncaoo(@PathVariable("id") long id,
                                   @ModelAttribute("nome") String nome,
                                   @ModelAttribute("salario") double salario){
        Funcao funcaoEditado = funcaoService.findById(id);
        funcaoEditado.setNome(nome);
        funcaoEditado.setSalario(salario);
        funcaoService.save(funcaoEditado);
        return "redirect:/opcoesFuncao";
    }




}
