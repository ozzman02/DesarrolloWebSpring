package com.novellius.dao;

import java.util.List;

import com.novellius.pojo.Admin;

public interface AdminDao {
	
	void save(Admin admin);
	
	List<Admin> findAll();
	
	Admin findById(int id);
	
	List<Admin> findByNombre(String nombre);
	
	void update(Admin admin);
	
	void delete(Admin admin);
	
}
