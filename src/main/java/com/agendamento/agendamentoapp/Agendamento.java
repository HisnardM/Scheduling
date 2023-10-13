package com.agendamento.agendamentoapp;
import java.time.LocalDateTime;

public class Agendamento {
    private static int proximoId = 1;
    private int id;
    private LocalDateTime dataHora;
    private String status;
    private Funcionarios funcionario;
    private AreasCorpo areaCorpo;
    private Procedimento procedimento;
    private Clientes clientes;

    public Agendamento(LocalDateTime dataHora, Funcionarios funcionario, AreasCorpo areaCorpo, Procedimento procedimento, Clientes clientes) {
        this.id = proximoId++;
        this.dataHora = dataHora;
        this.status = "marcado";
        this.funcionario = funcionario;
        this.areaCorpo = areaCorpo;
        this.procedimento = procedimento;
        this.clientes = clientes;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public AreasCorpo getAreaCorpo() {
        return areaCorpo;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public Clientes getClientes(){
        return clientes;
    }
}