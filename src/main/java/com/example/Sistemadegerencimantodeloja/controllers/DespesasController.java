package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.DespesasServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Caixa;
import com.example.Sistemadegerencimantodeloja.model.CaixaPDFExporter;
import com.example.Sistemadegerencimantodeloja.model.Despesas;
import com.example.Sistemadegerencimantodeloja.model.DespesasPDFExporter;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
}
