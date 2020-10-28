package edu.eci.cvds.sample.entities;

import java.io.Serializable;
import java.sql.Date;


public class Novedad implements Serializable{
	
	private int id;
	private Date fecha;
	private String titulo;
	private String detalle;
	
	
	public Novedad() {
		
	}
	public void Novedad(int id, Date fecha, String titulo,String detalle){
		
		this.id=id;
		this.fecha=fecha;
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
}
