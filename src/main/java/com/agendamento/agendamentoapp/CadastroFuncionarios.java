package com.agendamento.agendamentoapp;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta classe fornece uma interface de linha de comando para registrar e listar funcionários.
  * Utiliza um ArrayList para armazenar os funcionários cadastrados e oferece opções para adicionar novos funcionários,
  * liste todos os funcionários e saia do programa.
  * A classe também inclui métodos auxiliares para validar números de CPF e CNPJ e força de senha.
  */
/**
 * This class represents a program for registering employees. It allows the user to add new employees to a list, 
 * list all employees in the list, and exit the program. The program validates the input for CPF, CNPJ, and password 
 * according to specific criteria. The program uses the Funcionarios class to create new employee objects and add them 
 * to the list of employees. The program also includes a function to validate CPF numbers.
 */
public class CadastroFuncionarios{
    public static void main(String[] args) {
        ArrayList<Funcionarios> listaFuncionarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Cadastro de Funcionários");
            System.out.println("1. Cadastrar novo funcionário");
            System.out.println("2. Listar funcionários");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de novo funcionário");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Registro Profissional (opcional, pressione Enter para deixar em branco): ");
                    String registroProfissional = scanner.nextLine();

                     // Verifique se o usuário deixou o Registro Profissional em branco
                    if (registroProfissional.trim().isEmpty()) {
                        registroProfissional = null;
                    } else if (!validarRegistroProfissional(registroProfissional)) {
                        System.out.println("Registro Profissional inválido. Por favor, insira um Registro Profissional                     válido.");
                        continue; // Volte ao início do loop para que o usuário insira novamente.
                    }


                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    if (!validarCPF(cpf)) {
                        System.out.println("CPF inválido. Por favor, insira um CPF válido.");
                        continue; // Volte ao início do loop para que o usuário insira novamente.
                    }

                    System.out.print("CNPJ (opcional, pressione Enter para deixar em branco): ");
                    String cnpj = scanner.nextLine();

                    // Verifique se o usuário deixou o CNPJ em branco
                    if (cnpj.trim().isEmpty()) {
                        cnpj = null;
                    } else if (!validarCNPJ(cnpj)) {
                        System.out.println("CNPJ inválido. Por favor, insira um CNPJ válido.");
                        continue; // Volte ao início do loop para que o usuário insira novamente.
                    }

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    System.out.print("UF: ");
                    String uf = scanner.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.print("Bairro: ");
                    String bairro = scanner.nextLine();

                    System.out.print("Celular: ");
                    String celular = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    System.out.print("UserName: ");
                    String userName = scanner.nextLine();

                    if (!validarSenha(senha)) {
                        System.out.println("A senha não atende aos critérios mínimos de segurança.");
                        continue; // Volte ao início do loop para que o usuário insira novamente.
                    }                    

                    // A senha é válida, continue com o processamento.


                    Funcionarios novoFuncionario = new Funcionarios(nome, registroProfissional, cpf, cnpj, endereco, uf, cidade, bairro, celular, email, senha, userName);
                    listaFuncionarios.add(novoFuncionario);

                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Lista de Funcionários:");
                    for (Funcionarios funcionario : listaFuncionarios) {
                        System.out.println(funcionario);
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
    /**
     * @param cpf
     * @return
     */
    public static boolean validarCPF(String cpf) {
        // Remove qualquer caractere não numérico do CPF
        cpf = cpf.replaceAll("\\D", "");

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

    // Função para validar CNPJ
    private static final String CNPJ_REGEX = "\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}";

    /**
     * @param cnpj
     * @return
     */
    public static boolean validarCNPJ(String cnpj) {
        // Remove caracteres especiais, como ".", "/", "-" e espaços em branco
        String cnpjLimpo = cnpj.replaceAll("[\\.\\/\\-\\s]", "");

        // Verifica se o CNPJ tem o formato desejado
        if (!cnpjLimpo.matches(CNPJ_REGEX)) {
            return false;
        }
        // Calcula os dígitos verificadores
        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            int digito = Integer.parseInt(cnpjLimpo.substring(i, i + 1));
            soma += digito * peso;
            peso = peso == 9 ? 2 : peso + 1;
        }
        int digitoVerificador1 = soma % 11 < 2 ? 0 : 11 - soma % 11;

        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            int digito = Integer.parseInt(cnpjLimpo.substring(i, i + 1));
            soma += digito * peso;
            peso = peso == 9 ? 2 : peso + 1;
        }
        int digitoVerificador2 = soma % 11 < 2 ? 0 : 11 - soma % 11;

        // Verifica se os dígitos verificadores são iguais aos dígitos do CNPJ
        return (digitoVerificador1 == Integer.parseInt(cnpjLimpo.substring(12, 13)) &&
                digitoVerificador2 == Integer.parseInt(cnpjLimpo.substring(13, 14)));
    }
    
    public static boolean validarRegistroProfissional(String registroProfissional) {
        // Remove caracteres especiais, como "-", "/" e espaços em branco
        String registroLimpo = registroProfissional.replaceAll("[\\-\\/\\s]", "");

        // Verifica se o registroProfissional limpo tem o formato desejado
        return registroLimpo.matches("[A-Z0-9]+");
    }


    public static boolean validarSenha(String senha) {
        // Verifique se a senha tem pelo menos 8 caracteres
        if (senha.length() < 8) {
            return false;
        }

        // Verifique se a senha contém pelo menos uma letra maiúscula
        return senha.matches(".*[A-Z].*") && senha.matches(".*[a-z].*") && senha.matches(".*[!@#$%^&*()].*");
    }
    
    
}

