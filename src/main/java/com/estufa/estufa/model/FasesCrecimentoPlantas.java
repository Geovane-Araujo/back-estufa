package com.estufa.estufa.model;

import com.atom.Alias;
import com.atom.Id;
import com.atom.Ignore;

import java.io.Serializable;

@Alias(value = "plantas_fases_crecimento")
public class FasesCrecimentoPlantas implements Serializable {

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

    private int idplanta;

    @Ignore
    private String descricao = "";

    private int idfase;

    private double temperatura;

    private double humidade;

    private double nivelagua;

    private double ph;

    private double luminosidade;

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

    public int getIdplanta() {
        return idplanta;
    }


    public void setIdplanta(int idplanta) {
        this.idplanta = idplanta;
    }

    public int getIdfase() {
        return idfase;
    }


    public void setIdfase(int idfase) {
        this.idfase = idfase;
    }

    public double getTemperatura() {
        return temperatura;
    }


    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getHumidade() {
        return humidade;
    }


    public void setHumidade(double humidade) {
        this.humidade = humidade;
    }

    public double getNivelagua() {
        return nivelagua;
    }


    public void setNivelagua(double nivelagua) {
        this.nivelagua = nivelagua;
    }

    public double getPh() {
        return ph;
    }


    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getLuminosidade() {
        return luminosidade;
    }


    public void setLuminosidade(double luminosidade) {
        this.luminosidade = luminosidade;
    }


}
