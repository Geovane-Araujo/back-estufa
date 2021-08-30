package com.estufa.estufa.controller;


import com.atom.Alias;
import com.atom.Atom;
import com.estufa.estufa.estufaConnection.EstufaConnections;
import com.estufa.estufa.model.EstufaSetor;
import com.estufa.estufa.model.FasesCrecimento;
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
public class EstufaSetorController {

    EstufaConnections connection = new EstufaConnections();
    String sql ="" ;
    String descricao = "Cadastro.FasesCrecimento";
    String log ="" ;
    Atom pc = new Atom();



    public EstufaSetor save(EstufaSetor estufaSetor) throws SQLException, IllegalAccessException {

        Connection con = null;
        PreparedStatement stmt = null;
        int scalar = 0;

        con = connection.getNewConnections("estufa_inf");

        con.setAutoCommit(false);

        if(estufaSetor.isAdd()){
            scalar = pc.insertedOne(estufaSetor,FasesCrecimento.class,con);

        }
        else if(estufaSetor.isEdit()){
            pc.editingOne(estufaSetor,FasesCrecimento.class,con,estufaSetor.getId());
        }
        else if(estufaSetor.isDel()){
            pc.deleted(con, estufaSetor.getId(), FasesCrecimento.class.getAnnotation(Alias.class).value());
        }
        con.commit();
        con.close();
        return estufaSetor;
    }
    public Object getById(int id) throws SQLException {

        Object object = new Object();
        Connection con = null;
        con = connection.getNewConnections("estufa_inf");

        String sql = "select * from estufa_setor where id = " + id;

        object =  pc.getOne(EstufaSetor.class,con,sql);
        con.close();
        return object;
    }
}
