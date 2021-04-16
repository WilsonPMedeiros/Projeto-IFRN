package com.example.Sistemadegerencimantodeloja.controllers;


import com.example.Sistemadegerencimantodeloja.Service.ClienteService;
import com.example.Sistemadegerencimantodeloja.Service.FuncionarioService;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ProdutosServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.VendasServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.model.FuncionarioPDFExporter;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
public class RelatorioController {
    @Autowired
    private ProdutosServiceImpl service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private VendasServiceImpl vendasService;
    @GetMapping("/produtos/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=produtos_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Produtos> listProdutos = service.findAll();

        ProdutosPDFExporter exporter = new ProdutosPDFExporter(listProdutos);
        exporter.export(response);

    }


    @RequestMapping(value = "/opcoesrelatorios", method = RequestMethod.GET)
    public ModelAndView getRelatorios(){
        ModelAndView mv = new ModelAndView("/opcoesrelatorios.html");
        return mv;
    }

    @GetMapping("/clientes/export/pdf")
    public void exportToPDFClientes(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=clientes_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Cliente> listclientes = clienteService.findAll();

        ClientesPDFExporter exporter = new ClientesPDFExporter(listclientes);
        exporter.export(response);

    }

    @GetMapping("/funcionarios/export/pdf")
    public void exportToPDFFuncionarios(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=funcionarios_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Funcionario> listfuncionarios = funcionarioService.findAll();

        FuncionarioPDFExporter exporter = new FuncionarioPDFExporter(listfuncionarios);
        exporter.export(response);

    }
    /*@GetMapping("/vendas/export/pdf")
    public void exportToPDFVendas(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=funcionarios_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Vendas> listVendas = vendasService.buscarNoIntervalo();
        VendaPDFExporter exporter = new VendaPDFExporter(listVendas);
        exporter.export(response);

    }*/

    @RequestMapping(value = "/relatorioVendas", method = RequestMethod.GET)
    public ModelAndView getRelatorioVendas(){
        ModelAndView mv = new ModelAndView("/relatorioVendas.html");
        return mv;
    }

    @RequestMapping(value = "/relatorioFinanceiro", method = RequestMethod.GET)
    public ModelAndView getRelatorioFinanceiro(){
        ModelAndView mv = new ModelAndView("/relatorioFinanceiro.html");
        return mv;
    }
    @RequestMapping(value = "/relatorioCaixa", method = RequestMethod.GET)
    public ModelAndView getRelatorioCaixa(){
        ModelAndView mv = new ModelAndView("/RelatorioCaixa.html");
        return mv;
    }
    @RequestMapping(value = "/relatorioDespesas", method = RequestMethod.GET)
    public ModelAndView getRelatorioDespesas(){
        ModelAndView mv = new ModelAndView("/RelatorioDespesa.html");
        return mv;
    }
    @RequestMapping(value = "/relatorioInvestimento", method = RequestMethod.GET)
    public ModelAndView getRelatorioInvestimento(){
        ModelAndView mv = new ModelAndView("/RelatorioInvestimento.html");
        return mv;
    }
    /*@RequestMapping(value = "/relatorioVendas", method = RequestMethod.GET)
    public ModelAndView getRelatorioVenda(){
        ModelAndView mv = new ModelAndView("/RelatorioVenda.html");
        return mv;
    }*/

}
