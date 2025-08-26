package com.example;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

    public class TelaConsultaEstoque extends JFrame implements ActionListener {
    // botão
    private BtnPersonalizado btnVoltar;
    private BtnPersonalizado btnFiltrar;
    // campo de texto para filtrar produtos
    private JTextField txtNome;
    private JTextField txtMarca;
    // lista suspensa para categorias
    private JComboBox<String> cmbCategoria;
    // lista suspensa para localização
    private JComboBox<String> cmbLocalizacao;
    // tabela para exibir os produtos
    private JTable tabelaProdutos;
    // modelo da tabela
    private DefaultTableModel modeloTabela;
    //rotulos
    private JLabel lblNome;
    private JLabel lblMarca;
    private JLabel lblCategoria;
    private JLabel lblLocalizacao;
    // rótulo para o título da tela
    private JLabel lblTitulo;

    public TelaConsultaEstoque() {
        super("Tela de Consulta de Estoque");

        // Inicializando os componentes
        btnVoltar = new BtnPersonalizado("Voltar");
        btnFiltrar = new BtnPersonalizado("Filtrar");
        txtNome = new JTextField(15);
        txtMarca = new JTextField(15);
        cmbCategoria = new JComboBox<>(new String[]{"","Comida", "Eletrônicos", "Limpeza","Bebidas","Roupas"});
        cmbLocalizacao = new JComboBox<>(new String[]{"","Corredor 1", "Corredor 2", "Corredor 3","Corredor 4"});
        lblNome = new JLabel("Nome:");
        lblMarca = new JLabel("Marca:");
        lblCategoria = new JLabel("Categoria:");
        lblLocalizacao = new JLabel("Localização:");
        lblTitulo = new JLabel("Consulta de Estoque");
        modeloTabela = new DefaultTableModel(new String[]{"ID", "Nome", "Marca","Preço", "Quantidade" ,"Unidade de medida","Categoria", "Localização"}, 0);
        tabelaProdutos = new JTable(modeloTabela);
        // adicionando o listener aos botões
        btnFiltrar.addActionListener(this);
        btnVoltar.addActionListener(this);
        // Configurando o campo de texto para o nome
        txtNome.setToolTipText("Digite o nome do produto para filtrar");
        txtNome.setPreferredSize(new Dimension(150, 25));
        txtNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtNome.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtNome.setBackground(new Color(17, 3, 117));
        txtNome.setForeground(Color.WHITE);
        txtNome.setHorizontalAlignment(SwingConstants.LEADING);
        txtNome.setCaretColor(Color.WHITE);
        // Configurando o campo de texto para a marca
        txtMarca.setToolTipText("Digite a marca do produto para filtrar");
        txtMarca.setPreferredSize(new Dimension(150, 25));
        txtMarca.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        txtMarca.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        txtMarca.setBackground(new Color(17, 3, 117));
        txtMarca.setForeground(Color.WHITE);
        txtMarca.setHorizontalAlignment(SwingConstants.LEADING);
        txtMarca.setCaretColor(Color.WHITE);
        // Configurando a lista suspensa para categorias
        cmbCategoria.setToolTipText("Selecione a categoria do produto para filtrar");
        cmbCategoria.setPreferredSize(new Dimension(150, 25));
        cmbCategoria.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        cmbCategoria.setBackground(new Color(17, 3, 117));
        cmbCategoria.setForeground(Color.WHITE);
        cmbCategoria.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        // Configurando a lista suspensa para localização
        cmbLocalizacao.setToolTipText("Selecione a localização do produto para filtrar");
        cmbLocalizacao.setPreferredSize(new Dimension(150, 25));
        cmbLocalizacao.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        cmbLocalizacao.setBackground(new Color(17, 3, 117));
        cmbLocalizacao.setForeground(Color.WHITE);
        cmbLocalizacao.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        // Configurando o título
        lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        // Configurando os rótulos
        lblNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblNome.setForeground(Color.WHITE);
        lblMarca.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblMarca.setForeground(Color.WHITE);
        lblCategoria.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblCategoria.setForeground(Color.WHITE);
        lblLocalizacao.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        lblLocalizacao.setForeground(Color.WHITE);
        // Configurando a tabela
        tabelaProdutos.setModel(modeloTabela);
        tabelaProdutos.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        tabelaProdutos.setRowHeight(25);
        tabelaProdutos.setSelectionBackground(new Color(17, 3, 117));
        tabelaProdutos.setSelectionForeground(Color.WHITE);
        tabelaProdutos.setGridColor(Color.WHITE);
        tabelaProdutos.setShowGrid(true);
        tabelaProdutos.setShowVerticalLines(true);
        tabelaProdutos.setShowHorizontalLines(true);
        tabelaProdutos.setIntercellSpacing(new Dimension(1, 1));
        tabelaProdutos.setBackground(new Color(17, 3, 117));
        tabelaProdutos.setForeground(Color.WHITE);
        tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaProdutos.getTableHeader().setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        tabelaProdutos.getTableHeader().setBackground(new Color(17, 3, 117));
        tabelaProdutos.getTableHeader().setForeground(Color.WHITE);
        tabelaProdutos.getTableHeader().setReorderingAllowed(false);
        tabelaProdutos.getTableHeader().setResizingAllowed(false);

        // Configurando o layout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.setBackground(new Color(17, 3, 117));
        JPanel painelTitulo = new JPanel(new BorderLayout());
        painelTitulo.setBackground(new Color(17, 3, 117));
        JPanel painelFiltros = new JPanel(new GridLayout(2, 4, 10, 10));
        painelFiltros.setBackground(new Color(17, 3, 117));
        JPanel painelFbtn = new JPanel(new FlowLayout());
        painelFbtn.setBackground(new Color(17, 3, 117));
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(new Color(17, 3, 117));
        scrollPane.setForeground(Color.WHITE);
        JPanel painelTabela = new JPanel(new BorderLayout());
        painelTabela.setBackground(new Color(17, 3, 117));
        painelTabela.add(scrollPane, BorderLayout.CENTER);
        JPanel painelBtn = new JPanel(new BorderLayout());
        painelBtn.setBackground(new Color(17, 3, 117));
        painelBtn.add(btnVoltar, BorderLayout.WEST);
        painelTitulo.add(lblTitulo, BorderLayout.CENTER);
        painelFiltros.add(lblNome);
        painelFiltros.add(txtNome);
        painelFiltros.add(lblMarca);
        painelFiltros.add(txtMarca);
        painelFiltros.add(lblCategoria);
        painelFiltros.add(cmbCategoria);
        painelFiltros.add(lblLocalizacao);
        painelFiltros.add(cmbLocalizacao);
        painelFbtn.add(painelFiltros);
        painelFbtn.add(btnFiltrar);
        painelSuperior.add(painelTitulo, BorderLayout.NORTH);
        painelSuperior.add(painelFbtn, BorderLayout.CENTER);
        container.add(painelSuperior, BorderLayout.NORTH);
        container.add(painelTabela, BorderLayout.CENTER);
        container.add(painelBtn, BorderLayout.SOUTH);

        // Configurando o fundo da janela
        container.setBackground(new Color(17, 3, 117));
        // Configurando o fundo da tabela
        tabelaProdutos.setBackground(new Color(17, 3, 117));
        tabelaProdutos.setForeground(Color.WHITE);

        // Configurando o tamanho da tabela
        tabelaProdutos.setPreferredScrollableViewportSize(new Dimension(500, 200));
        tabelaProdutos.setFillsViewportHeight(true);

        // Configurando a janela
        setSize(1100, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //Carregando os produtos na tabela
        try {
            Connection conn = new ConexãoBD().conectar();
            Produto produto = new Produto();
            List<Produto> lista = produto.carregarTodos(conn);
            atualizarTabela(lista);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }
     private void atualizarTabela(List<Produto> listaProdutos) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaProdutos.getModel();
        modelo.setRowCount(0);

        for (Produto p : listaProdutos) {
            modelo.addRow(new Object[]{
                p.getId_produto(),
                p.getNome(),
                p.getMarca(),
                p.getPreco(),
                p.getQuantidade(),
                p.getUnidade_medida(),
                p.getCategoria(),
                p.getLocalizacao(),
                

            });
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            // Volta para a tela inicial
            TelaInicial telaInicial = new TelaInicial();
            this.dispose(); // Fecha a tela de consulta
        }
        if (e.getSource() == btnFiltrar) {
            // Filtra os produtos com base nos critérios fornecidos
            try {
                Connection conn = new ConexãoBD().conectar();
                Produto produto = new Produto();
                List<Produto> listaFiltrada = produto.filtrarMult(txtNome.getText(), txtMarca.getText(), (String)cmbCategoria.getSelectedItem(), (String)cmbLocalizacao.getSelectedItem());
                atualizarTabela(listaFiltrada);
                txtNome.setText("");
                txtMarca.setText("");
                cmbCategoria.setSelectedIndex(0);
                cmbLocalizacao.setSelectedIndex(0);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao filtrar produtos", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    

}
