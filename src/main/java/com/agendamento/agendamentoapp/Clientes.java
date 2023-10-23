package com.agendamento.agendamentoapp;

/**
 * Represents a client with various personal information such as name, address, and blood type.
 * Provides getters and setters for all fields and overrides the toString method to display client information.
 */
public class Clientes {
    private int id;
    private String nome;
    private String naturalidade;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String sexo;
    private String tipoSanguineo;
    private String senha;

   

    // Construtor
    public Clientes(int id, String nome, String naturalidade, String cpf, String dataNascimento, String endereco, String bairro, String cidade, String estado, String sexo, String tipoSanguineo, String senha) {
        this.id = id;
        this.nome = nome;
        this.naturalidade = naturalidade;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.sexo = sexo;
        this.tipoSanguineo = tipoSanguineo;
        this.senha = senha;
    }

    // Getters e Setters para todos os campos
 public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    // Sobrescrevendo o método toString para exibir informações do cliente
    @Override
    public String toString() {
        return "Cliente: " + nome +
               "\nID: " + id +
               "\nNaturalidade: " + naturalidade +
               "\nCPF: " + cpf +
               "\nData de Nascimento: " + dataNascimento +
               "\nEndereço: " + endereco +
               "\nBairro: " + bairro +
               "\nCidade: " + cidade +
               "\nEstado: " + estado +
               "\nSexo: " + sexo +
               "\nTipo Sanguíneo: " + tipoSanguineo;
    }
}
