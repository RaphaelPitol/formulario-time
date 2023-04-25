package com.unialfa.aula5.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Time {

    private String time;
    @EqualsAndHashCode.Include
    private Integer id;
    private String anoFundacao;
    private LocalDateTime publicacao;
    private String estado;
    private int titulos;
    private Integer gostei;
    private Integer naoGostei;

    public void addCom(){
        if( id == null) id = 0 ;
        id=Integer.sum(id, 1);
    }
    public void addGostei(){
        if (gostei == null) gostei = 0;
        gostei = Integer.sum(gostei, 1);
    }

    public void addNaoGostei(){
        if (naoGostei == null) naoGostei = 0;
        naoGostei = Integer.sum(naoGostei, 1);
    }

}
