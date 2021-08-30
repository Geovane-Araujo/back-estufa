package com.estufa.estufa.model;


import com.atom.Alias;
import com.atom.Id;
import com.atom.Ignore;

import java.io.Serializable;

@Alias(value = "controladores_plantas")
public class ControladoresPlantas implements Serializable {


    @Ignore
    private static final long serialVersionUID = 1L;
    @Ignore
    private boolean add = true;
    @Ignore
    private boolean edit = false;
    @Ignore
    private boolean del = false;
    @Id
    private int id;

    private int idcontrolador;

    private int idplanta = 0;

    @Ignore
    private String nome;

    private int quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdplanta() {
        return idplanta;
    }

    public void setIdplanta(int idplanta) {
        this.idplanta = idplanta;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getIdcontrolador() {
        return idcontrolador;
    }


    public void setIdcontrolador(int idcontrolador) {
        this.idcontrolador = idcontrolador;
    }

    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


}