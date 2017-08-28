package com.integradorFinal.demo.services;

import com.integradorFinal.demo.models.Orden;
import com.integradorFinal.demo.models.Repuesto;

public class Paso {
	
	//ATTIRUBTES
	private int idPaso;
	private Repuesto repuesto;
	private float cantidad;
	private float tiempoEnInstalar;
	private Orden orden;
	private static int todosLosPasos = 1;

	//CONSTRUCTORS
	public Paso() {
		super();
	}
	public Paso(Repuesto repuesto, float cantidad, float tiempoEnInstalar, Orden orden) {
		super();
		this.repuesto = repuesto;
		this.cantidad = cantidad;
		this.tiempoEnInstalar = tiempoEnInstalar;
		this.orden = orden;
	}
	//GETTERS AND SETTERS
	public float getCantidad() {
		return cantidad;
	}
	public int getIdPaso() {
		return idPaso;
	}
	public void setIdPaso(int idPaso) {
		this.idPaso = idPaso;
	}
	public static void setTodosLosPasos(int todosLosPasos) {
		Paso.todosLosPasos = todosLosPasos;
	}
	public int getId() {
		return idPaso;
	}
	public void setId(int id) {
		this.idPaso = id;
	}
	public static int getTodosLosPasos() {
		return todosLosPasos;
	}
	public void aumentarCantidad(){
		Paso.todosLosPasos = Paso.todosLosPasos++;
	}
	public Repuesto getRepuesto() {
		return repuesto;
	}
	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}
	public float getTiempoEnInstalar() {
		return tiempoEnInstalar;
	}
	public void setTiempoEnInstalar(float tiempoEnInstalar) {
		this.tiempoEnInstalar = tiempoEnInstalar;
	}
	public Orden getOrden() {
		return orden;
	}
	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
}

