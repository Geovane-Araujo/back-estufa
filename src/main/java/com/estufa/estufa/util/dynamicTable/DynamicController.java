package com.estufa.estufa.util.dynamicTable;

import com.atom.Atom;
import com.estufa.estufa.estufaConnection.EstufaConnections;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Controller
public class DynamicController {

    Atom at = new Atom();
    EstufaConnections estufaConnections = new EstufaConnections();
    public Object dynamiDataTable(DynamicTable table) throws SQLException {

        Hashtable retorno = new Hashtable();
        Connection con = estufaConnections.getNewConnections("estufa_inf");

        Map m = (Map)at.getOne(Map.class,con,"select sql,tablebase from dynamic where route = '" + table.getRoute() + "'");

        String sql = m.get("sql").toString();
        sql = sql + " where "+ m.get("tablebase")+  ".id > 0 "+ table.getFilters() + " order by " + table.getOrders();
        List<Map> dt = (List<Map>)at.getAll(Map.class,con,sql + " limit 20 offset("+ table.getPagging() +"-1)*20;");

        Map qtd = (Map)at.getOne(Map.class,con,"select count(id) as quantidade from " +m.get("tablebase") + " where id > 0 " + table.getFilters());

        retorno.put("rows",qtd.get("quantidade"));
        retorno.put("obj",dt);
        con.close();
        return retorno;
    }

    public void onDeleted(int id, String tablebase) throws SQLException {

        Connection con = estufaConnections.getNewConnections("estufa_inf");
        at.deleted(con,id,tablebase);
    }
}
