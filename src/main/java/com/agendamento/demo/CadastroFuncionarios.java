package com.agendamento.demo;
import java.util.ArrayList;
import java.util.Scanner;

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

                    if (!validarSenha(senha)) {
                        System.out.println("A senha não atende aos critérios mínimos de segurança.");
                        continue; // Volte ao início do loop para que o usuário insira novamente.
                    }                    

                    // A senha é válida, continue com o processamento.


                    Funcionarios novoFuncionario = new Funcionarios(nome, registroProfissional, cpf, cnpj, endereco, uf, cidade, bairro, celular, email, senha);
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

    // Função para validar CNPJ
    public static boolean validarCNPJ(String cnpj) {
        return false;
        // Implemente a validação do CNPJ aqui (usando regex, verificando dígitos, etc.)
        // Retorne true se o CNPJ for válido, caso contrário, retorne false.
    }
    public static boolean validarRegistroProfissional(String registroProfissional) {
        // Remova caracteres especiais, como "-", "/" e espaços em branco
        String registroLimpo = registroProfissional.replaceAll("[\\-\\//\\s]", "");
    
        // Verifique se o registroProfissional limpo tem o formato desejado
        if (registroLimpo.matches("[A-Z0-9]+")) {
            return true; // Registro profissional válido
        } else {
            return false; // Registro profissional inválido
        }
    }
    public static boolean validarSenha(String senha) {
        // Verifique se a senha tem pelo menos 8 caracteres
        if (senha.length() < 8) {
            return false;
        }
    
        // Verifique se a senha contém pelo menos uma letra maiúscula
        if (!senha.matches(".*[A-Z].*")) {
            return false;
        }
    
        // Verifique se a senha contém pelo menos uma letra minúscula
        if (!senha.matches(".*[a-z].*")) {
            return false;
        }
    
        // Verifique se a senha contém pelo menos um caractere especial
        if (!senha.matches(".*[!@#$%^&*()].*")) {
            return false;
        }
    
        return true; // Senha atende a todos os critérios
    }
    
    
}

