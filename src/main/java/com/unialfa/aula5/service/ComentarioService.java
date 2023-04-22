package com.unialfa.aula5.service;

import com.unialfa.aula5.model.Comentario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComentarioService {

    private List<Comentario> comentarios = new ArrayList<>();

    public void salvar(Comentario comentario) {
        var index = comentarios.indexOf(comentario);
        if (index < 0) {
            adicionar(comentario);

            comentario.setId(comentarios.indexOf(comentario));

        }
        else {
            alterar(index, comentario);
        }
    }

    private void alterar(int index, Comentario comentario) {
        comentarios.get(index).setId(comentario.getId());
        comentarios.get(index).setTime(comentario.getTime());
        comentarios.get(index).setEstado(comentario.getEstado());
        comentarios.get(index).setAnoFundacao(comentario.getAnoFundacao());
        comentarios.get(index).setTitulos(comentario.getTitulos());
    }

    private void adicionar(Comentario comentario) {

        comentarios.add(comentario);
    }

    public List<Comentario> listarComentarios() {
        return comentarios;
    }

    public Comentario buscarPorTitulo(Comentario comentario) {
        var index = comentarios.indexOf(comentario);
        if (index < 0) return null;
        return comentarios.get(index);
    }

    public void addGostei(Comentario comentario) {
        comentario = buscarPorTitulo(comentario);
        if (comentario == null) return;
        comentario.addGostei();
    }

    public void addNaoGostei(Comentario comentario) {
        comentario = buscarPorTitulo(comentario);
        if (comentario == null) return;
        comentario.addNaoGostei();
    }

    public void remover(Comentario comentario) {

        comentarios.remove(comentario);
    }


}
