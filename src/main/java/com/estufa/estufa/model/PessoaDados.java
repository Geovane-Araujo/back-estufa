package com.estufa.estufa.model;


import com.atom.Alias;
import com.atom.Id;
import com.atom.Ignore;

import java.io.Serializable;

@Alias(value = "pessoa_dadoscontato")
public class PessoaDados implements Serializable {


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

    private String cep;

    private String endereco;

    private String bairro;

    private String numero;

    private String complemento;

    private String cidade;

    private String uf;

    private String residencial;

    private String celular;

    private String comercial;

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

    public String getCep() {
        return cep;
    }


    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }


    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }


    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }


    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getResidencial() {
        return residencial;
    }


    public void setResidencial(String residencial) {
        this.residencial = residencial;
    }

    public String getCelular() {
        return celular;
    }


    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getComercial() {
        return comercial;
    }


    public void setComercial(String comercial) {
        this.comercial = comercial;
    }


}