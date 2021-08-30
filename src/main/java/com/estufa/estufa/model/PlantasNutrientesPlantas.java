package com.estufa.estufa.model;

import com.atom.Alias;
import com.atom.Id;
import com.atom.Ignore;

import java.io.Serializable;

@Alias(value = "planta_nutrientes")
public class PlantasNutrientesPlantas implements Serializable {

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

    private int idnutriente;

    @Ignore
    private String descricao = "";

    private int idplanta;

    private double quantidade;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public int getIdnutriente() {
        return idnutriente;
    }


    public void setIdnutriente(int idnutriente) {
        this.idnutriente = idnutriente;
    }

    public int getIdplanta() {
        return idplanta;
    }


    public void setIdplanta(int idplanta) {
        this.idplanta = idplanta;
    }

    public double getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }


}
