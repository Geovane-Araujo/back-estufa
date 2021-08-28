package com.estufa.estufa.model;


import com.atom.Alias;
import com.atom.Id;
import com.atom.Ignore;

import java.io.Serializable;

@Alias(value = "pessoa")
public class Pessoa implements Serializable {


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

    @Ignore
    private PessoaDados pessoaDados = new PessoaDados();

    public PessoaDados getPessoaDados() {
        return pessoaDados;
    }

    public void setPessoaDados(PessoaDados pessoaDados) {
        this.pessoaDados = pessoaDados;
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

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


}