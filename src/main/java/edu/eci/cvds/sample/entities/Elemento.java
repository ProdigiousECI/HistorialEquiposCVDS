/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.entities;

import java.io.Serializable;

/**
 *
 * @author javier
 */
public class Elemento implements Serializable{

    //private Equipo equipo;
    private String tipo;
    private String nombre;
    private String activo;
    private String baja;
    private int id;
    private Equipo equipo = null;

    public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getBaja() {
		return baja;
	}

	public void setBaja(String baja) {
		this.baja = baja;
	}

	public Elemento()
    {
        
    }
    
    public Elemento(String nombre, String tipo) /*, Equipo equipo*/
    {
        this.nombre = nombre;
        this.tipo = tipo;
        //this.equipo = equipo;
    }
    
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Elemento{" + "id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", activo=" + activo + ", baja=" + baja + ", equipo=" + equipo + '}';
    }
}
