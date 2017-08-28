package com.integradorFinal.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")

public class Usuario {

	//ATTIRBUTES
	@Id
	@GeneratedValue
	private Long idUsuario;
	
	@OneToMany(mappedBy = "usuario")
	private List<Orden> ordenesHechas;
	
	private String user;
	private String pass;
	
	//CONSTRUCTORS
	public Usuario(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	public Usuario() {
		super();
	}
	
	//GETTERS AND SETTERS
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
