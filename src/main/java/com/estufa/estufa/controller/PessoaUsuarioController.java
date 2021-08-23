package com.estufa.estufa.controller;


import com.atom.Alias;
import com.atom.Atom;
import com.estufa.estufa.estufaConnection.EstufaConnections;
import com.estufa.estufa.model.Pessoa;
import com.estufa.estufa.model.PessoaUsuario;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Geovane
 * Gerado automaticaente por AdonaiSoft - Utilitário
 */
@Controller
public class PessoaUsuarioController {

    EstufaConnections connection = new EstufaConnections();
    String sql ="" ;
    String descricao = "Cadastro.PessoaUsuario";
    String log ="" ;
    Atom pc = new Atom();



    public PessoaUsuario save(PessoaUsuario pessoausuario) throws SQLException, IllegalAccessException {

        Connection con = null;
        PreparedStatement stmt = null;
        int scalar = 0;


        con = connection.getNewConnections("estufa_inf");

        con.setAutoCommit(false);

        if(pessoausuario.isAdd()){
            //Insere na tabela pessoa
            scalar = pc.insertedOne(pessoausuario.getPessoa(),con);
            //seta i id para a relação
            pessoausuario.getPessoa().getPessoaDados().setIdpessoa(scalar);
            pessoausuario.setIdpessoa(scalar);
            // grava os dados pessoais
            pc.insertedOne(pessoausuario.getPessoa().getPessoaDados(),con);
            // grava na tabela usuarios
            pc.insertedOne(pessoausuario,PessoaUsuario.class,con);
        }
        else if(pessoausuario.isEdit()){

            pc.editingOne(pessoausuario.getPessoa(),con, pessoausuario.getIdpessoa());
            // altera os dados pessoais
            pc.editingOne(pessoausuario.getPessoa().getPessoaDados(),con, pessoausuario.getPessoa().getPessoaDados().getId());
            // altera na tabela usuarios
            pc.editingOne(pessoausuario,PessoaUsuario.class,con,pessoausuario.getIdpessoa());
        }
        else if(pessoausuario.isDel()){
            pc.deleted(con, pessoausuario.getIdpessoa(), "pessoa");
        }
        con.commit();
        con.close();
        return pessoausuario;
    }
    public Object getById(int id) throws SQLException {

        Object object = new Object();
        Connection con = null;
        con = connection.getNewConnections("estufa_inf");

        String sql = "select * from "+PessoaUsuario.class.getAnnotation(Alias.class).value()+" where id = " + id;

        object =  pc.getOne(PessoaUsuario.class,con,sql);

        return object;
    }
}
