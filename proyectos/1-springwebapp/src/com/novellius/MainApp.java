package com.novellius;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.novellius.dao.AdminDao;
import com.novellius.pojo.Admin;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		
		//Admin administrador = (Admin) applicationContext.getBean("admin");
		//administrador.imprimirDireccion();
		//System.out.println(administrador);
		
		AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
		
		Admin admin = new Admin();
		Admin admin2 = new Admin();
		Admin admin3 = new Admin();
		
		admin.setCargo("Gerente");
		admin.setNombre("Oscar");
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		
		admin2.setCargo("Gerente");
		admin2.setNombre("Nathy");
		admin2.setFechaCreacion(new Timestamp(new Date().getTime()));
		
		admin3.setCargo("Gerente");
		admin3.setNombre("Angello");
		admin3.setFechaCreacion(new Timestamp(new Date().getTime()));
		
		
		try {
			
			adminDao.save(admin);
			
			adminDao.save(admin2);
			
			adminDao.save(admin3);
			
			List<Admin> admins = adminDao.findAll();
			
			for (Admin administrator : admins) {
				System.out.println(administrator);
			}
			
			System.out.println(adminDao.findById(1));
			
			System.out.println(adminDao.findById(3));
			
			System.out.println(adminDao.findByNombre("a").toString());
				
		} catch (CannotGetJdbcConnectionException ex ) {
			ex.printStackTrace();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext) applicationContext).close();
	}

}
