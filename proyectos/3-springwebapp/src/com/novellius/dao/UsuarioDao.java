package com.novellius.dao;

import java.util.List;

import com.novellius.pojo.Usuario;

public interface UsuarioDao {

	Usuario findByUsername(String usuario);
	
	void save(Usuario usuario);
	
	List<Usuario> findAll();
	
}
