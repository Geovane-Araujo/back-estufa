package com.estufa.estufa.controller;

import com.atom.Alias;
import com.atom.Atom;
import com.estufa.estufa.estufaConnection.EstufaConnections;
import com.estufa.estufa.model.Nutrientes;
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
public class NutrientesController {

    EstufaConnections connection = new EstufaConnections();
    String sql ="" ;
    String descricao = "Cadastro.Nutrientes";
    String log ="" ;
    Atom pc = new Atom();



    public Nutrientes save(Nutrientes nutrientes) throws SQLException, IllegalAccessException {

        Connection con = null;
        PreparedStatement stmt = null;
        int scalar = 0;

        con = connection.getNewConnections("estufa_inf");

        con.setAutoCommit(false);

        if(nutrientes.isAdd()){
            scalar = pc.insertedOne(nutrientes,Nutrientes.class,con);

        }
        else if(nutrientes.isEdit()){
            pc.editingOne(nutrientes,Nutrientes.class,con,nutrientes.getId());
        }
        else if(nutrientes.isDel()){
            pc.deleted(con, nutrientes.getId(), Nutrientes.class.getAnnotation(Alias.class).value());
        }
        con.commit();
        con.close();
        return nutrientes;
    }
    public Object getById(int id) throws SQLException {

        Object object = new Object();
        Connection con = null;
        con = connection.getNewConnections("estufa_inf");

        String sql = "select * from nutrientes where id = " + id;

        object =  pc.getOne(Nutrientes.class,con,sql);
        con.close();
        return object;
    }
}
