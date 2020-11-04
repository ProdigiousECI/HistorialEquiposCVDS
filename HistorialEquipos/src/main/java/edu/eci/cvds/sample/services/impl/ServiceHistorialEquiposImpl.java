/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;

import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author javier
 */
public class ServiceHistorialEquiposImpl implements ServiceHistorialEquipos{
	
        
        @Inject
        private EquipoDAO equipoDAO;

    @Override
    public void registrarEquipo(Equipo equip) throws ExcepcionServiceHistorialEquipos {
        try{
            equipoDAO.registrarEquipo(equip);
        }catch(PersistenceException ex){
            throw new ExcepcionServiceHistorialEquipos("Error al registrar",ex);
        }
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipo consultarEquipo(int id) throws ExcepcionServiceHistorialEquipos {
        try{
            return equipoDAO.consultarEquipo(id);
        }catch(PersistenceException ex){
            throw new ExcepcionServiceHistorialEquipos("Error al consultar",ex);
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Equipo> consultarEquipos() throws ExcepcionServiceHistorialEquipos {
        try{
            return equipoDAO.consultarEquipos();
        }catch(PersistenceException ex){
            throw new ExcepcionServiceHistorialEquipos("Error al consultar equipos",ex);
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
