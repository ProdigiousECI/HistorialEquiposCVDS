/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services.impl;

import java.sql.Date;

import com.google.inject.Inject;

import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;

/**
 *
 * @author javier
 */
public class ServiceHistorialEquiposImpl implements ServiceHistorialEquipos{
	
	@Inject
	private NovedadDAO novedadDAO;
	
	@Override
	   public void registrarNovedad(Novedad n) throws ExcepcionServiceHistorialEquipos {
	       try {
	           novedadDAO.RegistrarNovedad(n);
	       }catch (PersistenceException ex) {
	           throw new ExcepcionServiceHistorialEquipos("Error al registrar novedad",ex);
	       }
	   }
	@Override
	   public Novedad consultarNovedad() throws ExcepcionServiceHistorialEquipos {
	       try {
	           return novedadDAO.consultarNovedad();
	       }catch (PersistenceException ex) {
	          
	    	   throw new ExcepcionServiceHistorialEquipos("Error al registrar novedad",ex);
	       }
	   }
    
}
