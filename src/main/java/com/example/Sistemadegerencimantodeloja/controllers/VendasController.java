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

    @GetMapping(value = "/cadastrarVendas")
    public ModelAndView cadastrarVendas(Cliente cliente, Funcionario funcionario){
        ModelAndView mv = new ModelAndView("/vendas.html");
        List<Cliente> clientes=  clienteService.findAll();
        List<Funcionario> funcionarios= funcionarioService.findAll();
        List<Produtos> produtos= produtosService.findAll();
        mv.addObject("clientes", clientes);
        mv.addObject("funcionarios", funcionarios);
        mv.addObject("produtos", produtos);
        return mv;
    }
    @PostMapping(value = "/cadastrarVendas/{id}")
    public ModelAndView adicionarCompra(@PathVariable("id") long id,
                                        @ModelAttribute("produtos") Produtos produto){
        Produtos p = produtosService.findById(id);
        ModelAndView mv = new ModelAndView("/vendas.html");
        List<Cliente> clientes=  clienteService.findAll();
        List<Funcionario> funcionarios= funcionarioService.findAll();
        Produtos prod= produtosService.findById(id);
        Vendas venda=vendasService.add(p);
        ///List<Vendas> v= vendasService.findAll();
        mv.addObject("clientes", clientes);
        mv.addObject("funcionarios", funcionarios);

        mv.addObject("vendas", venda);
        mv.addObject("produto", prod);

       return mv;
    }

    @RequestMapping(value = "/cadastrarVendas{idProduto}{quantidade}", method = RequestMethod.POST)
    public ModelAndView menorValor(@RequestParam("nomeInputProduto") long id,
                                   @RequestParam("quant") int quant) {
        ModelAndView mv = new ModelAndView("/vendas.html");
        System.out.println("Esse é a porra do ID:"+ id);

        Produtos produto= produtosService.findById(id);

        double valor=vendasService.somarValor(produto.getValorVenda(), quant);
        VendaAux vendas= new VendaAux();
        System.out.println("valor inicial da variavel valor: "+ valor+ "Valor inicial da variavel quant: "+ quant);
        System.out.println("aqui não tá dando erro:"+ valor);
        vendas.setProduto(produto);
        System.out.println("resultado das vendas "+ vendas);
        vendas.setQuantidade(quant);
        vendas.setValor(valor);

        System.out.println("Valor final contido na variavel valor: "+valor +"Valor fina da variavel quant:"+quant);


        v.add(vendas);
        System.out.println("Resultado da vendas "+ v);
        mv.addObject("vendas", v);

        return mv;
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

    // Testando
    @GetMapping("/opcoesVendas")
    public String getVendas(HttpSession session, Model model){
    if(session.getAttribute("produtos") == null){
        model.addAttribute("allvendas", new ArrayList<Produtos>());
    }else{

        List<Produtos> produtos = (List<Produtos>) session.getAttribute("produtos");
    }
        return "/opcaovendas.html";
    }*/

}
