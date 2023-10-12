package com.agendamento.agendamentoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroProcedimentos {
    private List<Procedimento> procedimentos;

    public CadastroProcedimentos() {
        procedimentos = new ArrayList<>();
        procedimentos.addAll(Procedimentos.getProcedimentosPredefinidos()); // Adiciona os procedimentos predefinidos
    }

      public void cadastrarProcedimento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do procedimento: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição do procedimento: ");
        String descricao = scanner.nextLine();

        System.out.print("Preço do procedimento: ");

        if (scanner.hasNextDouble()) {
            double preco = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer do scanner

            Procedimento novoProcedimento = new Procedimento(nome, descricao, preco);
            procedimentos.add(novoProcedimento);

            System.out.println("Procedimento cadastrado com sucesso!");
        } else {
            System.out.println("Preço inválido. O procedimento não foi cadastrado.");
            scanner.nextLine(); // Limpa o buffer do scanner
        }
    }

    public void listarProcedimentos() {
        System.out.println("Lista de Procedimentos:");
        for (int i = 0; i < procedimentos.size(); i++) {
            Procedimento procedimento = procedimentos.get(i);
            System.out.println("ID: " + i);
            System.out.println("Nome: " + procedimento.getNome());
            System.out.println("Descrição: " + procedimento.getDescricao());
            System.out.println("Preço: " + procedimento.getPreco());
            System.out.println();
        }
    }

    public void excluirProcedimento(int id) {
        if (id >= 0 && id < procedimentos.size()) {
            procedimentos.remove(id);
            System.out.println("Procedimento removido com sucesso!");
        } else {
            System.out.println("ID de procedimento inválido. Não foi possível remover o procedimento.");
        }
    }

    public static void main(String[] args) {
        CadastroProcedimentos cadastro = new CadastroProcedimentos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Cadastro de Procedimentos");
            System.out.println("1. Cadastrar novo procedimento");
            System.out.println("2. Listar procedimentos");
            System.out.println("3. Excluir procedimento");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner

                switch (opcao) {
                    case 1:
                        cadastro.cadastrarProcedimento();
                        break;

                    case 2:
                        cadastro.listarProcedimentos();
                        break;

                    case 3:
                        System.out.print("Digite o ID do procedimento a ser excluído: ");
                        if (scanner.hasNextInt()) {
                            int idExcluir = scanner.nextInt();
                            scanner.nextLine(); // Limpa o buffer do scanner
                            cadastro.excluirProcedimento(idExcluir);
                        } else {
                            System.out.println("ID inválido. O procedimento não foi removido.");
                            scanner.nextLine(); // Limpa o buffer do scanner
                        }
                        break;

                    case 4:
                        System.out.println("Saindo do programa.");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            } else {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }
    }
}

