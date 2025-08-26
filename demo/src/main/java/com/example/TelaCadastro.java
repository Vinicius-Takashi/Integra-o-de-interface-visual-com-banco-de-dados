package com.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.*;

public class TelaCadastro extends JFrame implements ActionListener {
    // Botões
    private BtnPersonalizado btnCadastrar;
    private BtnPersonalizado btnVoltar;

    // Campos de texto
    private JTextField txtNome;
    private JTextField txtMarca;
    private JTextField txtPreco;
    private JTextField txtQuantidade;

    // ComboBox (lista suspensa)
    private JComboBox<String> cbCategoria;
    private JComboBox<String> cbLocalizacao;
    private JComboBox<String> cbUnidade;

    // Rótulos
    private JLabel lblNome;
    private JLabel lblMarca;
    private JLabel lblPreco;
    private JLabel lblQuantidade;   
    private JLabel lblCategoria;
    private JLabel lblUnidade;
    private JLabel lblLocalizacao;
    private JLabel lblTELA;

    public TelaCadastro(){
        super("Tela de Cadastro");

        // Inicializando os componentes
        btnCadastrar = new BtnPersonalizado("Cadastrar");
        btnVoltar = new BtnPersonalizado("Voltar");
        txtNome = new JTextField(30);
        txtMarca = new JTextField(30);
        txtPreco = new JTextField(30);
        txtQuantidade = new JTextField(30);
        cbCategoria = new JComboBox<>(new String[]{"","Comida", "Bebida", "Limpeza","Eletrônicos", "Roupas"});
        cbLocalizacao = new JComboBox<>(new String[]{"","Corredor 1","Corredor 2", "Corredor 3","Corredor 4"});
        cbUnidade = new JComboBox<>(new String[]{"","Unidade", "Kg"});
        lblNome = new JLabel("Nome:");
        lblMarca = new JLabel("Marca:");
        lblPreco = new JLabel("Preço:");
        lblQuantidade = new JLabel("Quantidade:");
        lblUnidade = new JLabel("Unidade:");
        lblCategoria = new JLabel("Categoria:");
        lblLocalizacao = new JLabel("Localização:");
        lblTELA = new JLabel("Tela de Cadastro de Produto");

        // Configurando a caixa de texto para o nome
        txtNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtNome.setPreferredSize(new Dimension(200, 20));
        txtNome.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtNome.setHorizontalAlignment(SwingConstants.LEADING);
        txtNome.setBackground(new Color(17, 3, 117));
        txtNome.setForeground(Color.WHITE);
        txtNome.setCaretColor(Color.WHITE);

        // Configurando a caixa de texto para a marca
        txtMarca.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtMarca.setSize(new Dimension(150,20));
        txtMarca.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtMarca.setHorizontalAlignment(SwingConstants.LEADING);
        txtMarca.setBackground(new Color(17, 3, 117));
        txtMarca.setForeground(Color.WHITE);
        txtMarca.setCaretColor(Color.WHITE);

        // Configurando a caixa de texto para o preço
        txtPreco.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtPreco.setPreferredSize(new Dimension(150, 20));
        txtPreco.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtPreco.setHorizontalAlignment(SwingConstants.LEADING);
        txtPreco.setBackground(new Color(17, 3, 117));
        txtPreco.setForeground(Color.WHITE);
        txtPreco.setCaretColor(Color.WHITE);

        // Configurando a caixa de texto para a quantidade
        txtQuantidade.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtQuantidade.setSize(new Dimension(150, 20));
        txtQuantidade.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtQuantidade.setHorizontalAlignment(SwingConstants.LEADING);
        txtQuantidade.setBackground(new Color(17, 3, 117));
        txtQuantidade.setForeground(Color.WHITE);
        txtQuantidade.setCaretColor(Color.WHITE);

        // Configurando a lista suspensa para unidade
        cbUnidade.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        cbUnidade.setSize(new Dimension(150, 20));
        cbUnidade.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        cbUnidade.setBackground(new Color(17, 3, 117));
        cbUnidade.setForeground(Color.WHITE);
        ((JLabel)cbUnidade.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        // Configurando a lista suspensa para categoria
        cbCategoria.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        cbCategoria.setPreferredSize(new Dimension(150, 20));
        cbCategoria.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        cbCategoria.setBackground(new Color(17, 3, 117));
        cbCategoria.setForeground(Color.WHITE);
        ((JLabel)cbCategoria.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        // Configurando a lista suspensa para localização
        cbLocalizacao.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        cbLocalizacao.setPreferredSize(new Dimension(150, 20));
        cbLocalizacao.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        cbLocalizacao.setBackground(new Color(17, 3, 117));
        cbLocalizacao.setForeground(Color.WHITE);
        ((JLabel)cbLocalizacao.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        // Configurando o lblTELA
        lblTELA.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
        lblTELA.setForeground(Color.WHITE);
        lblTELA.setHorizontalAlignment(SwingConstants.CENTER);

        // Configurando o lbllocalizacao
        lblLocalizacao.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblLocalizacao.setForeground(Color.white);
        lblLocalizacao.setHorizontalAlignment(SwingConstants.LEADING);

        // Configurando lblCategoria
        lblCategoria.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblCategoria.setForeground(Color.WHITE);
        lblCategoria.setHorizontalAlignment(SwingConstants.LEADING);
        
        // Configurando lblUnidade
        lblUnidade.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblUnidade.setForeground(Color.WHITE);
        lblUnidade.setHorizontalAlignment(SwingConstants.LEADING);

        // Configurando lblQuantidade
        lblQuantidade.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblQuantidade.setForeground(Color.WHITE);
        lblQuantidade.setHorizontalAlignment(SwingConstants.LEADING);

        // Configurando lblPreco
        lblPreco.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblPreco.setForeground(Color.WHITE);
        lblPreco.setHorizontalAlignment(SwingConstants.LEADING);
        
        // Configurando lblMarca
        lblMarca.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblMarca.setForeground(Color.WHITE);
        lblMarca.setHorizontalAlignment(SwingConstants.LEADING);
        
        // Configurando lblNome
        lblNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblNome.setForeground(Color.WHITE);
        lblNome.setHorizontalAlignment(SwingConstants.LEADING);

        // Configurando o btnCadastrar
        btnCadastrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        btnCadastrar.setPreferredSize(new Dimension(100, 50));
        btnCadastrar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        btnCadastrar.addActionListener(this);

        // Configurando o btnVoltar
        btnVoltar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        btnVoltar.setPreferredSize(new Dimension(100, 50)); 
        btnVoltar.addActionListener(this);

        // Configurando o layout
        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        // Configurando a posição dos botões
        JPanel painelBtn = new JPanel(new BorderLayout());
        painelBtn.setBackground(new Color(17, 3, 117));
        painelBtn.add(btnCadastrar, BorderLayout.EAST);
        painelBtn.add(btnVoltar, BorderLayout.WEST);
        // Configurando o painel de campos
        JPanel painelCampos = new JPanel(new GridLayout(7, 2, 10, 25));
        painelCampos.setPreferredSize(new Dimension(300, 300));
        painelCampos.setBackground(new Color(17, 3, 117));
        painelCampos.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        painelCampos.add(lblNome);
        painelCampos.add(txtNome);
        painelCampos.add(lblMarca);
        painelCampos.add(txtMarca);
        painelCampos.add(lblPreco);
        painelCampos.add(txtPreco);
        painelCampos.add(lblQuantidade);
        painelCampos.add(txtQuantidade);
        painelCampos.add(lblUnidade);
        painelCampos.add(cbUnidade);
        painelCampos.add(lblCategoria);
        painelCampos.add(cbCategoria);
        painelCampos.add(lblLocalizacao);
        painelCampos.add(cbLocalizacao);
        //Configurando o painel de texto do inicio
        JPanel painelTexto = new JPanel(new BorderLayout());
        painelTexto.setBackground(new Color(17, 3, 117));
        painelTexto.add(lblTELA, BorderLayout.CENTER);
        painelTexto.setPreferredSize(new Dimension(400, 100));
        // Adicionando os painéis ao container
        caixa.add(painelTexto, BorderLayout.NORTH);
        caixa.add(painelCampos, BorderLayout.CENTER);
        caixa.add(painelBtn, BorderLayout.SOUTH);
        
        // Configurando o fundo da janela
        caixa.setBackground(new Color(240, 245, 255));
        // Configurando o tamanho da janela
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setTitle("Tela de Cadastro");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastrar) {
            // Lógica para cadastrar o produto
            Connection conn = null;
            ConexãoBD cn = new ConexãoBD();
            try {
                if (txtPreco.getText().isEmpty() || txtQuantidade.getText().isEmpty() ) {
                    txtPreco.setText("0.0");
                    txtQuantidade.setText("0");
                }
                conn = cn.conectar();
                Produto produto = new Produto(txtNome.getText(),(String) cbCategoria.getSelectedItem(),(String) cbLocalizacao.getSelectedItem());
                produto.setMarca(txtMarca.getText());
                produto.setUnidade_medida((String) cbUnidade.getSelectedItem());
                produto.setPreco(Double.parseDouble(txtPreco.getText()));
                produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
                // Inserir o produto no banco de dados
                produto.inserir(conn);
                JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                // Limpar os campos após o cadastro
                txtNome.setText("");
                txtMarca.setText("");
                txtPreco.setText("");
                txtQuantidade.setText("");
                cbUnidade.setSelectedIndex(0);
                cbCategoria.setSelectedIndex(0);
                cbLocalizacao.setSelectedIndex(0);
            } catch (java.sql.SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnVoltar) {
            // Lógica para voltar à tela inicial
            TelaInicial tela = new TelaInicial();
            dispose(); // Fecha a tela de cadastro
        }


}
}