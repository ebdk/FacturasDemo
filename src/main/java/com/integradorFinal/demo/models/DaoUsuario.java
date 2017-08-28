package com.integradorFinal.demo.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface DaoUsuario extends CrudRepository<Usuario, Long> {
	
	public List<Usuario> findByuser(String user);
	
}
