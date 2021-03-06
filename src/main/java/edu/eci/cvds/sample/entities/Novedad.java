
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

	public Novedad(String titulo,String detalle,User user,Elemento elemento){
		
		
		this.titulo=titulo;
		this.detalle=detalle;
		this.user=user;
		this.elemento=elemento;
		
	}
public Novedad(String titulo,String detalle,User user,Equipo equipo){
		
		
		this.titulo=titulo;
		this.detalle=detalle;
		this.user=user;
		this.equipo=equipo;
		
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
		return "Novedad [id=" + id + ", fecha=" + fecha + ", equipo=" + equipo + ", user=" + user + ", elemento=" + elemento +", titulo=" + titulo + ", detalle=" + detalle + "]";
	}
	

}
