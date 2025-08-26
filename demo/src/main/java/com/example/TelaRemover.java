package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class TelaRemover extends JFrame implements ActionListener{
    // botão buscar
    private BtnPersonalizado botaoBuscar;
    // botão remover
    private BtnPersonalizado botaoRemover;
    // botão voltar
    private BtnPersonalizado botaoVoltar;
    // campo de texto para o ID do produto
    private JTextField campoIdProduto;
    // rótulo para o ID do produto
    private JLabel rotuloIdProduto;
    // rotulo para o titulo da tela
    private JLabel rotuloTitulo;

    public TelaRemover() {
        // inicializando os componentes da tela
        botaoBuscar = new BtnPersonalizado("Buscar");
        botaoRemover = new BtnPersonalizado("Remover");
        botaoVoltar = new BtnPersonalizado("Voltar");
        campoIdProduto = new JTextField(10);
        rotuloIdProduto = new JLabel("ID do Produto:");
        rotuloTitulo = new JLabel("Remover Produto");

        // Adicionando listeners aos botões
        botaoBuscar.addActionListener(this);
        botaoRemover.addActionListener(this);
        botaoVoltar.addActionListener(this);
        
        // configurando o titulo
        rotuloTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        rotuloTitulo.setBackground(new Color(17, 3, 117));
        rotuloTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        rotuloTitulo.setForeground(Color.WHITE);

        // configurando o campo de texto
        campoIdProduto.setToolTipText("Digite o ID do produto a ser removido");
        campoIdProduto.setHorizontalAlignment(JTextField.CENTER);
        campoIdProduto.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        campoIdProduto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        campoIdProduto.setBackground(new Color(17, 3, 117));
        campoIdProduto.setForeground(Color.WHITE);
        campoIdProduto.setCaretColor(Color.WHITE);

        // configurando os rótulos
        rotuloIdProduto.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        rotuloIdProduto.setForeground(Color.WHITE);
        rotuloIdProduto.setHorizontalAlignment(SwingConstants.CENTER);
        rotuloIdProduto.setBackground(new Color(17, 3, 117));

        // configurando o layout da tela
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JPanel painelCentro = new JPanel(new BorderLayout(10,10));
        painelCentro.setBackground(new Color(17, 3, 117));
        painelCentro.setSize(400,100);
        JPanel painelSul = new JPanel(new BorderLayout(20,20));
        painelSul.setBackground(new Color(17, 3, 117));
        painelSul.setSize(400,100);
        JPanel painelTitulo = new JPanel(new BorderLayout());
        painelTitulo.setBackground(new Color(17, 3, 117));
        painelTitulo.add(rotuloTitulo, BorderLayout.CENTER);
        painelTitulo.setBackground(new Color(17, 3, 117));
        painelTitulo.setSize(400,100);
        painelCentro.add(rotuloIdProduto, BorderLayout.WEST);
        painelCentro.add(campoIdProduto, BorderLayout.CENTER);
        painelCentro.add(botaoBuscar, BorderLayout.EAST);
        painelSul.add(botaoRemover, BorderLayout.EAST);
        painelSul.add(botaoVoltar, BorderLayout.WEST);
        container.add(painelTitulo, BorderLayout.NORTH);
        container.add(painelCentro, BorderLayout.CENTER);
        container.add(painelSul, BorderLayout.SOUTH);
        
        // configurando o fundo da janela
        container.setBackground(new Color(17, 3, 117));

        // configurando a janela
        setLayout(new FlowLayout());
        setTitle("Tela de Remoção de Produto");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == botaoBuscar) {
            // Ação para buscar o produto pelo ID
            if (campoIdProduto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ID de produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                //Busca no banco de dados pelo ID
                Connection conn = null; 
                ConexãoBD cn = new ConexãoBD();
                try {
                    conn = cn.conectar();
                    Produto produto = new Produto(Integer.parseInt(campoIdProduto.getText()));
                    produto.carregar(conn);
                    JOptionPane.showMessageDialog(null, produto.exibirInformacoes());
                } catch (Exception w) {
                // TODO: handle exception
            }
            }
        } else if (e.getSource() == botaoRemover) {
            // Ação para remover o produto
            if (campoIdProduto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ID de produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                // Aqui você pode adicionar a lógica para remover o produto do banco de dados
                Connection conn = null;
                ConexãoBD cn = new ConexãoBD();
                try {
                    conn = cn.conectar();
                    Produto produto = new Produto(Integer.parseInt(campoIdProduto.getText()));
                    produto.excluir(conn);
                    JOptionPane.showMessageDialog(this, "Produto removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao remover o produto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == botaoVoltar) {
            TelaInicial telaInicial = new TelaInicial();
            dispose(); // Fecha a tela atual
        }
    }
}
