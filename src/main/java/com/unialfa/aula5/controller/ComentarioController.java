package com.unialfa.aula5.controller;

import com.unialfa.aula5.model.Comentario;
import com.unialfa.aula5.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ComentarioController {

    @Autowired
    private ComentarioService service;

    @RequestMapping("/")
    public String iniciar(Model model, Comentario comentario) {
        model.addAttribute("bemVindo",
                "Bem vindo ao nosso formulário");
        return "formulario";
    }

    @PostMapping("enviar")
    public String enviar(Comentario comentario){
        service.salvar(comentario);
        return "redirect:/lista";
    }

    @GetMapping("lista")
    public String listar(Model model){
        model.addAttribute("bemVindo",
                "Lista de Comentários!");

        model.addAttribute("comentarios",
                service.listarComentarios());

        return "lista";
    }

    @PostMapping("gostei")
    public String gostei(Comentario comentario){
        service.addGostei(comentario);
        return "redirect:/lista";
    }

    @PostMapping("naoGostei")
    public String naoGostei(Comentario comentario){
        service.addNaoGostei(comentario);
        return "redirect:/lista";
    }

    @PostMapping("remover")
    public String remover(Comentario comentario){
        service.remover(comentario);
        return "redirect:/lista";
    }

    @PostMapping("alterar")
    public String alterar(Model model, Comentario comentario){
        model.addAttribute("bemVindo",
                "Bem vindo ao nosso formulário");

        model.addAttribute("comentario",
                service.buscarPorTitulo(comentario));

        return "formulario";
    }
}
