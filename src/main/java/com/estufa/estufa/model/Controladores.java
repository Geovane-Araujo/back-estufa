package com.estufa.estufa.model;

import com.atom.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Alias(value = "controladores")
public class Controladores implements Serializable {


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

    private int idestufa;

    @Ignore
    private String estufa = "";

    private int idfase;

    @Ignore
    private String descricao = "";

    private String nome = "";

    private String host;

    private int ativo = 1;

    private int idsetor;

    @Ignore
    private String setor = "";

    @ListObjectLocal
    private List<ControladoresPlantas> plantas = new ArrayList<>();

    public String getEstufa() {
        return estufa;
    }

    public int getIdsetor() {
        return idsetor;
    }

    public void setIdsetor(int idsetor) {
        this.idsetor = idsetor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setEstufa(String estufa) {
        this.estufa = estufa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ControladoresPlantas> getPlantas() {
        return plantas;
    }

    public void setPlantas(List<ControladoresPlantas> plantas) {
        this.plantas = plantas;
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

    public int getIdestufa() {
        return idestufa;
    }


    public void setIdestufa(int idestufa) {
        this.idestufa = idestufa;
    }

    public int getIdfase() {
        return idfase;
    }


    public void setIdfase(int idfase) {
        this.idfase = idfase;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHost() {
        return host;
    }


    public void setHost(String host) {
        this.host = host;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Controladores{" +
                "add=" + add +
                ", edit=" + edit +
                ", del=" + del +
                ", id=" + id +
                ", idestufa=" + idestufa +
                ", estufa='" + estufa + '\'' +
                ", idfase=" + idfase +
                ", descricao='" + descricao + '\'' +
                ", nome='" + nome + '\'' +
                ", host='" + host + '\'' +
                ", ativo=" + ativo +
                ", idsetor=" + idsetor +
                ", setor='" + setor + '\'' +
                ", plantas=" + plantas +
                '}';
    }
}
