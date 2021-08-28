package com.estufa.estufa.controller;

import com.atom.Alias;
import com.atom.Atom;
import com.estufa.estufa.estufaConnection.EstufaConnections;
import com.estufa.estufa.model.Plantas;
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
public class PlantasController {

    EstufaConnections connection = new EstufaConnections();
    String sql ="" ;
    String descricao = "Cadastro.Plantas";
    String log ="" ;
    Atom pc = new Atom();



    public Plantas save(Plantas plantas) throws SQLException, IllegalAccessException {

        Connection con = null;
        PreparedStatement stmt = null;
        int scalar = 0;

        con = connection.getNewConnections("estufa_inf");

        con.setAutoCommit(false);

        if(plantas.isAdd()){
            scalar = pc.insertedOne(plantas,Plantas.class,con);

        }
        else if(plantas.isEdit()){
            pc.editingOne(plantas,Plantas.class,con,plantas.getId());
        }
        else if(plantas.isDel()){
            pc.deleted(con, plantas.getId(), Plantas.class.getAnnotation(Alias.class).value());
        }
        con.commit();
        con.close();
        return plantas;
    }
    public Object getById(int id) throws SQLException {

        Object object = new Object();
        Connection con = null;
        con = connection.getNewConnections("estufa_inf");

        String sql = "select * from "+Plantas.class.getAnnotation(Alias.class).value()+" where id = " + id;

        object =  pc.getOne(Plantas.class,con,sql);
        con.close();
        return object;
    }
}
