package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private int id;
    private String usuario;
    private String senha;

    public Usuario(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }
    // Metodos de Acesso
    public int getId() {
        return id;
    }
    public String getSenha() {
        return senha;
    }
    public String getUsuario() {
        return usuario;
    }
    // Metodos Modificadores
    public void setId(int id) {
        this.id = id;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    // Checa se existe a senha e o usuario no bacno de dados
    public boolean carregar(Connection conn){
        ResultSet rs = null;
        PreparedStatement stm = null;
        String sqlSelect = "Select * FROM tb_logins where usuario = ? AND senha = ?";
        try{
            stm = conn.prepareStatement(sqlSelect);
            stm.setString(1,usuario);
            stm.setString(2, senha);
            rs = stm.executeQuery();
            return rs.next();
        }catch(Exception e){
            e.printStackTrace();
           try{
                conn.rollback();
            }catch(Exception w){
                System.out.println(w.getStackTrace());                
            }
            return false;
        }
    }
    public void cadastrarUsuario(Connection conn){
        String sqlInsert = "INSERT INTO tb_logins(usuario,senha) VALUES (?,?)";
        try (PreparedStatement stm = conn.prepareStatement(sqlInsert);){
            stm.setString(1,getUsuario() );
            stm.setString(2, getSenha());
            stm.execute();
        }catch(Exception e){
            e.printStackTrace();
            try{
                conn.rollback();
            }
            catch(SQLException w){
                System.out.println(w.getStackTrace());
            }
        }
    }
}
