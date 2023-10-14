package com.agendamento.agendamentoapp;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroCliente {
    public static void main(String[] args) {
        ArrayList<Clientes> listaCliente = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Cadastro de Cliente");
            System.out.println("1. Cadastrar novo Cliente");
            System.out.println("2. Listar Cliente");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de novo cliente");
                    System.out.print("numProntuario");
                    String numProntuario = scanner.nextLine();

                    
                    System.out.print("nome");
                    String nome = scanner.nextLine();

                     System.out.print(" tipoPessoa");
                    String tipoPessoa = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    if (!validarCPF(cpf)) {
                        System.out.println("CPF inválido. Por favor, insira um CPF válido.");
                        continue; // Volte ao início do loop para que o usuário insira novamente.
                    }

                   System.out.print("dataNascimento ");
                    String dataNascimento = scanner.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    System.out.print("Bairro: ");
                    String bairro = scanner.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.print(" Estado");
                    String estado = scanner.nextLine();

                    System.out.print("sexo");
                    String sexo= scanner.nextLine();

                    System.out.print("Tipo Sanguineo");
                    String tipoSanguineo = scanner.nextLine();




                    

                    Clientes novoCliente = new Cliente(numProntuario, nome, tipoPessoa, cpf, dataNascimento, bairro, cidade, estado, sexo, tipoSanguineo);
                    listaCliente.add(novoCliente);

                    System.out.println(" Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Lista de Cliente:");
                    for (Clientes cliente : listaCliente) {
                        System.out.println(Cliente);
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
// Função para validar CPF
public static boolean validarCPF(String cpf) {
    // Remove qualquer caractere não numérico do CPF
    cpf = cpf.replaceAll("[^0-9]", "");

    // Verifica se o CPF tem 11 dígitos
    if (cpf.length() != 11) {
        return false;
    }

    // Calcula os dígitos verificadores
    int soma = 0;
    for (int i = 0; i < 9; i++) {
        soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
    }
    int primeiroDigito = 11 - (soma % 11);
    if (primeiroDigito >= 10) {
        primeiroDigito = 0;
    }

    soma = 0;
    for (int i = 0; i < 10; i++) {
        soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
    }
    int segundoDigito = 11 - (soma % 11);
    if (segundoDigito >= 10) {
        segundoDigito = 0;
    }

    // Verifica se os dígitos verificadores são iguais aos dígitos do CPF
    return (Character.getNumericValue(cpf.charAt(9)) == primeiroDigito &&
            Character.getNumericValue(cpf.charAt(10)) == segundoDigito);
}

}
