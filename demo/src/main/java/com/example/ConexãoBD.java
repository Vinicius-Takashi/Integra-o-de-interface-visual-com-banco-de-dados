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
        String servidor = "projetolp1-projetolp1.g.aivencloud.com";
        String porta = "20883";
        String database = "projeto";
        String usuario = "avnadmin";
        String senha = "AVNS_OIAUWhmXs-mkcMMuTfR";
        return DriverManager.getConnection(
            "jdbc:mysql://" + servidor + ":" + porta + "/" + database +
            "?user=" + usuario +
            "&password=" + senha +
            "&serverTimezone=America/Sao_Paulo"
        );
    }
}