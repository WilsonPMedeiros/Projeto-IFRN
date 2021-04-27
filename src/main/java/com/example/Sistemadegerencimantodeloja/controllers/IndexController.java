package com.example.Sistemadegerencimantodeloja.controllers;

import com.example.Sistemadegerencimantodeloja.model.Funcionario;
import com.example.Sistemadegerencimantodeloja.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
public class IndexController {
    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/teladelogin.html");
        return mv;
    }*/

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @GetMapping("/")
    public String exibirIndex(Funcionario funcionario){

        return "/teladelogin.html";
    }

    @RequestMapping(value = "/telaprincipal", method = RequestMethod.GET)
    public ModelAndView telaPrincipal() {
        ModelAndView mv = new ModelAndView("/index.html");
        return mv;
    }

    @RequestMapping(value = "/telavendedor", method = RequestMethod.GET)
    public ModelAndView telaVendedor() {
        ModelAndView mv = new ModelAndView("/telaVendedor.html");
        return mv;
    }

    @RequestMapping(value = "/telaGestoque", method = RequestMethod.GET)
    public ModelAndView telaGestorE() {
        ModelAndView mv = new ModelAndView("/telaGestoque.html");
        return mv;
    }



    @PostMapping("/efetuarLogin")
    public  String efetuarLogin(Funcionario funcionario, HttpSession session, RedirectAttributes ra){
        funcionario = funcionarioRepository.findByLoginAndSenha(funcionario.getLogin(), funcionario.getSenha());
        if(funcionario != null){
            if(funcionario.getFuncao().getNome().equals("admin")){
                session.setAttribute("usuariologado", funcionario);
                return "redirect:/telaprincipal";
            }else if (funcionario.getFuncao().getNome().equals("Vendedor")){
            session.setAttribute("usuariologado", funcionario);
                return "redirect:/telavendedor";
             }else if (funcionario.getFuncao().getNome().equals("Gerenciador de Estoque")){
                session.setAttribute("usuariologado", funcionario);
                return "redirect:/telaGestoque";
            }else{
                return "redirect:/telaGestoque";
            }


        }else {
            ra.addFlashAttribute("mensagem", "login/senha invalidos");
            return "redirect:/";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";

    }


}
