package com.unialfa.aula5.service;

import com.unialfa.aula5.model.Time;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService {

    private List<Time> times = new ArrayList<>();

    public void salvar(Time time) {
        var index = times.indexOf(time);
        if (index < 0) {
            adicionar(time);

            time.setId(times.indexOf(time)+1);

        }
        else {
            alterar(index, time);
        }
    }

    private void alterar(int index, Time time) {
        times.get(index).setId(time.getId());
        times.get(index).setTime(time.getTime());
        times.get(index).setEstado(time.getEstado());
        times.get(index).setAnoFundacao(time.getAnoFundacao());
        times.get(index).setTitulos(time.getTitulos());
    }

    private void adicionar(Time time) {

        times.add(time);
    }

    public List<Time> listarComentarios() {
        return times;
    }

    public Time buscarPorTitulo(Time time) {
        var index = times.indexOf(time);
        if (index < 0) return null;
        return times.get(index);
    }

    public void addGostei(Time time) {
        time = buscarPorTitulo(time);
        if (time == null) return;
        time.addGostei();
    }

    public void addNaoGostei(Time time) {
        time = buscarPorTitulo(time);
        if (time == null) return;
        time.addNaoGostei();
    }

    public void remover(Time time) {

        times.remove(time);
    }


}
