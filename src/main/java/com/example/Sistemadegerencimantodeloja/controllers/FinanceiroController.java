package com.example.Sistemadegerencimantodeloja.controllers;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class FinanceiroController {
    @RequestMapping(value = "/opcoeController", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/opcoesFechamento.html");
        return mv;
    }
}
