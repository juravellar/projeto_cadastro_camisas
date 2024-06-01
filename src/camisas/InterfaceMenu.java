package camisas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Window.Type;

public class InterfaceMenu extends JFrame {
    private Cadastro cadastro;

    public InterfaceMenu() {
        cadastro = new Cadastro();

        setTitle("Gerenciamento de Camisetas");
        setSize(414, 305);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
                panel.setLayout(null);
        
                // Botões de ação
                JButton addButton = new JButton("Adicionar Produto");
                addButton.setBounds(7, 7, 384, 47);
                addButton.setBackground(new Color(225, 247, 242));
                addButton.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
                        panel.add(addButton);
                        
                                // Ação para adicionar produto
                                addButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        JTextField nomeField = new JTextField();
                                        JTextField tamanhoField = new JTextField();
                                        JTextField corField = new JTextField();
                                        JTextField tipoField = new JTextField();
                                        Object[] message = {
                                            "Nome:", nomeField,
                                            "Tamanho:", tamanhoField,
                                            "Cor:", corField,
                                            "Tipo (cavada, manga curta, manga longa):", tipoField
                                        };
                        
                                        int option = JOptionPane.showConfirmDialog(null, message, "Adicionar Produto", JOptionPane.OK_CANCEL_OPTION);
                                        if (option == JOptionPane.OK_OPTION) {
                                            Produto produto = new Produto(
                                                nomeField.getText(),
                                                tamanhoField.getText(),
                                                corField.getText(),
                                                tipoField.getText()
                                            );
                                            cadastro.adicionar(produto);
                                        }
                                    }
                                });
        JButton removeButton = new JButton("Remover Produto");
        removeButton.setBounds(7, 61, 384, 47);
        removeButton.setBackground(new Color(225, 247, 242));
        removeButton.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        panel.add(removeButton);
        
                // Ação para remover produto
                removeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String nome = JOptionPane.showInputDialog("Nome do Produto a remover:");
                        if (nome != null && !nome.isEmpty()) {
                            cadastro.remover(nome);
                        }
                    }
                });
        JButton searchButton = new JButton("Buscar Produto");
        searchButton.setBounds(7, 115, 384, 47);
        searchButton.setBackground(new Color(225, 247, 242));
        searchButton.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        panel.add(searchButton);
        
                // Ação para buscar produto
                searchButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String nome = JOptionPane.showInputDialog("Nome do Produto a buscar:");
                        if (nome != null && !nome.isEmpty()) {
                            Produto produto = cadastro.buscar(nome);
                            if (produto != null) {
                                JOptionPane.showMessageDialog(null, produto);
                            } else {
                                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                            }
                        }
                    }
                });
        JButton listButton = new JButton("Listar Todos Produtos");
        listButton.setBounds(7, 169, 384, 47);
        listButton.setBackground(new Color(225, 247, 242));
        listButton.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        panel.add(listButton);
        
                // Ação para listar todos os produtos
                listButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        List<Produto> produtos = cadastro.listar();
                        StringBuilder sb = new StringBuilder();
                        for (Produto p : produtos) {
                            sb.append(p).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Produtos", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
        JButton exitButton = new JButton("Sair");
        exitButton.setBounds(324, 236, 67, 22);
        exitButton.setBackground(new Color(255, 210, 210));
        exitButton.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
        panel.add(exitButton);
        
                // Ação para sair do programa
                exitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cadastro.closeConnection();
                        System.exit(0);
                    }
                });

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfaceMenu().setVisible(true);
            }
        });
    }
}