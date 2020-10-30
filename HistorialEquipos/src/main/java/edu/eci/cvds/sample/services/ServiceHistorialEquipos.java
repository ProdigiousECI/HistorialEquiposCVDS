/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services;



import java.util.ArrayList;

import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;

/**
 *
 * @author javier
 */
public interface ServiceHistorialEquipos {
	
	public abstract void registrarNovedad(Novedad n) throws ExcepcionServiceHistorialEquipos;
	public abstract ArrayList<Novedad> consultarNovedadporElemento(int i) throws ExcepcionServiceHistorialEquipos;
	public abstract ArrayList<Novedad> consultarNovedadporEquipo(int i) throws ExcepcionServiceHistorialEquipos;
    
}
