package com.example.Sistemadegerencimantodeloja.controllers;


import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ClienteServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.FuncionarioServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ProdutosServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.VendasServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.venderServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.itensServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.itensVendidosImpl;
import com.example.Sistemadegerencimantodeloja.model.*;
import com.example.Sistemadegerencimantodeloja.model.ItensVendidos;
import com.example.Sistemadegerencimantodeloja.repository.ItensVendidosRepository;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class VenderController {
    double soma=0;
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

    @Autowired
            venderServiceImpl venderService;

    @Autowired
            itensVendidosImpl itensVendidosService;

    @Autowired
            itensServiceImpl itensService;

    @Autowired
            ItensVendidosRepository itensVendidosRepository;



    List<VendaAux> vendas;
    @RequestMapping(value = "/opcoesVendas", method = RequestMethod.GET)
    public ModelAndView vendas(){
        ModelAndView mv = new ModelAndView("/opcaoVendas.html");
        List<Vender> v = venderService.findAll();
        mv.addObject("vendas",v);
        return mv;
    }

    @GetMapping(value = "/cadastrarVendas")
    public ModelAndView cadastrarVendas(Cliente cliente, Funcionario funcionario, Vender vender){
        ModelAndView mv = new ModelAndView("/cadastrarVendas.html");

        List<Cliente> clientes=  clienteService.findAll();
        List<Funcionario> funcionarios= funcionarioService.findAll();
        mv.addObject("clientes", clientes);
        mv.addObject("funcionarios", funcionarios);
        mv.addObject("vender", vender);
        return mv;
    }

    //Insere o produto na venda
    @PostMapping(value = "/cadastrarVendas")
    public String adicionarCompra(Cliente cliente, Funcionario funcionario, Vender vender,
                                  @RequestParam("nomeInputFuncionario") long idFuncionario,
                                  @RequestParam("nomeInputCliente") long idCliente){
        Cliente c = clienteService.findById(idCliente);
        Funcionario f= funcionarioService.findById(idFuncionario);
        venderService.save(vender);
        vender.setCliente(c);
        vender.setFuncionario(f);
        vender.setData_Venda(new Date());
        venderService.save(vender);
        System.out.println("id vendas:" + vender.getId());
        return "redirect:/cadastrarProdutosVendas" + vender.getId();
    }

    @GetMapping(value = "/cadastrarProdutosVendas{id}")
    public ModelAndView cadastrarVendas(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("/vendaAux.html");
        Vender vaux= venderService.findById(id);
        Cliente cliente=  clienteService.findById(vaux.getCliente().getId());
        Funcionario funcionario= funcionarioService.findById(vaux.getFuncionario().getId());
        List<itens>produtos = itensService.findAll();

        List<ItensVendidos> it = itensVendidosRepository.findByVendas(vaux);
        soma= 0;
        for (int i=0; i<it.size(); i++){
                soma= soma += it.get(i).getItens().getValorVenda();
            }
        System.out.println("valor venda: "+soma);

        mv.addObject("cliente", cliente);
        mv.addObject("funcionario", funcionario);
        mv.addObject("produtos", produtos);
        mv.addObject("vender", vaux);
        mv.addObject("itenVendido", it);
        mv.addObject("soma", soma);
        return mv;
    }

    @PostMapping(value = "/cadastrarProdutosVendas{id}")
    public String cadastrarItenvendido(@PathVariable("id") long id,
                                       @ModelAttribute("vender") Vender vender,
                                       ItensVendidos itensVendidos,
                                       @RequestParam("nomeInputProduto") long idProduto,
                                       Model model){
        Vender v2= venderService.findById(id);
        itens i = itensService.findById(idProduto);
        itensVendidosService.save(itensVendidos);
        itensVendidos.setVendas(v2);
        itensVendidos.setItens(i);
        itensVendidosService.save(itensVendidos);

        return "redirect:/cadastrarProdutosVendas" + v2.getId();
    }

    @RequestMapping(value = "/relatorioVendas", method = RequestMethod.POST)
    public ModelAndView menorValor(@RequestParam("dataInicial" )Date  dataI,
                                   @RequestParam("dataFinal") Date dataF,
                                   HttpServletResponse response) throws DocumentException, IOException {
        ModelAndView mv = new ModelAndView("/relatorioVendas");
        List<Vender> vendas= (List<Vender>) venderService.buscarNoIntervalo(dataI, dataF);
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

    @GetMapping(value = "/quitarVenda{id}")
    public ModelAndView quitarVendas(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("/telaPagamento.html");
        Vender vaux= venderService.findById(id);
        List<ItensVendidos> it = itensVendidosRepository.findByVendas(vaux);
        soma= 0;
        for (int i=0; i<it.size(); i++){
            soma= soma += it.get(i).getItens().getValorVenda();
        }
        mv.addObject("vender", vaux);
        mv.addObject("soma", soma);
        return mv;
    }

    @PostMapping(value = "/quitarVenda{id}")
    public String cadastrarPagamento(@PathVariable("id") long id,
                                       @ModelAttribute("vender") Vender vender,
                                       @RequestParam("preco") double preco,
                                     @RequestParam("desconto") double desconto,
                                     @RequestParam("pagar") double pagar,
                                       Model model){
        Vender v2= venderService.findById(id);
        v2.setDesconto(desconto);
        v2.setPreco_venda(preco);
        v2.setPreco_total(pagar);
        venderService.save(v2);

        return "redirect:/cadastrarVendas";
    }
    //Exclusão de vendas
    @GetMapping(value = "/opcoes/excluirVenda/{id}")
    public String deletarFuncionario(@PathVariable("id") long id){
        Vender vaux= venderService.findById(id);
        List<ItensVendidos> it = itensVendidosRepository.findByVendas(vaux);
         for (int i=0;i<it.size();i++){
             System.out.println(it.get(i));
            itensVendidosService.deleteById(it.get(i).getId());

         }
        venderService.deleteById(id);
        return "redirect:/opcoesVendas";
    }

}
