package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.CaixaService;
import com.example.Sistemadegerencimantodeloja.Service.InvestimentoService;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.CaixaServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.DespesasServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.InvestimentoServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.venderServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.VendasServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.repository.InvestimentoRepository;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.NumberExpression;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class FinanceiroController {


    @Autowired
    CaixaServiceImpl caixaService;

    @Autowired
    DespesasServiceImpl despesasService;

    @Autowired
    InvestimentoServiceImpl investimentoService;

    @Autowired
    InvestimentoRepository investimentoRepository;

    @Autowired
    venderServiceImpl venderService;



    public DateTimeFormat data;

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
        //saidas.set(4, (Caixa) caixaService.buscarSaldo());
        mv.addObject("saidas", saidas);
        return mv;
    }

    private String toString(NumberExpression<Double> buscarSaldo) {
        return buscarSaldo.toString();
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

   /* @RequestMapping(value = "/cadastrarFechamentoC",method = RequestMethod.POST )
    public ModelAndView cadastrarFechamento(@RequestParam("data")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date data){
        ModelAndView mv= new ModelAndView("/FecharCaixa.html");

        List<Investimento> investimentos =  (List<Investimento>)  investimentoService.buscarNoIntervalo(data, data);
        System.out.println(investimentos);
        int somaIn= 0;
        for (int i=0; i<investimentos.size(); i++){
            somaIn= somaIn += investimentos.get(i).getValor();
        }
        System.out.println("valor da soma "+somaIn);
        return mv;
    }*/

    @GetMapping(value = "/cadastrarFechamentoC")
    public ModelAndView addFechamento(Caixa caixa){
        ModelAndView mv = new ModelAndView("/FecharCaixa.html");
        return mv;
    }

    @PostMapping(value = "/cadastrarFechamentoC")
    public String salvaCaixa(Caixa caixa, @RequestParam("data" ) Date  dataI){

        List<Vender> vendas =  venderService.findAll();
        double somavendas= 0;
        for (int i=0; i<vendas.size(); i++){
            if(dataI.equals(vendas.get(i).getData_Venda())){
                somavendas += vendas.get(i).getPreco_total();
                System.out.println("Soma das vendas  "+somavendas);

            }
        }

        List<Investimento> investimentos =  investimentoService.findAll();
        double somaIn= 0;
        System.out.println(dataI);
        for (int i=0; i<investimentos.size(); i++){
           if(dataI.equals(investimentos.get(i).getData())){
               somaIn += investimentos.get(i).getValor();
               System.out.println("soma In "+somaIn);
           }
        }

        List<Despesas> despesas =  despesasService.findAll();
        double somaDespesa= 0;
        System.out.println(dataI);
        for (int i=0; i<despesas.size(); i++){
            if(dataI.equals(despesas.get(i).getData())){
                somaDespesa += despesas.get(i).getValor();
                System.out.println("Soma de despesas  "+somaDespesa);
            }
        }

        caixaService.save(caixa);
        double saida = (somaDespesa + somaIn);
        double saldo = (somavendas - saida);
        System.out.println("Saida: "+saida);
        System.out.println("Saldo: "+saldo);
        caixa.setEntrada(somavendas);
        caixa.setSaida(saida);
        caixa.setSaldo(saldo);
        System.out.println("Soma "+somaIn);
        caixaService.save(caixa);
        return "redirect:/cadastrarFechamentoC";
    }







}
