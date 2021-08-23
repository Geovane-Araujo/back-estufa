package com.estufa.estufa.security;

import com.atom.Atom;
import com.estufa.estufa.estufaConnection.EstufaConnections;
import org.springframework.stereotype.Controller;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Base64;
import java.util.Hashtable;
import java.util.Map;

@Controller
public class LoginController {

    Atom at = new Atom();
    EstufaConnections estufaConnections = new EstufaConnections();
    public Login login(Login user) throws SQLException {

        Connection con = null;
        Hashtable retorno = new Hashtable();
        con = estufaConnections.getNewConnections("estufa_inf");

        String sql = "select pessoa.id as id,pessoa.nome as nome " +
                "from pessoa_usuario  " +
                "inner join pessoa on pessoa_usuario.idpessoa = pessoa.id " +
                "where login = '"+user.getNome()+"' and senha = '" + user.getSenha() +"'";
        Login login = (Login)at.getOne(Login.class,con,sql);
        login.setToken(Base64.getEncoder().encodeToString((login.getId()+"&"+login.getNome()+ LocalTime.now()).getBytes(StandardCharsets.UTF_8)));
        con.close();
        return login;
    }
}
