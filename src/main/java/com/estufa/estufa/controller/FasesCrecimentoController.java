package com.estufa.estufa.controller;


import com.atom.Alias;
import com.atom.Atom;
import com.estufa.estufa.estufaConnection.EstufaConnections;
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
public class FasesCrecimentoController {

    EstufaConnections connection = new EstufaConnections();
    String sql ="" ;
    String descricao = "Cadastro.FasesCrecimento";
    String log ="" ;
    Atom pc = new Atom();



    public FasesCrecimento save(FasesCrecimento fasescrecimento) throws SQLException, IllegalAccessException {

        Connection con = null;
        PreparedStatement stmt = null;
        int scalar = 0;

        con = connection.getNewConnections("estufa_inf");

        con.setAutoCommit(false);

        if(fasescrecimento.isAdd()){
            scalar = pc.insertedOne(fasescrecimento,FasesCrecimento.class,con);

        }
        else if(fasescrecimento.isEdit()){
            pc.editingOne(fasescrecimento,FasesCrecimento.class,con,fasescrecimento.getId());
        }
        else if(fasescrecimento.isDel()){
            pc.deleted(con, fasescrecimento.getId(), FasesCrecimento.class.getAnnotation(Alias.class).value());
        }
        con.commit();
        con.close();
        return fasescrecimento;
    }
    public Object getById(int id) throws SQLException {

        Object object = new Object();
        Connection con = null;
        con = connection.getNewConnections("estufa_inf");

        String sql = "select * from fases_crecimento where id = " + id;

        object =  pc.getOne(FasesCrecimento.class,con,sql);

        return object;
    }
}
