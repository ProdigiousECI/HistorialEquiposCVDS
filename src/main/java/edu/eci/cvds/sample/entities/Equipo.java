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

    private int id;
    private String nombre;
    private int idlaboratorio;

    private User iduser = null;
    
    public Equipo(){
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
        return "Equipo{" + "id=" + id + ", nombre=" + nombre + ", idlaboratorio=" + idlaboratorio + '}'; /*", iduser=" + iduser +*/
    }

    public User getUser() {
        return iduser;
    }

    public void setUser(User user) {
        this.iduser = iduser;
    }
    
 
}