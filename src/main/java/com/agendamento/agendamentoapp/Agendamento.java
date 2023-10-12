package com.agendamento.agendamentoapp;
public class Agendamento {
    
    public class agendamento {
    
    private String id;
    private String profissional;
    private String serviços;
    private String parte; //parte do corpo
    private String data;
    private String horario;
    private String status;
    private String atendente;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProfissional() {
        return profissional;
    }
    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }
    public String getServiços() {
        return serviços;
    }
    public void setServiços(String serviços) {
        this.serviços = serviços;
    }
    public String getParte() {
        return parte;
    }
    public void setParte(String parte) {
        this.parte = parte;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getAtendente() {
        return atendente;
    }
    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    }
}