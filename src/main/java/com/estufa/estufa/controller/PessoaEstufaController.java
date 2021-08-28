package com.estufa.estufa.controller;

import com.atom.Alias;
import com.atom.Atom;
import com.estufa.estufa.estufaConnection.EstufaConnections;
import com.estufa.estufa.model.Pessoa;
import com.estufa.estufa.model.PessoaDados;
import com.estufa.estufa.model.PessoaEstufa;
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
public class PessoaEstufaController {

    EstufaConnections connection = new EstufaConnections();
    String sql ="" ;
    String descricao = "Cadastro.PessoaEstufa";
    String log ="" ;
    Atom pc = new Atom();



    public PessoaEstufa save(PessoaEstufa pessoaestufa) throws SQLException, IllegalAccessException {

        Connection con = null;
        PreparedStatement stmt = null;
        int scalar = 0;

        con = connection.getNewConnections("estufa_inf");

        con.setAutoCommit(false);

        if(pessoaestufa.isAdd()){

            scalar = pc.insertedOne(pessoaestufa.getPessoa(),Pessoa.class,con);

            pessoaestufa.getPessoa().getPessoaDados().setIdpessoa(scalar);
            pc.insertedOne(pessoaestufa.getPessoa().getPessoaDados(),PessoaDados.class,con);

            pessoaestufa.setIdpessoa(scalar);
            pc.insertedOne(pessoaestufa,PessoaEstufa.class,con);

        }
        else if(pessoaestufa.isEdit()){
            pc.editingOne(pessoaestufa.getPessoa(),Pessoa.class,con,pessoaestufa.getIdpessoa());
            pc.editingOne(pessoaestufa.getPessoa().getPessoaDados(),PessoaDados.class,con,pessoaestufa.getIdpessoa());
            pc.editingOne(pessoaestufa,PessoaEstufa.class,con,pessoaestufa.getId());
        }
        else if(pessoaestufa.isDel()){
            pc.deleted(con, pessoaestufa.getIdpessoa(), Pessoa.class.getAnnotation(Alias.class).value());
        }
        con.commit();
        con.close();
        return pessoaestufa;
    }
    public PessoaEstufa getById(int id) throws SQLException {

        PessoaEstufa object = new PessoaEstufa();
        Connection con = null;
        con = connection.getNewConnections("estufa_inf");

        String sql = "select * from pessoa_estufa where idpessoa = " + id;

        object =  (PessoaEstufa)pc.getOne(PessoaEstufa.class,con,sql);

        sql = "select * from pessoa where id = " + object.getIdpessoa();
        object.setPessoa((Pessoa)pc.getOne(Pessoa.class,con,sql));

        sql = "select * from pessoa_dadoscontato where idpessoa = " + object.getIdpessoa();
        PessoaDados p = (PessoaDados) pc.getOne(PessoaDados.class,con,sql);
        object.getPessoa().setPessoaDados(p);
        con.close();
        return object;
    }
}
