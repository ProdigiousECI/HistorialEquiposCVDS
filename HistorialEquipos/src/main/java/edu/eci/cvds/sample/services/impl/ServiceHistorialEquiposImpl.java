/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import java.util.ArrayList;

/**
 *
 * @author javier
 */
public class ServiceHistorialEquiposImpl implements ServiceHistorialEquipos{
    
    @Inject
    private ElementoDAO elementoDAO;
    
    @Override
    public void registrarElemento(Elemento ele) throws ExcepcionServiceHistorialEquipos
    {
        try{
           elementoDAO.registrarElemento(ele);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiceHistorialEquipos("Error al registrar", ex);
       }
    }

    @Override
    public Elemento consultarElemento(int id) throws ExcepcionServiceHistorialEquipos 
    {
        try{
            return elementoDAO.consultarElemento(id);
        }catch(PersistenceException ex){
            throw new ExcepcionServiceHistorialEquipos("Error al consultar el elemento "+id, ex);
        }
    }

    @Override
    public ArrayList<Elemento> consultarElementos() throws ExcepcionServiceHistorialEquipos {
        try{
            return elementoDAO.consultarElementos();
        }catch(PersistenceException ex){
            throw new ExcepcionServiceHistorialEquipos("Error al consultar elementos", ex);
        }
    }
}
