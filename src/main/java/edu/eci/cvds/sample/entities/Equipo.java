/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.entities;

import java.io.Serializable;

/**
 *
 * @author javie
 */
public class Equipo implements Serializable{

    private int id;
    private String nombre;
    private User iduser = null;
    
    public Equipo(){
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
        return "Equipo{" + "id=" + id + ", nombre=" + nombre + '}'; /*", iduser=" + iduser +*/
    }
}
