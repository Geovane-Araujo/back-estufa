package com.estufa.estufa.controller;

import com.atom.Alias;
import com.atom.Atom;
import com.estufa.estufa.estufaConnection.EstufaConnections;
import com.estufa.estufa.model.Controladores;
import com.estufa.estufa.model.ControladoresPlantas;
import com.estufa.estufa.model.PlantasNutrientesPlantas;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Geovane
 * Gerado automaticaente por AdonaiSoft - Utilitário
 */
@Controller
public class ControladoresController {

    EstufaConnections connection = new EstufaConnections();
    String sql ="" ;
    String descricao = "Cadastro.Controladores";
    String log ="" ;
    Atom pc = new Atom();



    public Controladores save(Controladores controladores) throws SQLException, IllegalAccessException {

        Connection con = null;
        PreparedStatement stmt = null;
        int scalar = 0;

        con = connection.getNewConnections("estufa_inf");

        con.setAutoCommit(false);

        if(controladores.isAdd()){
            scalar = pc.insertedOne(controladores,Controladores.class,con);

            for (ControladoresPlantas plc: controladores.getPlantas()) {
                if(plc.isAdd()){
                    plc.setIdcontrolador(scalar);
                    pc.insertedOne(plc,con);
                }
                else if(plc.isEdit()){
                    pc.editingOne(plc,con,plc.getId());
                }
                else{
                    pc.deleted(con, plc.getId(),"controladores_plantas");
                }
            }

        }
        else if(controladores.isEdit()){
            pc.editingOne(controladores,Controladores.class,con,controladores.getId());

            for (ControladoresPlantas plc: controladores.getPlantas()) {
                if(plc.isAdd()){
                    plc.setIdcontrolador(controladores.getId());
                    pc.insertedOne(plc,con);
                }
                else if(plc.isEdit()){
                    pc.editingOne(plc,con,plc.getId());
                }
                else{
                    pc.deleted(con, plc.getId(),"controladores_plantas");
                }
            }

        }
        else if(controladores.isDel()){
            pc.deleted(con, controladores.getId(), Controladores.class.getAnnotation(Alias.class).value());
        }
        con.commit();
        con.close();
        return controladores;
    }
    public Controladores getById(int id) throws SQLException {

        Controladores object = new Controladores();
        Connection con = null;
        con = connection.getNewConnections("estufa_inf");

        String sql = "select * from vw_controladores where id = " + id;

        object =  (Controladores)pc.getOne(Controladores.class,con,sql);

        sql = "select * from vw_controladores_plantas where idcontrolador = " + object.getId();
        object.setPlantas((List<ControladoresPlantas>) pc.getAll(ControladoresPlantas.class,con,sql));

        for(int i = 0;i > object.getPlantas().size();i++){
            object.getPlantas().get(i).setAdd(false);
            object.getPlantas().get(i).setEdit(true);
        }

        return object;
    }
}
