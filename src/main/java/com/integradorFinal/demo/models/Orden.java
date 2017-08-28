package com.integradorFinal.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orden")

public class Orden {

	//ATTIRBUTES
	@Id
	@GeneratedValue
	private Long idOrden;
	
	@ManyToOne()
	@JoinColumn(name = "propietario_id")
	private Propietario propietario;
	
	@OneToMany(mappedBy = "orden")
	private List<Item> items;
	
	@ManyToOne()
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	private int numPatente;
	private String marca;
	private Date fechaIngreso;
	private String falla;
	
	//CONSTRUCTORS
	public Orden(Propietario propietario, int numPatente, String marca, Date fechaIngreso, String falla) {
		super();
		this.propietario = propietario;
		this.numPatente = numPatente;
		this.marca = marca;
		this.fechaIngreso = fechaIngreso;
		this.falla = falla;
		items = new ArrayList<Item>();
	}
	public Orden() {
		super();
		items = new ArrayList<Item>();
	}
	
	//GETTERS AND SETTERS
	public Long getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(Long idOrden) {
		this.idOrden = idOrden;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public int getNumPatente() {
		return numPatente;
	}
	public void setNumPatente(int numPatente) {
		this.numPatente = numPatente;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFalla() {
		return falla;
	}
	public void setFalla(String falla) {
		this.falla = falla;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//METHODS
	public float getPrecioFinal(){
		float precioTl = 0;
		for(Item ite:items){
			precioTl = precioTl + ite.getPrecioTotal();
		}
		return precioTl;
	}
	public void addItem(Item item){
		this.getItems().add(item);
	}
	

}
