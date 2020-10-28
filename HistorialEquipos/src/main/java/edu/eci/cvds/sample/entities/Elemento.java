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

    private Equipo equipo;
    private String tipo;
    private String nombre;
    private int id;

    public Elemento(int id, String nombre, String tipo, Equipo equipo)
    {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.equipo = equipo;
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
        return "Elemento{" + "id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", equipo=" + equipo +'}';
    }
}
