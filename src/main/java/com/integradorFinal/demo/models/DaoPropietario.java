package com.integradorFinal.demo.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface DaoPropietario extends CrudRepository<Propietario, Long> {
	
	public List<Propietario> findByapellidoYNombre(String apellidoYNombre);

}
