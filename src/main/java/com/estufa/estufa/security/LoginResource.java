package com.estufa.estufa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Hashtable;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins ="*")
public class LoginResource {

    @Autowired
    LoginController loginController;

    @PostMapping("/login")
    public ResponseEntity<?> save(@RequestBody Login login)  {

        Hashtable retorno = new Hashtable();
        try {
            Login obj = loginController.login(login);
            if(obj.getId() == 0){
                retorno.put("ret", "unsuccess");
                retorno.put("motivo", "Usuário ou senha inválido");
            }
            else{
                retorno.put("ret", "success");
                retorno.put("motivo", "OK");
            }
            retorno.put("obj", obj);
        }
        catch (SQLException e ) {
            retorno.put("ret", "unsuccess");
            retorno.put("motivo",e.getMessage());
        }
        return ResponseEntity.ok().body(retorno);
    }
}
