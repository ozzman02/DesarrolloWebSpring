package com.novellius.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.dao.UsuarioDao;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
}
