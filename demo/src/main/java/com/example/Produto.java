package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Produto{
    // Atributos
    private int id_produto;
    private String nome;
    private String marca;
    private int quantidade;
    private String unidade_medida;
    private double preco;
    private String categoria;
    private String localizacao;
    // Constrututor
    public Produto() {
    }
    public Produto(String nome, String categoria, String localizacao) {
        this.nome = nome;
        marca = "";
        preco = 0.0;
        quantidade = 0;
        unidade_medida = "";
        this.categoria = categoria;
        this.localizacao = localizacao;
    }
    public Produto(int id_produto) {
        setId_produto(id_produto);
    }
    public Produto(String nome,String marca, double preco,int quantidade, String unidade, String categoria, int id_produto, String localizacao) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.quantidade = quantidade;
        this.unidade_medida = unidade;
        this.categoria = categoria;
        this.id_produto = id_produto;
        this.localizacao = localizacao;
    }
    // Metodos modificador e de acesso do atributo nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    // Metodos modificador e de acesso do atributo unidade_medida
    public String getUnidade_medida() {
        return unidade_medida;
    }
    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }
    // Metodos modificador e de acesso do atributo quantidade
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    // Metodos modificador e de acesso do atributo marca
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    // Metodos modificador e de acesso do atributo preco
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    // Metodos modificador e de acesso do atributo categoria
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    // Metodos modificador e de acesso do atributo id_produto
    public int getId_produto() {
        return id_produto;
    }
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
    // Metodos modificador e de acesso do atributo localização
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    // Método para exibir informações do produto
    public String exibirInformacoes() {
        return "ID: " + id_produto + "\n" +
               "Nome: " + nome + "\n" +
               "Marca: " + marca + "\n" +
                "Quantidade: " + quantidade + "\n" +
                "Tipo de medida: "+ unidade_medida + "\n" +
               "Preço: R$" + preco + "\n" +
               "Categoria: " + categoria + "\n" +
               "Localização: " + localizacao;
    }
public void inserir(Connection conn){
        String sqlInsert = "INSERT INTO produto(nome,marca,quantidade,preco,UnidadeMedida,categoria,localizacao) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement stm = conn.prepareStatement(sqlInsert);){
            stm.setString(1, getNome());
            stm.setString(2, getMarca());
            stm.setInt(3, getQuantidade());
            stm.setDouble(4, getPreco());
            stm.setString(5, getUnidade_medida());
            stm.setString(6, getCategoria());
            stm.setString(7, getLocalizacao());
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
      public void alterar(Connection conn, String nome, String marca, int qtd, double preco, String unidade, String categoria, String localizacao){
        String sqlUpdate = "UPDATE produto set nome = ?, marca = ?, quantidade = ?, preco = ?, UnidadeMedida = ?,categoria = ?, localizacao = ? where id = ?";
        try(PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
            stm.setString(1,nome);
            stm.setString(2, marca);
            stm.setInt(3, qtd);
            stm.setDouble(4, preco);
            stm.setString(5, unidade);
            stm.setString(6, categoria);
            stm.setString(7, localizacao);
            stm.setInt(8, getId_produto());
            stm.execute();
        }
        catch(Exception e){
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception w) {
                System.out.println(w.getStackTrace());
            }
        }
    }

    public void excluir(Connection conn){
        String sqlDelete = "Delete from produto where id = ?";
        try(PreparedStatement stm = conn.prepareStatement(sqlDelete);){
            stm.setInt(1,getId_produto());
            stm.execute();
        }
        catch(Exception e){
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception w) {
                System.out.println(w.getStackTrace());
            }
        }
    }
    public void carregar(Connection conn){
        ResultSet rs = null;
        PreparedStatement stm = null;
        String sqlSelect = "Select * FROM produto where id = ?";
        try{
            stm = conn.prepareStatement(sqlSelect);
            stm.setInt(1,getId_produto());
            rs = stm.executeQuery();
                if(rs.next()){
                    this.setNome(rs.getString(2));
                    this.setMarca(rs.getString(3));
                    this.setQuantidade(rs.getInt(4));
                    this.setPreco(rs.getDouble(5));
                    this.setUnidade_medida(rs.getString(6));
                    this.setCategoria(rs.getString(7));
                    this.setLocalizacao(rs.getString(8));
                }
            }catch(Exception e){
                e.printStackTrace();
                try{
                    conn.rollback();
                }catch(Exception w){
            System.out.println(w.getStackTrace());
        }
            }finally{
            if( rs !=null){
                try {
                    rs.close();
                } catch (SQLException w) {
                    System.out.println(w.getStackTrace());
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException w) {
                    System.out.println(w.getStackTrace());
                }
                
            }
        }
    }
    public List<Produto> filtrarMult(String nome, String marca, String categoria, String localizacao) {
    List<Produto> listaProdutos = new ArrayList<>();

    try {
        ConexãoBD conexao = new ConexãoBD();
        Connection conn = conexao.conectar();

        StringBuilder sql = new StringBuilder("SELECT * FROM produto WHERE 1=1");
        List<Object> parametros = new ArrayList<>();

        // Adicionando filtros condicionais
        if (nome != null && !nome.trim().isEmpty()) {
            sql.append(" AND nome LIKE ?");
            parametros.add("%" + nome.trim() + "%");
        }
        if (marca != null && !marca.trim().isEmpty()) {
            sql.append(" AND marca LIKE ?");
            parametros.add("%" + marca.trim() + "%");
        }
        if (categoria != null && !categoria.trim().isEmpty() && !categoria.equals("")) {
            sql.append(" AND categoria = ?");
            parametros.add(categoria.trim());
        }
        if (localizacao != null && !localizacao.trim().isEmpty() && !localizacao.equals("")) {
            sql.append(" AND localizacao = ?");
            parametros.add(localizacao.trim());
        }

        PreparedStatement stmt = conn.prepareStatement(sql.toString());

        // Configurando os parâmetros
        for (int i = 0; i < parametros.size(); i++) {
            stmt.setObject(i + 1, parametros.get(i));
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produto p = new Produto();
            p.setId_produto(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setMarca(rs.getString("marca"));
            p.setQuantidade(rs.getInt("quantidade"));
            p.setPreco(rs.getDouble("preco"));
            p.setUnidade_medida(rs.getString("UnidadeMedida"));
            p.setCategoria(rs.getString("categoria"));
            p.setLocalizacao(rs.getString("localizacao"));
            listaProdutos.add(p);
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao carregar dados do banco: " + e.getMessage());
    }

    return listaProdutos;
}
public List<Produto> carregarTodos(Connection conn){
        List<Produto> listaProdutos = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement stm = null;
        String sqlSelect = "Select * FROM produto";
        try{
            stm = conn.prepareStatement(sqlSelect);
            rs = stm.executeQuery();
                while(rs.next()){
                    Produto p = new Produto(); // Cria uma nova instância de Produto
                    p.setId_produto(rs.getInt(1));
                    p.setNome(rs.getString(2));
                    p.setMarca(rs.getString(3));
                    p.setQuantidade(rs.getInt(4));
                    p.setPreco(rs.getDouble(4));
                    p.setUnidade_medida(rs.getString(6));
                    p.setCategoria(rs.getString(7));
                    p.setLocalizacao(rs.getString(8));
                    listaProdutos.add(p);
                }
            }catch(Exception e){
                e.printStackTrace();
                try{
                    conn.rollback();
                }catch(Exception w){
            System.out.println(w.getStackTrace());
        }
            }finally{
            if( rs !=null){
                try {
                    rs.close();
                } catch (SQLException w) {
                    System.out.println(w.getStackTrace());
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException w) {
                    System.out.println(w.getStackTrace());
                }
                
            }
        }
        return listaProdutos;
    }

}