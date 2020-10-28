<<<<<<< HEAD
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

	
	
	


=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.entities;
import java.util.Date;

/**
 *
 * @author javie
 */
public class Novedad {
    public Novedad (int id , Date fecha , String titulo, User responsable, String detalle, Equipo equipo, Elemento Elemento)
    {
        
    }
>>>>>>> 39689a414c4f5b223abccbfd7190a5a6283917b4
}
