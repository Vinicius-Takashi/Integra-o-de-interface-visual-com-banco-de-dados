package com.example;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class TelaAtualizarProduto extends JFrame implements ActionListener {
    // Botões
    private BtnPersonalizado btnAtualizar;
    private BtnPersonalizado btnVoltar;
    private BtnPersonalizado btnBuscar;
    // Campos de texto
    private JTextField txtIdBuscado;
    private JTextField txtNome;
    private JTextField txtQuantidade;
    private JTextField txtPreco;
    private JTextField txtMarca;
    //Listas suspensas
    private JComboBox<String> cbCategoria;
    private JComboBox<String> cbLocalizacao;
    private JComboBox<String> cbUnidade;
    // Rótulos
    private JLabel lblIdBuscado;
    private JLabel lblNome;
    private JLabel lblQuantidade;
    private JLabel lblPreco;
    private JLabel lblMarca;
    private JLabel lblCategoria;
    private JLabel lblLocalizacao;
    private JLabel lblUnidade;

    public TelaAtualizarProduto(){
        super("Tela de Atualização de Produto");
        //inicializando os componentes
        btnAtualizar = new BtnPersonalizado("Atualizar");
        btnVoltar = new BtnPersonalizado("Voltar");
        btnBuscar = new BtnPersonalizado("Buscar");
        txtIdBuscado = new JTextField(20);
        txtNome = new JTextField(20);
        txtQuantidade = new JTextField(20);
        txtPreco = new JTextField(20);
        txtMarca = new JTextField(20);
        lblIdBuscado = new JLabel("ID do Produto a ser Atualizado:");
        lblNome = new JLabel("Nome:");
        lblQuantidade = new JLabel("Quantidade:");
        lblPreco = new JLabel("Preço:");
        lblMarca = new JLabel("Marca:");
        lblCategoria = new JLabel("Categoria:");
        lblLocalizacao = new JLabel("Localização:");
        lblUnidade = new JLabel("Unidade:");
        cbCategoria = new JComboBox<>(new String[]{"","Comida", "Bebida", "Limpeza","Eletrônicos"});
        cbLocalizacao = new JComboBox<>(new String[]{"","Corredor 1","Corredor 2", "Corredor 3","Corredor 4"});
        cbUnidade = new JComboBox<>(new String[]{"","Unidade", "Kg"});

        // Configurando a fonte dos rótulos
        lblIdBuscado.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblIdBuscado.setForeground(Color.WHITE);
        lblNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblNome.setForeground(Color.WHITE);
        lblQuantidade.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblQuantidade.setForeground(Color.WHITE);
        lblPreco.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblPreco.setForeground(Color.WHITE);
        lblMarca.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblMarca.setForeground(Color.WHITE);
        lblCategoria.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblCategoria.setForeground(Color.WHITE);
        lblLocalizacao.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblLocalizacao.setForeground(Color.WHITE);
        lblUnidade.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblUnidade.setForeground(Color.WHITE);

        // Configurando a fonte dos campos de texto
        txtIdBuscado.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtIdBuscado.setSize(new Dimension(200, 20));
        txtIdBuscado.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtIdBuscado.setHorizontalAlignment(SwingConstants.LEADING);
        txtIdBuscado.setBackground(new Color(17, 3, 117));
        txtIdBuscado.setForeground(Color.WHITE);
        txtNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtNome.setSize(new Dimension(200, 20));
        txtNome.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtNome.setHorizontalAlignment(SwingConstants.LEADING);
        txtNome.setBackground(new Color(17, 3, 117));
        txtNome.setForeground(Color.WHITE);
        txtQuantidade.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtQuantidade.setSize(new Dimension(200, 20));
        txtQuantidade.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtQuantidade.setHorizontalAlignment(SwingConstants.LEADING);
        txtQuantidade.setBackground(new Color(17, 3, 117));
        txtQuantidade.setForeground(Color.WHITE);
        txtPreco.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtPreco.setSize(new Dimension(200, 20));
        txtPreco.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtPreco.setHorizontalAlignment(SwingConstants.LEADING);
        txtPreco.setBackground(new Color(17, 3, 117));
        txtPreco.setForeground(Color.WHITE);
        txtMarca.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtMarca.setSize(new Dimension(200, 20));
        txtMarca.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtMarca.setHorizontalAlignment(SwingConstants.LEADING);
        txtMarca.setBackground(new Color(17, 3, 117));
        txtMarca.setForeground(Color.WHITE);
        txtIdBuscado.setCaretColor(Color.WHITE);
        txtNome.setCaretColor(Color.WHITE);
        txtQuantidade.setCaretColor(Color.WHITE);
        txtPreco.setCaretColor(Color.WHITE);
        txtMarca.setCaretColor(Color.WHITE);

        // Configurando a lista suspensa para unidade
        cbUnidade.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        cbUnidade.setSize(new Dimension(150, 20));
        cbUnidade.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        cbUnidade.setBackground(new Color(17, 3, 117));
        cbUnidade.setForeground(Color.WHITE);
        ((JLabel)cbUnidade.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        // Configurando a lista suspensa para categoria
        cbCategoria.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        cbCategoria.setSize(new Dimension(150, 20));
        cbCategoria.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        cbCategoria.setBackground(new Color(17, 3, 117));
        cbCategoria.setForeground(Color.WHITE);
        ((JLabel)cbCategoria.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        // Configurando a lista suspensa para localização
        cbLocalizacao.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        cbLocalizacao.setSize(new Dimension(150, 20));
        cbLocalizacao.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        cbLocalizacao.setBackground(new Color(17, 3, 117));
        cbLocalizacao.setForeground(Color.WHITE);
        ((JLabel)cbLocalizacao.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        // Adicionando o Listener nos botões
        btnAtualizar.addActionListener(this);
        btnVoltar.addActionListener(this);
        btnBuscar.addActionListener(this);

        // Configurando o layout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.add(lblIdBuscado, BorderLayout.WEST);
        painelSuperior.add(txtIdBuscado, BorderLayout.CENTER);
        painelSuperior.add(btnBuscar, BorderLayout.EAST);
        painelSuperior.setBackground(new Color(17, 3, 117));
        JPanel painelCampos = new JPanel(new GridLayout(7, 2, 10, 10));
        painelCampos.add(lblNome);
        painelCampos.add(txtNome);
        painelCampos.add(lblMarca);
        painelCampos.add(txtMarca);
        painelCampos.add(lblQuantidade);
        painelCampos.add(txtQuantidade);
        painelCampos.add(lblPreco);
        painelCampos.add(txtPreco);
        painelCampos.add(lblUnidade);
        painelCampos.add(cbUnidade);
        painelCampos.add(lblCategoria);
        painelCampos.add(cbCategoria);
        painelCampos.add(lblLocalizacao);
        painelCampos.add(cbLocalizacao);
        painelCampos.setBackground(new Color(17, 3, 117));
        JPanel painelBtn = new JPanel(new BorderLayout());
        painelBtn.add(btnAtualizar, BorderLayout.EAST);
        painelBtn.add(btnVoltar, BorderLayout.WEST);
        painelBtn.setBackground(new Color(17, 3, 117));
        container.add(painelSuperior, BorderLayout.NORTH);
        container.add(painelCampos, BorderLayout.CENTER);
        container.add(painelBtn, BorderLayout.SOUTH);

        // Configurando o fundo da janela
        container.setBackground(new Color(17, 3, 117));

        // Configurando a janela
        setTitle("Tela de Atualização de Produto");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a janela, mas não encerra o programa
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAtualizar) {
            // Lógica para atualizar o produto
            Connection conn = null;
            ConexãoBD cn = new ConexãoBD();
            try {
                conn = cn.conectar();
                Produto produto = new Produto(Integer.parseInt(txtIdBuscado.getText())); 
                produto.alterar(conn,
                        txtNome.getText(),
                        txtMarca.getText(),
                        Integer.parseInt(txtQuantidade.getText()),
                        Double.parseDouble(txtPreco.getText()),
                        cbUnidade.getSelectedItem().toString(),
                        cbCategoria.getSelectedItem().toString(),
                        cbLocalizacao.getSelectedItem().toString()
                        );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar o produto: " + ex.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
        } else if (e.getSource() == btnVoltar) {
            // Volta para a tela inicial
            TelaInicial telaInicial = new TelaInicial();
            this.dispose();
        } else if (e.getSource() == btnBuscar) {
            // Lógica para buscar o produto pelo ID
            Connection conn = null; // Aqui você deve obter a conexão com o banco de dados
            ConexãoBD cn = new ConexãoBD();
            try {
                conn = cn.conectar();
                Produto produto = new Produto(Integer.parseInt(txtIdBuscado.getText()));
                produto.carregar(conn);
                JOptionPane.showMessageDialog(null, produto.exibirInformacoes());
            } catch (Exception w) {
            }
        }
    }
}
