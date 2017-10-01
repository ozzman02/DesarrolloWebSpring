package com.novellius.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private int idUsr;
	
	@NotEmpty(message=Constants.NOT_EMPTY)
	private String usuario;
	
	@NotEmpty(message=Constants.NOT_EMPTY)
	@Size(min=3, message=Constants.SIZE)
	private String clave;
	
	@NotEmpty(message=Constants.NOT_EMPTY)
	private String permiso;
	
	private Timestamp fechaCreacion;
	
	public int getIdUsr() {
		return idUsr;
	}
	
	public void setIdUsr(int idUsr) {
		this.idUsr = idUsr;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getPermiso() {
		return permiso;
	}
	
	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}
	
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Usuario [idUsr=" + idUsr + ", usuario=" + usuario + ", clave=" + clave + ", permiso=" + permiso
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}
	
}
