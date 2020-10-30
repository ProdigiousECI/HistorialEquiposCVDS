/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services;

import edu.eci.cvds.sample.services.ExcepcionHistorialEquipos;
import edu.eci.cvds.sample.entities.User;
import java.util.List;
/**
 *
 * @author Andres Davila 
 */
public interface ServiceHistorialEquipos {
    /**
     * Retorna el usuario segun sus credenciales
     * @param correo String  correo del usuario
     * @return Usuario usuario 
     * @throws edu.eci.cvds.samples.services.ExcepcionServiciosBanco
     */
    public abstract User consultarUsuario(String correo) throws ExcepcionHistorialEquipos;
    
    /**
     * 
     * @return Lista de usuarios
     * @throws ExcepcionServiciosBanco 
     */
    public abstract List<User> consultarUsuarios() throws ExcepcionHistorialEquipos;
}
