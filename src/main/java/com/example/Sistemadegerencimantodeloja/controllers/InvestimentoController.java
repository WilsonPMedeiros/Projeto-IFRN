package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.InvestimentoServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.Funcao;
import com.example.Sistemadegerencimantodeloja.model.Investimento;
import com.example.Sistemadegerencimantodeloja.model.InvestimentoPDFExporter;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class InvestimentoController {

    @Autowired
    InvestimentoServiceImpl investimentoService;


    @RequestMapping(value = "/relatorioInvestimento", method = RequestMethod.POST)

    public ModelAndView gerarPdfCaixa(@RequestParam("dataInicial" ) Date dataI,
                                      @RequestParam("dataFinal") Date dataF,
                                      HttpServletResponse response) throws DocumentException, IOException {
        ModelAndView mv = new ModelAndView("/relatorioInvestimento");
        List<Investimento> investimentos= (List<Investimento>) investimentoService.buscarNoIntervalo(dataI, dataF);
        System.out.println("Resultado da query " +investimentos);
        mv.addObject("caixa", investimentos);

        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Investimentos_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        InvestimentoPDFExporter exporter = new InvestimentoPDFExporter(investimentos);
        exporter.export(response);
        return mv;
    }

    @RequestMapping(value = "/opcoesInvestimento", method = RequestMethod.GET)
    public ModelAndView getInvestimento(){
        ModelAndView mv = new ModelAndView("/opcaoInvestimento.html");
        List<Investimento> investimentos=investimentoService.findAll();
        mv.addObject("investimentos", investimentos);
        return mv;
    }

    @GetMapping(value = "/opcoes/excluirInvestimento/{id}")
    public String deletarInvestimento(@PathVariable("id") long id){
        investimentoService.deleteById(id);
        return "redirect:/opcoesInvestimento";
    }

    @GetMapping(value = "/cadastrarInvestimento")
    public ModelAndView cadastrarInvestimento(Funcao funcao){
        ModelAndView mv= new ModelAndView("/cadastrarInvestimento.html");
        return mv;
    }

    @PostMapping(value = "/cadastrarInvestimento")
    public String salvaInvestimento(Investimento investimento){
        investimentoService.save(investimento);
        return "redirect:/opcoesInvestimento";
    }
    @GetMapping("/editarInvestimento{id}")
    public ModelAndView editarInvestimento(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("/EditarInvestimento.html");
        Investimento investimento = investimentoService.findById(id);
        mv.addObject("despesa", investimento);
        return  mv;
    }

    @PostMapping("/editarInvestimento{id}")
    public String editarInvest(@PathVariable("id") long id,
                                 @ModelAttribute("descricao") String nome,
                                 @ModelAttribute("valor") double valor){
        Investimento investimento = investimentoService.findById(id);
        investimento.setDescricao(nome);
        investimento.setValor(valor);
        investimentoService.save(investimento);
        return "redirect:/opcoesInvestimento";
    }




}
