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
    private User user;
    public Equipo (int id, String nombre, User user)
    {
        this.id = id;
        this.nombre = nombre;
        this.user = user; 
    }
    public Equipo ()
    {
        
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", nombre=" + nombre + ", user=" + user +'}';
    }
}
