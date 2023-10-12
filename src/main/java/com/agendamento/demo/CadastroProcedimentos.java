package com.agendamento.demo;

import java.util.ArrayList;
import java.util.Scanner;

class Procedimento {
    private String nome;
    private String descricao;
    private double preco;

    public Procedimento(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nDescrição: " + descricao + "\nPreço: R$" + preco;
    }
}

public class CadastroProcedimentos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Procedimento> procedimentos = new ArrayList<>();

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Procedimento");
            System.out.println("2 - Listar Procedimentos Cadastrados");
            System.out.println("3 - Excluir Procedimento");
            System.out.println("4 - Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do procedimento:");
                    scanner.nextLine();
                    String nome = scanner.nextLine().trim(); //A função .trim retira os espaços deixados em branco antes e/ou depois do que for preenchido no campo
                    
                    //Verificando se o campo obrigatório foi deixado em branco
                    if (nome.isEmpty()) {
                        System.out.println("O nome não pode estar em branco. Tente novamente.");
                        break;
                    }

                    System.out.println("Digite a descrição do procedimento (Opcional):");
                    String descricao = scanner.nextLine().trim();

                    System.out.println("Digite o preço do procedimento:");
                    double preco = scanner.nextDouble();

                    Procedimento novoProcedimento = new Procedimento(nome, descricao, preco);
                    procedimentos.add(novoProcedimento);
                    System.out.println("Procedimento cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Procedimentos cadastrados:");

                    // Loop "for" que percorre a lista de procedimentos. Ele inicia com i igual a zero e percorre até que i seja menor do que o número de procedimentos na lista.
                    for (int i = 0; i < procedimentos.size(); i++) {
                        System.out.println("Procedimento " + (i + 1) + ":");
                        System.out.println(procedimentos.get(i));
                        System.out.println("------------");
                    }
                    break;

                case 3:
                    if (procedimentos.isEmpty()) {
                        System.out.println("Nenhum procedimento cadastrado.");
                    } else {
                        System.out.println("Digite o número do procedimento que deseja excluir:");
                        int numeroProcedimento = scanner.nextInt();
                        if (numeroProcedimento >= 1 && numeroProcedimento <= procedimentos.size()) {
                            procedimentos.remove(numeroProcedimento - 1);
                            System.out.println("Procedimento removido com sucesso.");
                        } else {
                            System.out.println("Número de procedimento inválido.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
