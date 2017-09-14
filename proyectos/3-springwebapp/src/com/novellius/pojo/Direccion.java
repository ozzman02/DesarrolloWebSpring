package com.novellius.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Direccion")
public class Direccion {
	
	@Id
	@GeneratedValue
	private int idDir;
	
	private String calle;
	
	private String cp;
	
	public Direccion() {}
	
	public Direccion(String calle, String cp) {
		this.calle = calle;
		this.cp = cp;
	}

	public int getIdDir() {
		return idDir;
	}

	public void setIdDir(int idDir) {
		this.idDir = idDir;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}
	
}
