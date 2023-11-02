package com.agendamento.crm.model;

import java.time.LocalDateTime;

public class Agendamento {
    private int id;
    private LocalDateTime dataHora;
    private String status;
    private Funcionarios funcionario;
    private AreasCorpo areaCorpo;
    private Procedimentos procedimento;
    private Clientes clientes;

  
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

    public Procedimentos getProcedimento() {
        return procedimento;
    }

    public Clientes getClientes(){
        return clientes;
    }
}