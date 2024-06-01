package camisas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private Connection connection;

    public Cadastro() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/seu-banco-de-dados", "seu-usuario", "sua-senha");
            if (connection != null) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso.");
            } else {
                System.err.println("Falha ao estabelecer conexão com o banco de dados. Connection object is null.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Falha ao estabelecer conexão com o banco de dados.");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão com o banco de dados fechada.");
            } catch (SQLException e) {
                System.err.println("Falha ao fechar a conexão com o banco de dados.");
                e.printStackTrace();
            }
        }
    }

    public void adicionar(Produto produto) {
        if (connection == null) {
            System.err.println("Erro: conexão com o banco de dados não foi estabelecida.");
            return;
        }

        String sql = "INSERT INTO produtos (pro_nomeProduto, pro_tamanho, pro_cor, pro_tipo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getTamanho());
            stmt.setString(3, produto.getCor());
            stmt.setString(4, produto.getTipo());
            stmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produto.");
            e.printStackTrace();
        }
    }

    public void remover(String nome) {
        if (connection == null) {
            System.err.println("Erro: conexão com o banco de dados não foi estabelecida.");
            return;
        }

        String sql = "DELETE FROM produtos WHERE pro_nomeProduto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto removido com sucesso.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao remover produto.");
            e.printStackTrace();
        }
    }

    public Produto buscar(String nome) {
        if (connection == null) {
            System.err.println("Erro: conexão com o banco de dados não foi estabelecida.");
            return null;
        }

        String sql = "SELECT * FROM produtos WHERE pro_nomeProduto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Produto(
                    rs.getString("pro_nomeProduto"),
                    rs.getString("pro_tamanho"),
                    rs.getString("pro_cor"),
                    rs.getString("pro_tipo")
                );
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto.");
            e.printStackTrace();
        }
        return null;
    }

    public List<Produto> listar() {
        if (connection == null) {
            System.err.println("Erro: conexão com o banco de dados não foi estabelecida.");
            return new ArrayList<>();
        }

        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                produtos.add(new Produto(
                    rs.getString("pro_nomeProduto"),
                    rs.getString("pro_tamanho"),
                    rs.getString("pro_cor"),
                    rs.getString("pro_tipo")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos.");
            e.printStackTrace();
        }
        return produtos;
    }
}
