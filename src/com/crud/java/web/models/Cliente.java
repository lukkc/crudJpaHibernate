package com.crud.java.web.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="cliente")
public class Cliente {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="sobrenome")
	private String sobrenome;
	
	@Column(name="matricula")
	private String matricula;
	
	@Column(name="ativo")
	private boolean ativo;
	
	@OneToMany(mappedBy="cliente", cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private List<Preferencia> preferencias;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Preferencia> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<Preferencia> preferencias) {
		this.preferencias = preferencias;
	}

	
	
	@Override
	public String toString() {
		
		String preferenciasToJson = "";
		
		for (Preferencia preferencia: preferencias) {
			preferenciasToJson += preferencia.toString()+",";
		}
		
		return "{\n \t\"id\": " + id + ",\n \t\"nome\": " + nome + ",\n \t\"Sobrenome\": " + sobrenome + ",\n \t\"matricula\": " + matricula
				+ ",\n \t\"ativo\": " + ativo + ",\n \t\"preferencias\": [" + preferenciasToJson + "]\n}";
	}
	
}
