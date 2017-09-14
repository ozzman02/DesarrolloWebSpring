package com.novellius.dao;

import java.util.List;

import com.novellius.pojo.Admin;
import com.novellius.pojo.Direccion;

public interface DireccionDao {
	
	void save(Direccion direccion);
	
	List<Direccion> findAll(Admin admin);
	
}
