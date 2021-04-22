package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.Service.FuncaoService;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.EnderecoServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.FuncaoServiceImpl;
import com.example.Sistemadegerencimantodeloja.Service.Serviceimpl.FuncionarioServiceImpl;
import com.example.Sistemadegerencimantodeloja.model.Cliente;
import com.example.Sistemadegerencimantodeloja.model.Endereco;
import com.example.Sistemadegerencimantodeloja.model.Funcao;
import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FuncionarioController {
    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @Autowired
    EnderecoServiceImpl enderecoService;

    @Autowired
    FuncaoServiceImpl funcaoService;

    @RequestMapping(value = "/opcoesFuncionario", method = RequestMethod.GET)
    public ModelAndView getClientes(){
        ModelAndView mv = new ModelAndView("/opcoesFuncionarios.html");
        List<Funcionario>funcionarios=funcionarioService.findAll();
        mv.addObject("funcionarios", funcionarios);
        return mv;
    }

    @GetMapping(value = "/cadastrarFuncionario")
    public ModelAndView cadastrarCleintes(Funcionario funcionario, Endereco endereco){
        ModelAndView mv= new ModelAndView("/cadastroFuncionario.html");
        mv.addObject("funcionario",funcionario);
        List<Funcao>  funcao = funcaoService.findAll();
        mv.addObject("funcoes", funcao);
        return mv;
    }

    @GetMapping("/editar{id}")
    public ModelAndView editarfuncioario(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("/EditarFuncionario.html");
        Funcionario funcionario = funcionarioService.findById(id);
        System.out.println(funcionario);
        mv.addObject("funcionario", funcionario);
        return  mv;
    }

    @PostMapping("/cadastrarFuncionario")
    public String salvaFuncionario(Funcionario funcionario, Endereco endereco,
                                   @RequestParam("funcao") long idfuncao) {
        Funcao f = funcaoService.findById(idfuncao);
        enderecoService.save(endereco);
        funcionario.setEndereco(endereco);
        funcionario.setFuncao(f);
        funcionarioService.save(funcionario);
        return "redirect:/opcoesFuncionario";

    }

    @GetMapping(value = "/opcoes/excluirFuncionario/{id}")
    public String deletarFuncionario(@PathVariable("id") long id){
        funcionarioService.deleteById(id);
        return "redirect:/opcoesFuncionario";
    }


    //atualiza funcionário
    @PostMapping("/EditarFuncionario/{id}")
    public String atualizarCliente(@PathVariable("id") long id,
                                   @ModelAttribute("funcionario") Funcionario funcionario,
                                   @ModelAttribute("endereco") Endereco endereco){
        Funcionario funcionarioEditado = funcionarioService.findById(id);
        Endereco enderecoEditado= enderecoService.findById(funcionarioEditado.getEndereco().getId());
        System.out.println("Esse é o endereco editado: "+ enderecoEditado);
        System.out.println("Esse é o cliente Editado: "+ funcionarioEditado);
        if (!funcionarioEditado.equals(funcionario)) {
            funcionarioEditado.setNome(funcionario.getNome());
            funcionarioEditado.setTelefone(funcionario.getTelefone());
            funcionarioEditado.setLogin(funcionario.getLogin());
            funcionarioEditado.setSexo(funcionario.getSexo());
            funcionarioEditado.setCpf(funcionario.getCpf());
            enderecoEditado.setCep(endereco.getCep());
            enderecoEditado.setNum(endereco.getNum());
            enderecoEditado.setLogradouro(endereco.getLogradouro());
            enderecoEditado.setUf(endereco.getUf());
            enderecoEditado.setCidade(endereco.getCidade());
            enderecoEditado.setBairro(endereco.getBairro());
            enderecoService.save(enderecoEditado);
            System.out.println("Dados do endereco editado: " + enderecoEditado);
            funcionarioEditado.setEndereco(enderecoEditado);
            funcionarioService.save(funcionarioEditado); // Cadastra e atualiza
        }
        return "redirect:/opcoes";
    }


}
