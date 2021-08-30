package com.estufa.estufa.resources;


import com.estufa.estufa.controller.EstufaSetorController;
import com.estufa.estufa.controller.FasesCrecimentoController;
import com.estufa.estufa.model.EstufaSetor;
import com.estufa.estufa.model.FasesCrecimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Hashtable;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins ="*")
public class EstufaSetorResource {

    @Autowired
    EstufaSetorController estufaSetorController;

    @PostMapping("/estufasetor")
    public ResponseEntity<?> save(@RequestBody EstufaSetor estufaSetor)  {

        Hashtable retorno = new Hashtable();
        try {
            estufaSetorController.save(estufaSetor);
            retorno.put("ret", "success");
            retorno.put("motivo", "OK");
            retorno.put("obj", estufaSetor);
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
    @GetMapping("/estufasetor/{id}")
    public ResponseEntity<?> get(@PathVariable(value="id") int id){

        Hashtable retorno = new Hashtable();
        try {
            if(id == -100){
                retorno.put("obj", new FasesCrecimento());
            } else {
                EstufaSetor f = new EstufaSetor();
                f = (EstufaSetor) estufaSetorController.getById(id);
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