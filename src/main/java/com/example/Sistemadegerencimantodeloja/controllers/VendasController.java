package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.ProdutosService;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ClienteServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.FuncionarioServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ProdutosServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.VendasServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.*;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Controller
public class VendasController {

    @Autowired
     VendasServiceImpl vendasService;

    @Autowired
    ClienteServiceImpl clienteService;

    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @Autowired
    ProdutosServiceImpl produtosService;

    List<VendaAux> vendas;
    @RequestMapping(value = "/opcoesVendas", method = RequestMethod.GET)
    public ModelAndView vendas(){
        ModelAndView mv = new ModelAndView("/opcaoVendas.html");
        List<Vendas> vendas=vendasService.findAll();
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
        Produtos produto= produtosService.findById(id);
        System.out.println(produto);

        double valor=vendasService.somarValor(produto.getValorVenda(), quant);
        VendaAux v = new VendaAux();
        v.setValor(valor);
        v.setQuantidade(quant);
        v.setProduto(id);


        System.out.println("Resultado da vendas "+ vendas);
        mv.addObject("venda", v);

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

}
