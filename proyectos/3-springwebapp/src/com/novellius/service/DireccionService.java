package com.novellius.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.dao.DireccionDao;
import com.novellius.pojo.Direccion;

@Service
public class DireccionService {
	
	@Autowired
	private DireccionDao direccionDao;
	
	public void save(Direccion direccion) {
		direccionDao.save(direccion);
	}

	public List<Direccion> findAll() {
		return direccionDao.findAll();
	}

}
