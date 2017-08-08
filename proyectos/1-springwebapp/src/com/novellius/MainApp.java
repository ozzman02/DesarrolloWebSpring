package com.novellius;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.novellius.dao.AdminDao;
import com.novellius.pojo.Admin;

public class MainApp {

	private static void insertarAdmins(AdminDao adminDao) {
		
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
		
		adminDao.save(admin);
		
		adminDao.save(admin2);
		
		adminDao.save(admin3);
	}
	
	private static void mostrarTodosLosAdmin(AdminDao adminDao) {
		
		List<Admin> admins = adminDao.findAll();
		
		for (Admin administrator : admins) {
			System.out.println(administrator);
		}
	}
	
	private static void buscarAdminPorId(AdminDao adminDao, int idAd) {
		System.out.println(adminDao.findById(idAd));
	}
	
	private static void buscarAdminsPorNombre(AdminDao adminDao, String key) {
		System.out.println(adminDao.findByNombre(key).toString());
	}
	
	private static void actualizarAdmin(AdminDao adminDao, int idAd) {
		
		Admin administrador = adminDao.findById(idAd);
		administrador.setCargo("Subgerente");
		administrador.setNombre("Martin");
		
		if (adminDao.update(administrador)) {
			System.out.println("Actualizado correctamente " + administrador);
		}
	}
	
	private static void borrarAdmin(AdminDao adminDao, int idAd) {
		
		Admin administrador = adminDao.findById(idAd);
		
		if (adminDao.delete(administrador.getIdAd())) {
			System.out.println("Admin: " + administrador.getNombre() + " eliminado correctamente");
		}
	}
	
	private static void insertarBatchDeAdmins(AdminDao adminDao) {
		
		List<Admin> admins = new ArrayList<Admin>();
		
		admins.add(new Admin("Pedro", "jefe de ingenieria", new Timestamp(new Date().getTime())));
		admins.add(new Admin("Jorge", "subjefe de ingenieria", new Timestamp(new Date().getTime())));
		admins.add(new Admin("Rocio", "representante legal", new Timestamp(new Date().getTime())));
		
		int[] vals = adminDao.saveAll(admins);
		
		for (int i : vals) {
			System.out.println("Filas afectadas para la operacion: " + i);
		}
		
	}
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		
		//Admin administrador = (Admin) applicationContext.getBean("admin");
		//administrador.imprimirDireccion();
		//System.out.println(administrador);
		
		AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
		
		try {
			
			insertarAdmins(adminDao);
			
			mostrarTodosLosAdmin(adminDao);
			
			buscarAdminPorId(adminDao, 1);
			
			buscarAdminsPorNombre(adminDao, "a");
			
			actualizarAdmin(adminDao, 1);
			
			borrarAdmin(adminDao, 1);
			
			insertarBatchDeAdmins(adminDao);
			
		} catch (CannotGetJdbcConnectionException ex ) {
			ex.printStackTrace();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext) applicationContext).close();
	}

}
