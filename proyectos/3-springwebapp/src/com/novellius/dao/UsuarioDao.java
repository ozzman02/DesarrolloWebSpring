package com.novellius.dao;

import com.novellius.pojo.Usuario;

public interface UsuarioDao {

	Usuario findByUsername(String usuario);
	
}
