package com.agendamento.agendamentoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroCorpo {
    private List<String> partesCorpo;
    private AreasCorpo areasCorpo; // Adicione uma instância de AreasCorpo

    public CadastroCorpo() {
        partesCorpo = new ArrayList<>();
        areasCorpo = new AreasCorpo(); // Inicialize a instância de AreasCorpo
    }

    public void adicionarParteCorpo(String parte) {
        partesCorpo.add(parte);
    }

    public void removerParteCorpo(String parte) {
        partesCorpo.remove(parte);
    }

    public List<String> getPartesCorpo() {
        // Combine as partes pré-definidas de AreasCorpo com as partes adicionadas
        List<String> todasAsPartes = new ArrayList<>(areasCorpo.getAreasCorpo());
        todasAsPartes.addAll(partesCorpo);
        return todasAsPartes;
    }

    public static void main(String[] args) {
        CadastroCorpo cadastro = new CadastroCorpo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Cadastro de Partes do Corpo");
            System.out.println("1. Adicionar nova parte do corpo");
            System.out.println("2. Listar partes do corpo");
            System.out.println("3. Remover parte do corpo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da parte do corpo: ");
                    String parte = scanner.nextLine();
                    cadastro.adicionarParteCorpo(parte);
                    System.out.println("Parte do corpo adicionada com sucesso!");
                    break;

                case 2:
                    List<String> partes = cadastro.getPartesCorpo();
                    System.out.println("Lista de Partes do Corpo:");
                    for (String parteCorpo : partes) {
                        System.out.println(parteCorpo);
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome da parte do corpo a ser removida: ");
                    String parteRemover = scanner.nextLine();
                    cadastro.removerParteCorpo(parteRemover);
                    System.out.println("Parte do corpo removida com sucesso!");
                    break;

                case 4:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
