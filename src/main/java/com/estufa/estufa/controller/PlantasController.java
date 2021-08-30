package com.estufa.estufa.controller;

import com.atom.Alias;
import com.atom.Atom;
import com.estufa.estufa.estufaConnection.EstufaConnections;
import com.estufa.estufa.model.FasesCrecimentoPlantas;
import com.estufa.estufa.model.Plantas;
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
            scalar = pc.insertedOne(plantas,con);

            for (PlantasNutrientesPlantas pl: plantas.getPlnutrientes()) {
                if(pl.isAdd()){
                    pl.setIdplanta(scalar);
                    pc.insertedOne(pl,con);
                }
                else if(pl.isEdit()){
                    pc.editingOne(pl,con,pl.getId());
                }
                else{
                    pc.deleted(con,pl.getId(),"planta_nutrientes");
                }
            }

            for (FasesCrecimentoPlantas pl: plantas.getFases()) {
                if(pl.isAdd()){
                    pl.setIdplanta(scalar);
                    pc.insertedOne(pl,con);
                }
                else if(pl.isEdit()){
                    pc.editingOne(pl,con,pl.getId());
                }
                else{
                    pc.deleted(con,pl.getId(),"plantas_fases_crecimento");
                }
            }
        }
        else if(plantas.isEdit()){
            pc.editingOne(plantas,Plantas.class,con,plantas.getId());
            for (PlantasNutrientesPlantas pl: plantas.getPlnutrientes()) {
                if(pl.isAdd()){
                    pl.setIdplanta(plantas.getId());
                    pc.insertedOne(pl,con);
                }
                else if(pl.isEdit()){
                    pc.editingOne(pl,con,pl.getId());
                }
                else{
                    pc.deleted(con,pl.getId(),"planta_nutrientes");
                }
            }

            for (FasesCrecimentoPlantas pl: plantas.getFases()) {
                if(pl.isAdd()){
                    pl.setIdplanta(plantas.getId());
                    pc.insertedOne(pl,con);
                }
                else if(pl.isEdit()){
                    pc.editingOne(pl,con,pl.getId());
                }
                else{
                    pc.deleted(con,pl.getId(),"plantas_fases_crecimento");
                }
            }
        }
        else if(plantas.isDel()){
            pc.deleted(con, plantas.getId(), Plantas.class.getAnnotation(Alias.class).value());
        }
        con.commit();
        con.close();
        return plantas;
    }
    public Plantas getById(int id) throws SQLException {

        Plantas object = new Plantas();
        Connection con = null;
        con = connection.getNewConnections("estufa_inf");

        String sql = "select * from "+Plantas.class.getAnnotation(Alias.class).value()+" where id = " + id;
        object =  (Plantas)pc.getOne(Plantas.class,con,sql);

        sql = "select * from vw_plantas_fases_crecimento where idplanta = " + object.getId();
        object.setFases((List<FasesCrecimentoPlantas>) pc.getAll(FasesCrecimentoPlantas.class,con,sql));



        sql = "select * from vw_planta_nutrientes where idplanta = " + object.getId();
        object.setPlnutrientes((List<PlantasNutrientesPlantas>) pc.getAll(PlantasNutrientesPlantas.class,con,sql));

        for(int i = 0;i > object.getFases().size();i++){
            object.getFases().get(i).setAdd(false);
            object.getFases().get(i).setEdit(true);
        }
        for(int i = 0;i > object.getPlnutrientes().size();i++){
            object.getPlnutrientes().get(i).setAdd(false);
            object.getPlnutrientes().get(i).setEdit(true);
        }
        con.close();

        return object;
    }
}
