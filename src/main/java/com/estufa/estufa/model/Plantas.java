package com.estufa.estufa.model;

import com.atom.Alias;
import com.atom.Id;
import com.atom.Ignore;
import com.atom.ListObjectLocal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Alias(value = "plantas")
public class Plantas implements Serializable {

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

    private String nome;

    private String caracteristica;

    private String nomecientifico;

    private String familia;

    private String luminosidade;

    private String ciclovida;

    private String categoria;

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

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaracteristica() {
        return caracteristica;
    }


    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getNomecientifico() {
        return nomecientifico;
    }


    public void setNomecientifico(String nomecientifico) {
        this.nomecientifico = nomecientifico;
    }

    public String getFamilia() {
        return familia;
    }


    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getLuminosidade() {
        return luminosidade;
    }


    public void setLuminosidade(String luminosidade) {
        this.luminosidade = luminosidade;
    }

    public String getCiclovida() {
        return ciclovida;
    }


    public void setCiclovida(String ciclovida) {
        this.ciclovida = ciclovida;
    }

    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
