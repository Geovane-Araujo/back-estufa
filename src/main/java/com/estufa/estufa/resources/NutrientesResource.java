package com.estufa.estufa.resources;


import com.estufa.estufa.controller.NutrientesController;
import com.estufa.estufa.model.Nutrientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Hashtable;

@RestController
@RequestMapping(value = "/v1")
@CrossOrigin(origins ="*")
public class NutrientesResource {

    @Autowired
    NutrientesController nutrientesController;

    String a = "select  EloIntegracao,EloIntegracaoVariant, Comprimento,Largura,Altura,EstoqueAtual, ValorCusto, ValorVendaVista, ValorVendaPromocional \n" +
            "from produtos  \n" +
            "where VendeEcommerce = 1 and EloIntegracao is not null";

    @PostMapping("/nutrientes")
    public ResponseEntity<?> save(@RequestBody Nutrientes nutrientes)  {

        Hashtable retorno = new Hashtable();
        try {
            nutrientesController.save(nutrientes);
            retorno.put("ret", "success");
            retorno.put("motivo", "OK");
            retorno.put("obj", nutrientes);
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
    @GetMapping("/nutrientes/{id}")
    public ResponseEntity<?> get(@PathVariable(value="id") int id) throws SQLException {

        Hashtable retorno = new Hashtable();
        try {
            retorno.put("obj", nutrientesController.getById(id));
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
