package com.estufa.estufa.resources;


import com.estufa.estufa.controller.PessoaEstufaController;
import com.estufa.estufa.controller.PessoaUsuarioController;
import com.estufa.estufa.model.PessoaEstufa;
import com.estufa.estufa.model.PessoaUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Hashtable;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins ="*")
public class PessoaUsuarioResource {

    @Autowired
    PessoaUsuarioController pessoausuarioController;

    @PostMapping("/pessoausuario")
    public ResponseEntity<?> save(@RequestBody PessoaUsuario pessoaUsuario)  {

        Hashtable retorno = new Hashtable();
        try {
            pessoausuarioController.save(pessoaUsuario);
            retorno.put("ret", "success");
            retorno.put("motivo", "OK");
            retorno.put("obj", pessoaUsuario);
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
    @GetMapping("/pessoausuario/{id}")
    public ResponseEntity<?> get(@PathVariable(value="id") int id) throws SQLException {

        Hashtable retorno = new Hashtable();
        try {
            if(id == -100){
                retorno.put("obj", new PessoaUsuario());
            }
            else {
                PessoaUsuario p = pessoausuarioController.getById(id);
                p.setAdd(false);
                p.setEdit(true);
                retorno.put("obj", p);
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
