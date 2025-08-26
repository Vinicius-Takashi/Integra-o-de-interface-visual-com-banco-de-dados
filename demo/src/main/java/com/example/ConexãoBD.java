package com.example;
import java.sql.*;
public class ConexãoBD {
    static{
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException e){
        throw new RuntimeException(e);
    }

    }
    public Connection conectar() throws SQLException {
        String servidor = "";
        String porta = "";
        String database = "";
        String usuario = "";
        String senha = "";
        return DriverManager.getConnection(
            "jdbc:mysql://" + servidor + ":" + porta + "/" + database +
            "?user=" + usuario +
            "&password=" + senha +
            "&serverTimezone=America/Sao_Paulo"
        );
    }
}