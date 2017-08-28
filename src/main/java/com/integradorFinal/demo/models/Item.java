package com.integradorFinal.demo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")

public class Item {

	//ATTIRBUTES
	@Id
	@GeneratedValue
	private Long idItem;
	
	@ManyToOne()
	@JoinColumn(name = "orden_id")
	private Orden orden;
	
	@ManyToOne()
	@JoinColumn(name = "repuesto_id")
	private Repuesto repuesto;
	
	private float cantidad;
	private float tiempoEnInstalar;
	public static float precioPorMinuto = 7;
	
	//CONSTRUCTORS
	public Item(Orden orden, Repuesto repuesto, float cantidad, float tiempoEnInstalar) {
		super();
		this.orden = orden;
		this.repuesto = repuesto;
		this.cantidad = cantidad;
		this.tiempoEnInstalar = tiempoEnInstalar;
	}
	public Item() {
		super();
	}
	
	//GETTERS AND SETTERS
	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	public Orden getOrden() {
		return orden;
	}
	public void setOrden(Orden orden) {
		this.orden = orden;
		orden.addItem(this);
	}
	public Repuesto getRepuesto() {
		return repuesto;
	}
	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
		//repuesto.addItem(this);
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getTiempoEnInstalar() {
		return tiempoEnInstalar;
	}
	public void setTiempoEnInstalar(float tiempoEnInstalar) {
		this.tiempoEnInstalar = tiempoEnInstalar;
	}
	
	//METHODS
	public float getPrecioTotal(){
		return this.precioPorInstalacion() + this.precioPorRepuestos();
	}
	
	public float precioPorRepuestos(){
		return this.getRepuesto().getCosto() * this.getCantidad();
	}
	
	public float precioPorInstalacion(){
		return this.getTiempoEnInstalar() * precioPorMinuto;
	}
	
	
	

}
