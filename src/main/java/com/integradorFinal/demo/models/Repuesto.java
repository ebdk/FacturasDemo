package com.integradorFinal.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "repuesto")

public class Repuesto {

	//ATTIRBUTES
	@Id
	@GeneratedValue
	private Long idRespuesto;
	
	@OneToMany(mappedBy = "repuesto")
	private List<Item> itemsQueFigura;
	
	private String descripcion;
	private int costo;
	private String urlImg;
	
	//CONSTRUCTORS
	public Repuesto(String descripcion, int costo, String urlImg) {
		super();
		this.descripcion = descripcion;
		this.costo = costo;
		this.urlImg = urlImg;
		itemsQueFigura = new ArrayList<Item>();
	}
	public Repuesto() {
		super();
		itemsQueFigura = new ArrayList<Item>();
	}
	
	//GETTERS AND SETTERS
	public Long getIdRespuesto() {
		return idRespuesto;
	}
	public void setIdRespuesto(Long idRespuesto) {
		this.idRespuesto = idRespuesto;
	}
	public List<Item> getItemsQueFigura() {
		return itemsQueFigura;
	}
	public void setItemsQueFigura(List<Item> itemsQueFigura) {
		this.itemsQueFigura = itemsQueFigura;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	//METHODS
	public void addItem(Item item){
		this.getItemsQueFigura().add(item);
	}
}
