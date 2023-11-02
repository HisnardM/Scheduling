package com.agendamento.crm.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class AreasCorpo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(nullable = false)
 private String nome;
 
 
 public Long getId() {
     return id;
 }
public void setId(int id) {
	this.id = (long) id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public void setId(Long id2) {
	// TODO Auto-generated method stub
	
}
}
