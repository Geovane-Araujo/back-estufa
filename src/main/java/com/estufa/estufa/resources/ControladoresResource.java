package com.estufa.estufa.resources;


import com.estufa.estufa.controller.ControladoresController;
import com.estufa.estufa.model.Controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Hashtable;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins ="*")
public class ControladoresResource {

    @Autowired
    ControladoresController controladoresController;

    @PostMapping("/controladores")
    public ResponseEntity<?> save(@RequestBody Controladores controladores)  {

        Hashtable retorno = new Hashtable();
        try {
            controladoresController.save(controladores);
            retorno.put("ret", "success");
            retorno.put("motivo", "OK");
            retorno.put("obj", controladores);
        }
        catch (SQLException e ) {
            retorno.put("ret", "unsuccess");
            retorno.put("motivo",e.getMessage());
        } catch (IllegalAccessException ex) {
            retorno.put("ret", "unsuccess");
            retorno.put("motivo",ex.getMessage());
        }

        return ResponseEntity.ok().body(retorno);
    }
    @GetMapping("/controladores/{id}")
    public ResponseEntity<?> get(@PathVariable(value="id") int id) throws SQLException {

        Hashtable retorno = new Hashtable();
        try {
            if(id == -100){
                retorno.put("obj", new Controladores());
            }
            else {
                Controladores co = controladoresController.getById(id);
                co.setEdit(true);
                co.setAdd(false);
                retorno.put("obj", co);
            }

            retorno.put("ret", "success");
            retorno.put("motivo", "OK");
        }
        catch (SQLException e ) {
            retorno.put("ret", "unsuccess");
            retorno.put("motivo",e.getMessage());
        }

        return ResponseEntity.ok().body(retorno);
    }
}
