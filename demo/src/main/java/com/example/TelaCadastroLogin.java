package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class TelaCadastroLogin extends JFrame implements ActionListener {
    //Botão de cadastro
    private BtnPersonalizado btnCadastro;
    // Botão de voltar
    private BtnPersonalizado btnVoltar;
    // Texto do Titulo
    private JLabel lblTitulo;
    // Campos de texto
    private JTextField txtUsuario;
    private JTextField txtSenha;
    // Rótulos
    private JLabel lblUsuario;
    private JLabel lblSenha;
    // Construtor da classe TelaCadastroLogin
    public TelaCadastroLogin() {
        super("Tela de Cadastro");

        // Inicializando os componentes
        btnCadastro = new BtnPersonalizado("Cadastrar");
        btnVoltar = new BtnPersonalizado("Voltar");
        txtUsuario = new JTextField(20);
        txtSenha = new JTextField(20);
        lblUsuario = new JLabel("Usuário:");
        lblSenha = new JLabel("Senha:");
        lblTitulo = new JLabel("Cadastre-se:");

        // Configurando a fonte do título
        lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Configurando a fonte dos rótulos
        lblUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblUsuario.setForeground(Color.WHITE);
        lblSenha.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblSenha.setForeground(Color.WHITE);

        // Configurando a fonte dos campos de texto
        txtUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtUsuario.setSize(new Dimension(200, 20));
        txtUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtUsuario.setHorizontalAlignment(SwingConstants.LEADING);
        txtUsuario.setBackground(new Color(17, 3, 117));
        txtUsuario.setForeground(Color.WHITE);
        txtUsuario.setCaretColor(Color.WHITE);
    
        txtSenha.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtSenha.setSize(new Dimension(200, 20));
        txtSenha.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtSenha.setHorizontalAlignment(SwingConstants.LEADING);
        txtSenha.setBackground(new Color(17, 3, 117));
        txtSenha.setForeground(Color.WHITE);
        txtSenha.setCaretColor(Color.WHITE);

        // Adicionando o Listener nos botões
        btnCadastro.addActionListener(this);
        btnVoltar.addActionListener(this);

        // Configurando o layout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JPanel painelTitulo = new JPanel(new BorderLayout());
        painelTitulo.add(lblTitulo, BorderLayout.NORTH);
        painelTitulo.setBackground(new Color(17, 3, 117));
        JPanel painelCampos = new JPanel(new GridLayout(3, 2, 10, 10));
        painelCampos.add(lblUsuario);
        painelCampos.add(txtUsuario);
        painelCampos.add(lblSenha);
        painelCampos.add(txtSenha);
        painelCampos.setBackground(new Color(17, 3, 117));
        JPanel painelBtn = new JPanel(new BorderLayout(10,10));
        painelBtn.add(btnCadastro, BorderLayout.EAST);
        painelBtn.add(btnVoltar, BorderLayout.WEST);
        painelBtn.setBackground(new Color(17, 3, 117));
        container.add(painelTitulo, BorderLayout.NORTH);
        container.add(painelCampos, BorderLayout.CENTER);
        container.add(painelBtn, BorderLayout.SOUTH);
        // Configurando o fundo da janela
        container.setBackground(new Color(17, 3, 117));
        // configurando a tela
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);// Tornando a janela visível
}
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnCadastro) {
        // Lógica para cadastro
        Connection conn = null;
        ConexãoBD cn = new ConexãoBD();
        try {
            conn = cn.conectar();
            Usuario usuario = new Usuario(txtUsuario.getText(), txtSenha.getText());
            usuario.cadastrarUsuario(conn);
            TelaLogin telaLogin = new TelaLogin();
            this.dispose(); // Fecha a tela de cadastro
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + ex.getMessage());
            return;
        }
        JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
    } else if (e.getSource() == btnVoltar) {
        // Lógica para voltar à tela anterior
        TelaLogin telaLogin = new TelaLogin();
        this.dispose(); // Fecha a tela atual
    }
}
}
