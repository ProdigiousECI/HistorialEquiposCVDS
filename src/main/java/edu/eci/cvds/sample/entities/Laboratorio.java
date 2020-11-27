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
    
    private int idlaboratorio;
    private String departamento;
    private String activo;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    //pendiente por implementar
    private ArrayList<Equipo> equipos;
    
    public Laboratorio (int idlaboratorio, String departamento, String activo) {
        this.idlaboratorio = idlaboratorio;
        this.departamento = departamento;
        this.activo=activo;
     } 
    public Laboratorio(){}

    public int getIdlaboratorio() {
        return idlaboratorio;
    }

    public void setIdlaboratorio(int idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
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
        return "Laboratorio{" + "id=" + idlaboratorio + ", departamento=" + departamento + '}'; /*", equipo=" + equipo +*/
    }
    
}
