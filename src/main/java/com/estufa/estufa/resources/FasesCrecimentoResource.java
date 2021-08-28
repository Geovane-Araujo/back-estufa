package com.estufa.estufa.resources;


import com.estufa.estufa.controller.FasesCrecimentoController;
import com.estufa.estufa.model.FasesCrecimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Hashtable;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins ="*")
public class FasesCrecimentoResource {

    @Autowired
    FasesCrecimentoController fasescrecimentoController;

    @PostMapping("/fasescrecimento")
    public ResponseEntity<?> save(@RequestBody FasesCrecimento fasescrecimento)  {

        Hashtable retorno = new Hashtable();
        try {
            fasescrecimentoController.save(fasescrecimento);
            retorno.put("ret", "success");
            retorno.put("motivo", "OK");
            retorno.put("obj", fasescrecimento);
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
    @GetMapping("/fasescrecimento/{id}")
    public ResponseEntity<?> get(@PathVariable(value="id") int id){

        Hashtable retorno = new Hashtable();
        try {
            if(id == -100){
                retorno.put("obj", new FasesCrecimento());
            } else {
                FasesCrecimento f = new FasesCrecimento();
                f = (FasesCrecimento) fasescrecimentoController.getById(id);
                f.setAdd(false);
                f.setEdit(true);
                retorno.put("obj", f);
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