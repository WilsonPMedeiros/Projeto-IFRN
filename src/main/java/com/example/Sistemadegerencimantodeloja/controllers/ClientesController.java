package com.example.Sistemadegerencimantodeloja.controllers;
import com.example.Sistemadegerencimantodeloja.Service.ClienteService;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ClienteServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.EnderecoServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Endereco;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class ClientesController {
    @Autowired
    ClienteServiceImpl clienteService;

    @Autowired
    EnderecoServiceImpl enderecoService;



    //busca todos os clientes
    @RequestMapping(value = "/opcoes", method = RequestMethod.GET)
    public ModelAndView getClientes(){
        ModelAndView mv = new ModelAndView("/opcoesCliente.html");
        List<Cliente>clientes=clienteService.findAll();
        mv.addObject("clientes", clientes);
        //System.out.println(clientes);
        return mv;
    }

    @GetMapping(value = "/cadastrar")
    public ModelAndView cadastrarCleintes(Cliente cliente){
        ModelAndView mv= new ModelAndView("/cadastrodeCliente");
        mv.addObject("cliente",cliente);
        return mv;
    }
    @PostMapping("/cadastrar")
    public String salvaCliente(Cliente cliente, Endereco endereco){
        enderecoService.save(endereco);
        cliente.setEnd(endereco);
        clienteService.save(cliente);
        return "redirect:/opcoes";
    }
    @GetMapping("/opcoes/excluir/{id}")
    public String removerCliente(@PathVariable("id") long id){
       clienteService.deleteById(id);
        return  "redirect:/opcoes";
    }

    /*public ModelAndView editar(Cliente cliente, Endereco endereco){
        ModelAndView mv = new ModelAndView("/EditarCliente");
        mv.addObject("cliente",cliente);
        mv.addObject("endereco",endereco);*/





    @RequestMapping(value = "/opcaoestoque{valorVenda}", method = RequestMethod.GET)
    public ModelAndView editar(@RequestParam("id_cliente")  long id){
        ModelAndView mv = new ModelAndView("/EditarCliente.html");
        Cliente cliente =  clienteService.findById(id);
        Endereco endereco = enderecoService.findById(cliente.getEnd().getId());
        mv.addObject("cliente", cliente);
        mv.addObject("endereco", endereco);
        return mv;
    }


    @PostMapping("/editarCliente/{id}/{end_id}")
    public String atualizarCliente(@PathVariable("id") long id,
                                   @PathVariable("end_id") long end_id,
                                   @ModelAttribute("cliente") Cliente cliente,
                                   @ModelAttribute("endereco") Endereco endereco){
        Cliente clienteEditado = clienteService.findById(id);
        if (!clienteEditado.equals(cliente)) {
            clienteEditado.setNome(cliente.getNome());
            clienteEditado.setTelefone(cliente.getTelefone());
            clienteEditado.setEmail(clienteEditado.getEmail());
            clienteEditado.setCpf(cliente.getCpf());
            clienteEditado.setEnd(endereco);
            clienteService.save(clienteEditado); // Cadastra e atualiza
        }
        return "redirect:/opcoes";
    }



}
