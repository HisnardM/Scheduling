package com.agendamento.agendamentoapp;

public class Procedimento {
    private String nome;
    private String descricao;
    private double preco;

    public Procedimento(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Descrição: " + descricao + ", Preço: R$" + preco;
    }
}
