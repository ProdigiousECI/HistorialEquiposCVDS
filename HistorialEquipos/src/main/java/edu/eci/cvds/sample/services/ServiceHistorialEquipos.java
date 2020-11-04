/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services;

import edu.eci.cvds.sample.entities.Equipo;
import java.util.ArrayList;

/**
 *
 * @author javier
 */
public interface ServiceHistorialEquipos {
    public abstract void registrarEquipo(Equipo equip)throws ExcepcionServiceHistorialEquipos;
    
    public abstract Equipo consultarEquipo(int id) throws ExcepcionServiceHistorialEquipos;
    
    public abstract ArrayList<Equipo> consultarEquipos() throws ExcepcionServiceHistorialEquipos;
    
}
