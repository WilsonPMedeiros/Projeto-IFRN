package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ClienteServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.FuncionarioServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ProdutosServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.VendasServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.*;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class VendasController {
    List<VendaAux> v = null;
    List<Produtos> pList = null;
    @Autowired
     VendasServiceImpl vendasService;

    @Autowired
    ClienteServiceImpl clienteService;

    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @Autowired
    ProdutosServiceImpl produtosService;

    List<VendaAux> vendas;
    /*@RequestMapping(value = "/opcoesVendas", method = RequestMethod.GET)
    public ModelAndView vendas(){
        ModelAndView mv = new ModelAndView("/opcaoVendas.html");
        List<Vendas> v = vendasService.findAll();
        mv.addObject("vendas", vendas);
        return mv;
    }

    @GetMapping(value = "/cadastrarVendas{id}")
    public ModelAndView cadastrarVendas(Cliente cliente, Funcionario funcionario,@PathVariable("id") long id,
                                        @ModelAttribute("vendas") Vendas vendas){
        List<Cliente> clientes=  clienteService.findAll();
        List<Funcionario> funcionarios= funcionarioService.findAll();
        List<Produtos>produtos = produtosService.findAll();
        ModelAndView mv = new ModelAndView("/vendas.html");
        if(!(id==0)){ Vendas vendaAtual=vendasService.findById(id); }
        mv.addObject("clientes", clientes);
        mv.addObject("funcionarios", funcionarios);
        mv.addObject("produtos", produtos);
        mv.addObject("vendas", vendas);
        return mv;
    }


    @PostMapping(value = "/cadastrarVendas{id}")
    public String adicionarCompra(@RequestParam("nomeInputProduto")long id,
                                  @RequestParam("nomeInputFuncionario")long idFunc,
                                  @RequestParam("nomeInputCliente")long idCli){
        Produtos p =  produtosService.findById(id);
        System.out.println("Esse é o produto"+ p);
        ModelAndView mv = new ModelAndView("/vendas.html");
        Vendas venda = new Vendas();
        System.out.println("essa é a venda"+ venda);
        venda.setProdutos((List<Produtos>) produtosService.findById(id));
        System.out.println("essa é a venda"+ venda);
        venda.setPreco_venda(23);
        venda.setFuncionario(funcionarioService.findById(idFunc));
        System.out.println("Essa é a porra da venda:" + venda);
        venda.setData_Venda(new Date());
        venda.setDesconto(211);
        venda.setPreco_total(213);
        System.out.println("Essa é a porra da venda:" + venda);
        venda.setCliente(clienteService.findById(idCli));
        System.out.println("Essa é a porra da venda:" + venda);

        vendasService.save(venda);
        Vendas vId = vendasService.findById(venda.getId());
       return "redirect:/cadastrarVendas"+ vId;
    }

    @RequestMapping(value = "/relatorioVendas", method = RequestMethod.POST)
    public ModelAndView menorValor(@RequestParam("dataInicial" )@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date  dataI,
    @RequestParam("dataFinal")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataF,
                                   HttpServletResponse response) throws DocumentException, IOException {
        ModelAndView mv = new ModelAndView("/relatorioVendas");
        List<Vendas> vendas= (List<Vendas>) vendasService.buscarNoIntervalo(dataI, dataF);
        System.out.println("Resultado da query " +vendas);
        mv.addObject("produtos", vendas);

        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=vendas_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        VendaPDFExporter exporter = new VendaPDFExporter(vendas);
        exporter.export(response);
        return mv;
    }
    */

    /*@GetMapping("/opcoesVendas")
    public String getVendas(HttpSession session, Model model){
    if(session.getAttribute("produtos") == null){
        model.addAttribute("allvendas", new ArrayList<Produtos>());
    }else{

        List<Produtos> produtos = (List<Produtos>) session.getAttribute("produtos");
    }
        return "/opcaovendas.html";
    }*/


    /*  @RequestMapping(value = "/cadastrarVendas{idProduto}{quantidade}", method = RequestMethod.POST)
    public ModelAndView menorValor(@RequestParam("nomeInputProduto") long id,
                                   @RequestParam("quant") int quant) {
        ModelAndView mv = new ModelAndView("/vendas.html");
        System.out.println("Esse é a porra do ID:"+ id);

        Produtos produto= produtosService.findById(id);
        Vendas venda= new Vendas();
        venda.setData_Venda(new Date());
        venda.setPreco_venda(produto.getValorVenda()*quant);
        vendasService.save(venda);

        List<Vendas> vendas= vendasService.findAll();
        //double valor=vendasService.somarValor(produto.getValorVenda(), quant);
       // VendaAux vendas= new VendaAux();

        System.out.println("Resultado da vendas "+ v);
        mv.addObject("vendas", vendas);

        return mv;
    }*/


}
