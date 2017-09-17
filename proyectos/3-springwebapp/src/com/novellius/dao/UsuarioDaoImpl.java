package com.novellius.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.novellius.pojo.Usuario;

@Transactional
@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Usuario findByUsername(String usuario) {
		Criteria criteria = getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("usuario", usuario));
		return (Usuario) criteria.uniqueResult();
	}

}
