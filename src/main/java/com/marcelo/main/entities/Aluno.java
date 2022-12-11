package com.marcelo.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "alunos")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String matricula;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Double mensalidade;
	
	

	public Aluno() {
	
	}

	public Aluno(String matricula, String nome, Double mensalidade) {
		this.matricula = matricula;
		this.nome = nome;
		this.mensalidade = mensalidade;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public long getId() {
		return id;
	}
	
}
