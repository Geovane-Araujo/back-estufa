package com.estufa.estufa.model;


import com.atom.Alias;
import com.atom.Id;
import com.atom.Ignore;
import com.atom.ObjectLocal;

import java.io.Serializable;

@Alias(value = "pessoa_estufa")
public class PessoaEstufa implements Serializable {


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

    private int idpessoa;

    private String proprietario;

    private String responsavel;

    @ObjectLocal
    private Pessoa pessoa = new Pessoa();

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    public int getIdpessoa() {
        return idpessoa;
    }


    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getProprietario() {
        return proprietario;
    }


    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getResponsavel() {
        return responsavel;
    }


    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }


}