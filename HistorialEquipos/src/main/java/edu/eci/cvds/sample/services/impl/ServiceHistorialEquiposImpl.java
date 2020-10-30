/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sample.entities.User;
import edu.eci.cvds.sample.services.ExcepcionHistorialEquipos;

import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import java.util.List;
import edu.eci.cvds.sampleprj.dao.UsersDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
/**
 *
 * @author javier
 */
public class ServiceHistorialEquiposImpl implements ServiceHistorialEquipos{
    
    @Inject
    private UsersDAO UserDAO;

    @Override
    public User consultarUsuario(String correo) throws ExcepcionHistorialEquipos {
        try
        {
            return UserDAO.consultarUsuario(correo);
        }catch(PersistenceException ex){
        throw new UnsupportedOperationException("No se pudo consultar el usuario "+correo,ex); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public List<User> consultarUsuarios() throws ExcepcionHistorialEquipos {
        try
        {
            return UserDAO.consultarUsuarios();
        }catch(PersistenceException ex){
        throw new UnsupportedOperationException("No se pudo consultar los usuarios ",ex); //To change body of generated methods, choose Tools | Templates.
        }
    }
	
	
    
}
