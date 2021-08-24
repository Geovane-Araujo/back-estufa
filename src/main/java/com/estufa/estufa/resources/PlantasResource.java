package com.estufa.estufa.resources;


import com.estufa.estufa.controller.PlantasController;
import com.estufa.estufa.model.Plantas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Hashtable;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins ="*")
public class PlantasResource {

    @Autowired
    PlantasController plantasController;

    @PostMapping("/plantas")
    public ResponseEntity<?> save(@RequestBody Plantas plantas)  {

        Hashtable retorno = new Hashtable();
        try {
            plantasController.save(plantas);
            retorno.put("ret", "success");
            retorno.put("motivo", "OK");
            retorno.put("obj", plantas);
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
    @GetMapping("/plantas/{id}")
    public ResponseEntity<?> get(@PathVariable(value="id") int id) throws SQLException {

        Plantas p = new Plantas();
        Hashtable retorno = new Hashtable();
        try {
            if(id != -100){
                p = (Plantas)plantasController.getById(id);
                p.setAdd(false);
                p.setEdit(true);
            }

            retorno.put("ret", "success");
            retorno.put("motivo", "OK");
            retorno.put("obj",p);
        }
        catch (SQLException e ) {
            retorno.put("ret", "unsuccess");
            retorno.put("motivo",e.getMessage());
        }

        return ResponseEntity.ok().body(retorno);
    }
}
