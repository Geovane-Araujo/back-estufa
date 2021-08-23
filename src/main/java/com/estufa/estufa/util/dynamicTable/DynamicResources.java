package com.estufa.estufa.util.dynamicTable;

import com.estufa.estufa.security.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Hashtable;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins ="*")
public class DynamicResources {

    @Autowired
    DynamicController dynamicController;

    @PostMapping("/dynamic")
    public ResponseEntity<?> getAll(@RequestHeader(value = "Authorization")String token, @RequestBody DynamicTable dynamic)  {

        Hashtable retorno = new Hashtable();
        try {

            retorno.put("obj", dynamicController.dynamiDataTable(dynamic));
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
