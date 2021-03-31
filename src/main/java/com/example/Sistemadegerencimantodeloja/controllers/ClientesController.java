package com.example.Sistemadegerencimantodeloja.controllers;
import com.example.Sistemadegerencimantodeloja.Service.ClienteService;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.ClienteServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.EnderecoServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Endereco;
import com.example.Sistemadegerencimantodeloja.model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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


    //chama a view do cadastro
    @GetMapping(value = "/cadastrar")
    public ModelAndView cadastrarCleintes(Cliente cliente){
        ModelAndView mv= new ModelAndView("/cadastrodeCliente");
        mv.addObject("cliente",cliente);
        return mv;
    }

    //cadastra o cliente
    @PostMapping("/cadastrar")
    public String salvaCliente(Cliente cliente, Endereco endereco){
        enderecoService.save(endereco);
        cliente.setEnd(endereco);
        clienteService.save(cliente);
        return "redirect:/opcoes";
    }

    //Excluir o registro do cliente
    @GetMapping("/opcoes/excluir/{id}")
    public String removerCliente(@PathVariable("id") long id){
       clienteService.deleteById(id);
        return  "redirect:/opcoes";
    }

    @GetMapping("/{id}")
    public ModelAndView editarCliente(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("/EditarCliente.html");
        Cliente cliente = clienteService.findById(id);
        //Endereco end = enderecoService.findById(cliente.getEnd().getId());
        //System.out.println("Esse é o cliente "+cliente+"Esse é o ID"+ cliente.getEnd().getId());
        mv.addObject("cliente", cliente);
        return  mv;
    }

    /*public ModelAndView editar(Cliente cliente, Endereco endereco){
        ModelAndView mv = new ModelAndView("/EditarCliente");
        mv.addObject("cliente",cliente);
        mv.addObject("endereco",endereco);*/

    /*
    @GetMapping(value = "/editarCl{id}")
    public ModelAndView editar(@RequestParam("id_cliente")  long id){
        ModelAndView mv = new ModelAndView("/EditarCliente.html");
        Cliente cliente =  clienteService.findById(id);
        Endereco endereco = enderecoService.findById(cliente.getEnd().getId());
        mv.addObject("cliente", cliente);
        mv.addObject("endereco", endereco);
        return mv;
    }*/


    //Save Isolado do Endereco
    @PostMapping("/editarEndereco/{id}")
    public String atualizarCliente(@PathVariable("id") long id,
                                   @ModelAttribute("endereco") Endereco endereco) {
        Endereco enderecoEditado = enderecoService.findById(id);
        if (!enderecoEditado.equals(endereco)) {
            enderecoEditado.setBairro(enderecoEditado.getBairro());
            enderecoEditado.setCidade(endereco.getCidade());
            enderecoEditado.setLogradouro(endereco.getLogradouro());
            enderecoEditado.setUf(endereco.getUf());
            enderecoService.save(enderecoEditado); // Cadastra e atualiza
        }

        return "redirect:/opcoes";
    }

    //Save do Cliente
    @PostMapping("/editarCliente/{id}")
    public String atualizarCliente(@PathVariable("id") long id,
                                   @ModelAttribute("cliente") Cliente cliente,
                                   @ModelAttribute("endereco") Endereco endereco){
        Cliente clienteEditado = clienteService.findById(id);
        Endereco enderecoEditado= enderecoService.findById(clienteEditado.getEnd().getId());
        System.out.println("Esse é o endereco editado: "+ enderecoEditado);
        System.out.println("Esse é o cliente Editado: "+ clienteEditado);
        if (!clienteEditado.equals(cliente)) {
            clienteEditado.setNome(cliente.getNome());
            clienteEditado.setTelefone(cliente.getTelefone());
            clienteEditado.setEmail(cliente.getEmail());
            clienteEditado.setSexo(cliente.getSexo());
            clienteEditado.setCpf(cliente.getCpf());

            enderecoEditado.setCep(endereco.getCep());
            enderecoEditado.setNum(endereco.getNum());
            enderecoEditado.setLogradouro(endereco.getLogradouro());
            enderecoEditado.setUf(endereco.getUf());
            enderecoEditado.setCidade(endereco.getCidade());
            enderecoEditado.setBairro(endereco.getBairro());
            enderecoService.save(enderecoEditado);
            System.out.println("Dados do endereco editado: " + enderecoEditado);
            clienteEditado.setEnd(enderecoEditado);
            clienteService.save(clienteEditado); // Cadastra e atualiza
        }
        return "redirect:/opcoes";
    }



}
