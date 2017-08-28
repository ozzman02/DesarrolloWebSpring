package com.novellius.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.novellius.pojo.Admin;
import com.novellius.pojo.AdminRowMapper;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao {
	
	private static final String SAVE_ADMIN = "insert into Admin (nombre, cargo, fechaCreacion) "
			+ "values (:nombre, :cargo, :fechaCreacion)" ;
	
	private static final String FIND_ALL_ADMINS = "select * from Admin";
	
	private static final String FIND_ADMIN_BY_ID = "select * from Admin where idAd=:idAd";
	
	private static final String FIND_ADMIN_BY_NAME = "select * from Admin where nombre like :nombre"; 
	
	private static final String UPDATE_ADMIN = "update Admin set nombre=:nombre, cargo=:cargo, fechaCreacion=:fechaCreacion"
			+ " where idAd=:idAd";
	
	private static final String DELETE_ADMIN = "delete from Admin where idAd=:idAd";
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public boolean save(Admin admin) {
		
//		MapSqlParameterSource paramMap = new MapSqlParameterSource();
//		paramMap.addValue("nombre", admin.getNombre());
//		paramMap.addValue("cargo", admin.getCargo());
//		paramMap.addValue("fechaCreacion", admin.getFechaCreacion());
		
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		
		return jdbcTemplate.update(SAVE_ADMIN, paramMap) == 1;
		
	}

	public List<Admin> findAll() {
		return jdbcTemplate.query(FIND_ALL_ADMINS, new AdminRowMapper());
	}

	public Admin findById(int id) {
		//return (Admin) jdbcTemplate.query(FIND_BY_ID, new MapSqlParameterSource("idAd", id), new AdminRowMapper());
		return jdbcTemplate.queryForObject(FIND_ADMIN_BY_ID, new MapSqlParameterSource("idAd", id), new AdminRowMapper());
	}

	public List<Admin> findByNombre(String nombre) {
		return jdbcTemplate.query(FIND_ADMIN_BY_NAME, new MapSqlParameterSource("nombre", "%" + nombre + "%"), new AdminRowMapper());
	}

	public boolean update(Admin admin) {
		return jdbcTemplate.update(UPDATE_ADMIN, new BeanPropertySqlParameterSource(admin)) == 1;
	}

	public boolean delete(int idAd) {
		return jdbcTemplate.update(DELETE_ADMIN, new MapSqlParameterSource("idAd", idAd)) == 1;
	}

	@Transactional
	public int[] saveAll(List<Admin> admins) {
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(admins.toArray());
		return jdbcTemplate.batchUpdate(SAVE_ADMIN, batchArgs);
	}

}
