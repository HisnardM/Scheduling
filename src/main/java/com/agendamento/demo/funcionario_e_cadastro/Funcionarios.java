package com.agendamento.demo.funcionario_e_cadastro;

public class Funcionarios {
    private String nome; //obg
    private String registroProfissional; //opc
    private String cpf; //obg
    private String cnpj; //opc
    private String endereco; //obg
    private String uf; //obg
    private String cidade; //obg
    private String bairro; //obg
    private String celular; //obg
    private String email; // obg
    private String senha; // obg
  
    

    // Construtor
    public Funcionarios(String nome, String registroProfissional, String cpf, String cnpj,
                       String endereco, String uf, String cidade, String bairro, String celular, String email,  String senha) {
        this.nome = nome;
        this.registroProfissional = registroProfissional;
        this.cpf = cpf;
        this.cnpj = cnpj; //ele sera opcional
        this.endereco = endereco;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters para todos os campos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Sobrescrevendo o método toString para exibir informações do funcionário
    @Override
    public String toString() {
        return "Funcionário: " + nome +
        (registroProfissional != null ? "\nRegistro Profissional: " + registroProfissional : "") + // Exibir Registro Profissional apenas se não for nulo
               "\nCPF: " + cpf +
               (cnpj != null ? "\nCNPJ: " + cnpj : "") + // Exibir CNPJ apenas se não for nulo
               "\nEndereço: " + endereco +
               "\nUF: " + uf +
               "\nCidade: " + cidade +
               "\nBairro: " + bairro +
               "\nCelular: " + celular + 
               "\nEmail: " + email + 
               "\nSenha: " + senha + "\n";
    }
}
