package com.agendamento.agendamentoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
* Esta classe representa um registro de procedimentos, que permite ao usuário cadastrar, listar e excluir procedimentos.
* Contém métodos para cadastrar, listar e deletar procedimentos, bem como um método principal para execução do programa.
* A classe também possui uma lista de procedimentos predefinidos que são adicionados ao registro na inicialização.
*/
/**
 * Classe responsável pelo cadastro, listagem e exclusão de procedimentos.
 * 
 * @version 1.0
 * @since 2023-10-22
 */
public class CadastroProcedimentos {
    private List<Procedimento> procedimentos;

    /**
     * Construtor da classe. Adiciona os procedimentos predefinidos na lista de procedimentos.
     */
    public CadastroProcedimentos() {
        procedimentos = new ArrayList<>();
        procedimentos.addAll(Procedimentos.getProcedimentosPredefinidos()); // Adiciona os procedimentos predefinidos
    }

    /**
     * Método responsável por cadastrar um novo procedimento.
     */
    public void cadastrarProcedimento() {
        try (Scanner scanner = new Scanner(System.in)) {
            Logger logger = Logger.getLogger(CadastroProcedimentos.class.getName());

            logger.info("Nome do procedimento: ");
            String nome = scanner.nextLine();

            logger.info("Descrição do procedimento: ");
            String descricao = scanner.nextLine();

            logger.info("Preço do procedimento: ");

            if (scanner.hasNextDouble()) {
                double preco = scanner.nextDouble();
                scanner.nextLine(); // Limpa o buffer do scanner

                Procedimento novoProcedimento = new Procedimento(nome, descricao, preco);
                procedimentos.add(novoProcedimento);

                logger.info("Procedimento cadastrado com sucesso!");
            } else {
                logger.info("Preço inválido. O procedimento não foi cadastrado.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }
    }

    /**
     * Método responsável por listar todos os procedimentos cadastrados.
     */
    public void listarProcedimentos() {
        Logger logger = Logger.getLogger(CadastroProcedimentos.class.getName());

        logger.info("Lista de Procedimentos:");
        for (int i = 0; i < procedimentos.size(); i++) {
            Procedimento procedimento = procedimentos.get(i);
            logger.info(String.format("ID: %d", i));
            logger.info(String.format("Nome: %s", procedimento.getNome()));
            logger.info(String.format("Descrição: %s", procedimento.getDescricao()));
            logger.info(String.format("Preço: %.2f", procedimento.getPreco()));
            logger.info("");
        }
    }

    /**
     * Método responsável por excluir um procedimento a partir do seu ID.
     * 
     * @param id ID do procedimento a ser excluído.
     */
    public void excluirProcedimento(int id) {
        Logger logger = Logger.getLogger(CadastroProcedimentos.class.getName());

        if (id >= 0 && id < procedimentos.size()) {
            procedimentos.remove(id);
            logger.info("Procedimento removido com sucesso!");
        } else {
            logger.info("ID de procedimento inválido. Não foi possível remover o procedimento.");
        }
    }

    /**
     * Método principal da classe. Responsável por exibir o menu de opções e chamar os métodos correspondentes.
     * 
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        CadastroProcedimentos cadastro = new CadastroProcedimentos();
        Scanner scanner = new Scanner(System.in);

        boolean sair = false; // Added end condition to the loop

        while (!sair) {
            Logger logger = Logger.getLogger(CadastroProcedimentos.class.getName());

            logger.info("Cadastro de Procedimentos");
            logger.info("1. Cadastrar novo procedimento");
            logger.info("2. Listar procedimentos");
            logger.info("3. Excluir procedimento");
            logger.info("4. Sair");
            logger.info("Escolha uma opção: ");

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
                        logger.info("Digite o ID do procedimento a ser excluído: ");
                        if (scanner.hasNextInt()) {
                            int idExcluir = scanner.nextInt();
                            scanner.nextLine(); // Limpa o buffer do scanner
                            cadastro.excluirProcedimento(idExcluir);
                        } else {
                            logger.info("ID inválido. O procedimento não foi removido.");
                            scanner.nextLine(); // Limpa o buffer do scanner
                        }
                        break;

                    case 4:
                        logger.info("Saindo do programa.");
                        scanner.close();
                        sair = true; // Added end condition to the loop
                        break;

                    default:
                        logger.info("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            } else {
                logger.info("Opção inválida. Por favor, escolha uma opção válida.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }
    }
}

