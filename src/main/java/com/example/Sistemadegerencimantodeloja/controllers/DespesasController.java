package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.DespesasServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.*;
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
public class DespesasController {

    @Autowired
    DespesasServiceImpl despesasService;

    @RequestMapping(value = "/relatorioDespesas", method = RequestMethod.POST)

    public ModelAndView gerarPdfCaixa(@RequestParam("dataInicial" )@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataI,
                                      @RequestParam("dataFinal")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataF,
                                      HttpServletResponse response) throws DocumentException, IOException {
        ModelAndView mv = new ModelAndView("/relatorioDespesas");
        List<Despesas> despesas= (List<Despesas>) despesasService.buscarNoIntervalo(dataI, dataF);
        System.out.println("Resultado da query " +despesas);
        mv.addObject("despesa", despesas);

        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=despesas_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        DespesasPDFExporter exporter = new DespesasPDFExporter(despesas);
        exporter.export(response);
        return mv;
    }
    @RequestMapping(value = "/opcoesDespesas", method = RequestMethod.GET)
    public ModelAndView getDespesas(){
        ModelAndView mv = new ModelAndView("/opcaoDespesa.html");
        List<Despesas> depespesas=despesasService.findAll();
        mv.addObject("despesas", depespesas);
        return mv;
    }

    @GetMapping(value = "/opcoes/excluirDespesa/{id}")
    public String deletarDespesa(@PathVariable("id") long id){
        despesasService.deleteById(id);
        return "redirect:/opcoesDespesas";
    }

    @GetMapping(value = "/cadastrarDespesa")
    public ModelAndView cadastrarDespesa(Funcao funcao){
        ModelAndView mv= new ModelAndView("/cadastrardespesas.html");
        return mv;
    }

    @PostMapping(value = "/cadastrarDespesa")
    public String salvaFuncao(Despesas despesas){
        despesasService.save(despesas);
        return "redirect:/opcoesDespesas";
    }
    @GetMapping("/editarDespesa{id}")
    public ModelAndView editarDespesa(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("/EditarDespesa.html");
        Despesas despesas = despesasService.findById(id);
        System.out.println(despesas);
        mv.addObject("despesa", despesas);
        return  mv;
    }

    @PostMapping("/editarDespesa{id}")
    public String editarDespesas(@PathVariable("id") long id,
                                 @ModelAttribute("descricao") String nome,
                                 @ModelAttribute("valor") double valor){
        Despesas despesas = despesasService.findById(id);
        despesas.setDescricao(nome);
        despesas.setValor(valor);
        despesasService.save(despesas);
        return "redirect:/opcoesDespesas";
    }
}
