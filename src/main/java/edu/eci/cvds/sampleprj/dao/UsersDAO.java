/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.sample.entities.User;
import java.util.List;

/**
 *
 * @author Andres Davila 
 */
public interface UsersDAO {
    /**
     * 
     * @param correo String correo del Usuario
     * @return Usuario correspondiente 
     * @throws edu.eci.cvds.sampleprj.dao.PersistenceException 
     */
    public User consultarUsuario(String correo ) throws PersistenceException;
    
    /**
     * 
     * @return Lista de usuarios
     * @throws PersistenceException 
     */
    public List<User> consultarUsuarios() throws PersistenceException;
    
}
