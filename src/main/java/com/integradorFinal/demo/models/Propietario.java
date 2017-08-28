package com.integradorFinal.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "propietario")

public class Propietario {

	//ATTIRBUTES
	@Id
	@GeneratedValue
	private Long idPropietario;
	
	@OneToMany(mappedBy = "propietario")
	private List<Orden> facturas;
	
	private int dni;
	private String apellidoYNombre;
	private int telefono;
	private String direccion;
	
	//CONSTRUCTORS
	public Propietario(int dni, String apellidoYNombre, int telefono, String direccion) {
		super();
		this.dni = dni;
		this.apellidoYNombre = apellidoYNombre;
		this.telefono = telefono;
		this.direccion = direccion;
		facturas = new ArrayList<Orden>();
	}
	public Propietario() {
		super();
		facturas = new ArrayList<Orden>();
	}
	
	//GETTERS AND SETTERS
	public Long getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(Long idPropietario) {
		this.idPropietario = idPropietario;
	}
	public List<Orden> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Orden> facturas) {
		this.facturas = facturas;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getApellidoYNombre() {
		return apellidoYNombre;
	}
	public void setApellidoYNombre(String apellidoYNombre) {
		this.apellidoYNombre = apellidoYNombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
