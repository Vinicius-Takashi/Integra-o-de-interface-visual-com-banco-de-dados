package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame implements ActionListener {
    // Botão de login
    private BtnPersonalizado botaoLogin;
    private BtnPersonalizado botaoCadastro;
    // Campo de texto para o usuário e senha
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    // Rótulos para os campos de texto
    private JLabel lblUsuario;
    private JLabel lblSenha;
    // Titulo da janela	
    private JLabel lblTitulo;

    // Construtor da classe TelaLogin
    public TelaLogin(){
        // Instanciando os componentes
        botaoLogin = new BtnPersonalizado("Entrar");
        botaoCadastro = new BtnPersonalizado("Cadastrar");
        campoUsuario = new JTextField(20);
        campoSenha = new JPasswordField(20);
        lblUsuario = new JLabel("Usuário:");
        lblSenha = new JLabel("Senha:");
        lblTitulo = new JLabel("Login:");

        // Adicionando o Listener nos botões
        botaoLogin.addActionListener(this);
        botaoCadastro.addActionListener(this);

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
        campoUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        campoUsuario.setPreferredSize(new Dimension(200, 20));
        campoUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        campoUsuario.setHorizontalAlignment(SwingConstants.LEADING);
        campoUsuario.setBackground(new Color(17, 3, 117));
        campoUsuario.setForeground(Color.WHITE);
        campoUsuario.setCaretColor(Color.WHITE);
        campoSenha.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        campoSenha.setSize(new Dimension(200, 20));
        campoSenha.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        campoSenha.setHorizontalAlignment(SwingConstants.LEADING);
        campoSenha.setBackground(new Color(17, 3, 117));
        campoSenha.setForeground(Color.WHITE);
        campoSenha.setCaretColor(Color.WHITE);
        // Configurando o layout
        Container container = getContentPane();
        container.setLayout(new BorderLayout(20,20));
        JPanel painelTitulo = new JPanel(new BorderLayout());
        painelTitulo.add(lblTitulo, BorderLayout.CENTER);
        painelTitulo.setBackground(new Color(17, 3, 117));
        JPanel painelLogin = new JPanel(new GridLayout(2,2,10,30));
        painelLogin.add(lblUsuario);
        painelLogin.add(campoUsuario);
        painelLogin.add(lblSenha);
        painelLogin.add(campoSenha);
        painelLogin.setBackground(new Color(17, 3, 117));
        JPanel painelBtn = new JPanel(new BorderLayout());
        painelBtn.add(botaoLogin,BorderLayout.EAST);
        painelBtn.add(botaoCadastro,BorderLayout.WEST);
        painelBtn.setBackground(new Color(17, 3, 117));
        container.add(painelTitulo,BorderLayout.NORTH);
        container.add(painelLogin, BorderLayout.CENTER);
        container.add(painelBtn, BorderLayout.SOUTH);
        // Configurando o fundo da janela
        container.setBackground(new Color(17, 3, 117));

        // Configurando a janela
        setTitle("Tela de Login");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== botaoLogin){
            Connection conn = null;
            ConexãoBD conexao = new ConexãoBD();
            try {
                conn = conexao.conectar();
                String login = campoUsuario.getText();
                String ps = new String(campoSenha.getPassword());
                Usuario usuario = new Usuario(login,ps);
                if(usuario.carregar(conn)){
                // existe o usuario
                TelaInicial tela = new TelaInicial();
                this.dispose();
            }
                else{
                // nao existe
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            }catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        else if(e.getSource() == botaoCadastro){
            TelaCadastroLogin telaCadastro = new TelaCadastroLogin();
            this.dispose(); // Fecha a tela de login
        }
    }
}
