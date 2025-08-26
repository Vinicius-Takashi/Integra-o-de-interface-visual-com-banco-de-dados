package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
public class TelaInicial extends JFrame implements ActionListener {
    // Botão de cadastro de produto
    private BtnPersonalizado btnCadastroProduto;
    // Botão de consulta de estoque
    private BtnPersonalizado btnConsultaEstoque;
    // Botão de remover produto
    private BtnPersonalizado btnRemoverProduto;
    // Botão de atualizar produto
    private BtnPersonalizado btnAtualizarProduto;
    // Texto de boas-vindas
    private JLabel lblBoasVindas;

    public TelaInicial() {
        super("Sistema de Controle de Estoque");

        //inicializando componentes
        btnCadastroProduto = new BtnPersonalizado("Cadastrar Produto");
        btnConsultaEstoque = new BtnPersonalizado( "Consultar Estoque");
        btnRemoverProduto = new BtnPersonalizado("Remover Produto");
        btnAtualizarProduto = new BtnPersonalizado("Atualizar Produto");
        lblBoasVindas = new JLabel("Sistema de Controle de Estoque");

        // Configurando o texto de boas-vindas
        lblBoasVindas.setFont(new Font("Trebuchet MS", Font.ITALIC, 40))   ;
        lblBoasVindas.setForeground(Color.WHITE);
        lblBoasVindas.setHorizontalAlignment(SwingConstants.CENTER);
    
        // Configurando o layout
        Container caixa = getContentPane();
        caixa.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
        JPanel painelBtn = new JPanel(new GridLayout(2,2,10,10));
        painelBtn.setBackground(new Color(17, 3, 117));
        caixa.add(lblBoasVindas);
        painelBtn.add(btnCadastroProduto);
        painelBtn.add(btnConsultaEstoque);
        painelBtn.add(btnRemoverProduto);
        painelBtn.add(btnAtualizarProduto);
        caixa.add(painelBtn);

        // Configurando o fundo da janela
        caixa.setBackground(new Color(17, 3, 117));
        
        
        
        // Adicionando ActionListener aos botões
        btnCadastroProduto.addActionListener(this);
        btnConsultaEstoque.addActionListener(this);
        btnRemoverProduto.addActionListener(this);
        btnAtualizarProduto.addActionListener(this);
        
        // Configurando o tamanho dos botões
        btnCadastroProduto.setPreferredSize(new Dimension(200, 50));
        btnConsultaEstoque.setPreferredSize(new Dimension(200, 50));
        btnRemoverProduto.setPreferredSize(new Dimension(200, 50));
        btnAtualizarProduto.setPreferredSize(new Dimension(200, 50));

        // Configurando o tamanho da janela
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setTitle("Sistema de Controle de Estoque");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastroProduto) {
            // Ação para cadastrar produto
            TelaCadastro telaCadastro = new TelaCadastro();
            this.dispose();
        } else if (e.getSource() == btnConsultaEstoque) {
            // Ação para consultar estoque
            TelaConsultaEstoque telaConsulta = new TelaConsultaEstoque();
            this.dispose();
        } else if (e.getSource() == btnRemoverProduto) {
            // Ação para remover produto
            TelaRemover telaRemover = new TelaRemover();
            this.dispose();
        } else if (e.getSource() == btnAtualizarProduto) {
            // Ação para atualizar produto
            TelaAtualizarProduto telaAtualizar = new TelaAtualizarProduto();
            this.dispose();
        }
    }
}
