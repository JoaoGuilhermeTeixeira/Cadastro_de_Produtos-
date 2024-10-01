package com.joaoguilhermeteixeira.javapoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Produto { //Criei uma Classe para os Produtos
    String nome;
    String descricao;
    String disponivel;
    double valor;

    // Construtor
    public Produto(String nome, String descricao, String disponivel, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.disponivel = disponivel;
        this.valor = valor;
    }

    // Método para exibir informações do produto "nome" e "valor" em ordem crescente
    public void mostrarProduto() {
        System.out.println("Nome do Produto: " + nome);
        System.out.println("--------------------");
        System.out.println("Valor do Produto: " + valor);
        System.out.println();
        System.out.println();// Linha em branco para separar os produtos
    }
}

class Cadastro { //classe para ser feito o cadastro dos produtos
    Scanner input = new Scanner(System.in);
    ArrayList<Produto> listaDeProdutos = new ArrayList<>();

    public void cadastrarProduto() {
        System.out.print("Digite o nome do Produto: ");
        String nomeProduto = input.nextLine();

        System.out.print("Digite Uma Descrição para o Produto: ");
        String descricaoProduto = input.nextLine();

        System.out.print("Digite o valor do Produto: ");
        double valorProduto = input.nextDouble();

        String disponivel = escolherDisponibilidade();

        // Criar um novo produto e adicioná-lo à lista em ordem crescente
        Produto novoProduto = new Produto(nomeProduto, descricaoProduto, disponivel, valorProduto);
        listaDeProdutos.add(novoProduto);

        System.out.println("Seu produto foi registrado com sucesso!");
        System.out.println();
    }

    public String escolherDisponibilidade() { //Opções pora Produto disponivel
        int opcao;
        do {
            System.out.println("Escolha uma opção de Disponibilidade do Produto:");
            System.out.println("1 - PRODUTO DISPONÍVEL");
            System.out.println("2 - PRODUTO INDISPONÍVEL");

            opcao = input.nextInt();

            if (opcao == 1) {
                return "Disponível";
            } else if (opcao == 2) {
                return "Indisponível";
            } else {
                System.out.println("Opção inválida. Tente novamente."); //vai retornar para opções
            }
        } while (opcao != 1 && opcao != 2);
        return "";
    }

    public void exibirProdutos() { // metodo para exibir os dados da lista em ordem crescente
        System.out.println("Lista de Produtos:");
        System.out.println();
        Collections.sort(listaDeProdutos, Comparator.comparingDouble(produto -> produto.valor));
        for (Produto produto : listaDeProdutos) {
            produto.mostrarProduto();
        }
    }

    public void fecharScanner() {
        input.close();
    }
}

class Scratch {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        char continuar;
        do {
            cadastro.cadastrarProduto(); // Cadastra um novo produto
            cadastro.exibirProdutos();
            System.out.print("Deseja cadastrar outro produto ? Digite `s` para Sim / `n` para Não (s/n): ");
            System.out.println();
            continuar = cadastro.input.next().charAt(0);
            cadastro.input.nextLine(); // Limpa o buffer
        } while (continuar == 's' || continuar == 'S');
        System.out.println();

        cadastro.exibirProdutos(); // Exibe todos os produtos cadastrados
        cadastro.fecharScanner(); // Fecha o scanner
    }
}
