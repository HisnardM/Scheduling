package com.agendamento.agendamentoapp;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class CadastroCliente {
    public static void main(String[] args) {
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Cadastro de Clientes");
            System.out.println("1. Cadastrar novo cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de novo cliente");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Naturalidade: ");
                    String naturalidade = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    if (!validarCPF(cpf)) {
                        System.out.println("CPF inválido. Por favor, insira um CPF válido.");
                        continue;
                    }

                    System.out.print("Data de Nascimento: ");
                    String dataNascimento = scanner.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    System.out.print("Bairro: ");
                    String bairro = scanner.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();

                    System.out.print("Sexo: ");
                    String sexo = scanner.nextLine();

                    System.out.print("Tipo Sanguíneo: ");
                    String tipoSanguineo = scanner.nextLine();

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    if (!validarSenha(senha)) {
                        System.out.println("Senha inválida. A senha deve conter uma letra maiúscula, uma letra minúscula e um caractere especial.");
                        continue;
                    }

                    int novoId = listaClientes.size() + 1;
                    Clientes novoCliente = new Clientes(novoId, nome, naturalidade, cpf, dataNascimento, endereco, bairro, cidade, estado, sexo, tipoSanguineo, senha);
                    listaClientes.add(novoCliente);

                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Lista de Clientes:");
                    for (Clientes cliente : listaClientes) {
                        System.out.println(cliente);
                    }
                    break;

                case 3:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    // Método de validação de CPF
    public static boolean validarCPF(String cpf) {
        String regex = "^[0-9]{11}$";
        return Pattern.matches(regex, cpf);
    }

    // Método de validação de senha
    public static boolean validarSenha(String senha) {
        // A senha deve conter pelo menos uma letra maiúscula, uma letra minúscula e um caractere especial
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return Pattern.matches(regex, senha);
    }
    
}
