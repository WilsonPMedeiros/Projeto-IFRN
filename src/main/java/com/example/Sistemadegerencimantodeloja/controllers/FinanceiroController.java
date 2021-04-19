package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.CaixaServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Caixa;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.NumberExpression;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FinanceiroController {
    @Autowired
    CaixaServiceImpl caixaService;

    @RequestMapping(value = "/opcoeController", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/opcoesFechamento.html");
        return mv;
    }


    @RequestMapping(value = "/opcoesFinanceiro", method = RequestMethod.GET)
    public ModelAndView getFinanceiro(){
        ModelAndView mv = new ModelAndView("/opcoesFinanceiro.html");
        return mv;
    }
    @RequestMapping(value = "/opcoesFechamentoCaixa", method = RequestMethod.GET)
    public ModelAndView getFechamento(){
        ModelAndView mv = new ModelAndView("/opcoesFechamento.html");
        List<Caixa> saidas= caixaService.findAll();
        System.out.println("Lista das saídas"+ saidas);


        saidas.set(4, (Caixa) caixaService.buscarSaldo());
        mv.addObject("saidas", saidas);
        return mv;
    }

    private String toString(NumberExpression<Double> buscarSaldo) {
        return buscarSaldo.toString();
    }

    @RequestMapping(value = "/opcoesDespesas", method = RequestMethod.GET)
    public ModelAndView getDespesas(){
        ModelAndView mv = new ModelAndView("/opcaoDespesa.html");
        return mv;
    }
    @RequestMapping(value = "/opcoesInvestimento", method = RequestMethod.GET)
    public ModelAndView getInvestimento(){
        ModelAndView mv = new ModelAndView("/opcaoInvestimento.html");
        return mv;
    }

    @RequestMapping(value = "/adicionarSaida", method = RequestMethod.GET)
    public ModelAndView adicionarSaida(){
        ModelAndView mv= new ModelAndView("/adicionarSaida.html");
        return mv;
    }

    @PostMapping(value = "/adicionarSaida")
    public String saidaS(Caixa caixa){
        caixaService.save(caixa);
        return "redirect:/adicionarSaida";
    }
}
