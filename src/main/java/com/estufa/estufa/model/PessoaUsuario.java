package com.estufa.estufa.model;


import com.atom.Alias;
import com.atom.Id;
import com.atom.Ignore;

import java.io.Serializable;

@Alias(value = "pessoa_usuario")
public class PessoaUsuario implements Serializable {


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

    private String login;

    private String senha;

    private Pessoa pessoa;

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

    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }


}