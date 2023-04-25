package com.unialfa.aula5.controller;

import com.unialfa.aula5.model.Time;
import com.unialfa.aula5.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimeController {

    @Autowired
    private TimeService service;

    @RequestMapping("/")
    public String iniciar(Model model, Time time) {
        model.addAttribute("bemVindo",
                "Bem vindo ao nosso formulário");
        return "formulario";
    }

    @PostMapping("enviar")
    public String enviar(Time time){
        service.salvar(time);
        return "redirect:/lista";
    }

    @GetMapping("lista")
    public String listar(Model model){
        model.addAttribute("bemVindo",
                "Lista de Times!");

        model.addAttribute("times",
                service.listarComentarios());

        return "lista";
    }

    @PostMapping("gostei")
    public String gostei(Time time){
        service.addGostei(time);
        return "redirect:/lista";
    }

    @PostMapping("naoGostei")
    public String naoGostei(Time time){
        service.addNaoGostei(time);
        return "redirect:/lista";
    }

    @PostMapping("remover")
    public String remover(Time time){
        service.remover(time);
        return "redirect:/lista";
    }

    @PostMapping("alterar")
    public String alterar(Model model, Time time){
        model.addAttribute("bemVindo",
                "Bem vindo ao nosso formulário");

        model.addAttribute("comentario",
                service.buscarPorTitulo(time));

        return "formulario";
    }
}
