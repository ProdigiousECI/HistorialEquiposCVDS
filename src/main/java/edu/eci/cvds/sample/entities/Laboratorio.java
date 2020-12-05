/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.entities;

import java.io.Serializable;
import java.util.ArrayList;
import edu.eci.cvds.sample.entities.Equipo;
/**
 *
 * @author Andres Davila
 */
public class Laboratorio implements Serializable{
    
    private int id;
    private String nombre;
    private String departamento;
    private String activo;
    //pendiente por implementar
    private ArrayList<Equipo> equipos;
    
    public Laboratorio (int id,String nombre, String departamento) {
        this.id = id;
        this.nombre=nombre;
        this.departamento = departamento;
        activo="si";
     } 
    public Laboratorio(){}

    public int getIdlaboratorio() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public void setIdlaboratorio(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    @Override
    public String toString() {
        return "Laboratorio{" + "id=" + id +", nombre="+ nombre+", departamento=" + departamento +", activo="+ activo + '}'; /*", equipo=" + equipo +*/
    }
    
}
