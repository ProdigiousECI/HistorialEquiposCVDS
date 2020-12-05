/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.entities;

import java.io.Serializable;

/**
 *
 * @author miguel
 */
public class Equipo implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String nombre;
    private int idlaboratorio;
    private String activo;
    private Laboratorio laboratorio;

    private User iduser = null;
    
    public Equipo(){
    }
    
    
    
    
    public Laboratorio getLaboratorio() {
		return laboratorio;
	}




	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}




	public String getActivo() {
		return activo;
	}



	public void setActivo(String activo) {
		this.activo = activo;
	}



	public int getIdlaboratorio() {
		return idlaboratorio;
	}


	public void setIdlaboratorio(int idlaboratorio) {
		this.idlaboratorio = idlaboratorio;
	}


	public Equipo (int id, String nombre)
    {
        this.id = id;
        this.nombre = nombre;
        //this.iduser = iduser;
        activo="si";
    
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", nombre=" + nombre +", activo=" + activo + ", idlaboratorio=" + idlaboratorio + ", laboratorio="+laboratorio + '}'; /*", iduser=" + iduser +*/
    }

    public User getUser() {
        return iduser;
    }

    public void setUser(User user) {
        this.iduser = iduser;
    }
    
 
}
