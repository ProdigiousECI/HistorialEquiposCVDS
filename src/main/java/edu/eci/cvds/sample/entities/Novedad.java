
package edu.eci.cvds.sample.entities;

import java.io.Serializable;
import java.sql.Date;


public class Novedad implements Serializable{
	
	private int id;
	private Date fecha;
	private String titulo;
	private String detalle;
	private Equipo equipo;
	private Elemento elemento;
	private User user;
	private boolean eliminar;

	
	
	public boolean isEliminar() {
		return eliminar;
	}






	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}






	public Novedad() {
	
	}
		

	
	


	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Novedad(int id, Date fecha, String titulo,String detalle){
		
		this.id=id;
		this.fecha=fecha;
		this.titulo=titulo;
		this.detalle=detalle;
		
	}
	
	public Novedad(String titulo,String detalle){
		
	
		this.titulo=titulo;
		this.detalle=detalle;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Novedad [id=" + id + ", fecha=" + fecha + ", elemento=" + elemento +", titulo=" + titulo + ", detalle=" + detalle + "]";
	}
	

}
