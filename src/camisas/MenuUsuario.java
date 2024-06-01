package camisas;

import java.util.List;
import java.util.Scanner;

public class MenuUsuario {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Remover Produto");
            System.out.println("3. Buscar Produto");
            System.out.println("4. Listar Todos Produtos");
            System.out.println("5. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Tamanho: ");
                    String tamanho = scanner.nextLine();
                    System.out.print("Cor: ");
                    String cor = scanner.nextLine();
                    System.out.print("Tipo (cavada, manga curta, manga longa): ");
                    String tipo = scanner.nextLine();
                    cadastro.adicionar(new Produto(nome, tamanho, cor, tipo));
                    break;

                case 2:
                    System.out.print("Nome do Produto a remover: ");
                    nome = scanner.nextLine();
                    cadastro.remover(nome);
                    break;

                case 3:
                    System.out.print("Nome do Produto a buscar: ");
                    nome = scanner.nextLine();
                    Produto produto = cadastro.buscar(nome);
                    if (produto != null) {
                        System.out.println(produto);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    List<Produto> produtos = cadastro.listar();
                    for (Produto p : produtos) {
                        System.out.println(p);
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    cadastro.closeConnection();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }
}
