/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services;


import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.User;
import java.util.List;


import edu.eci.cvds.sample.entities.Elemento;
import java.util.ArrayList;



import java.util.ArrayList;

import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;



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
    public abstract User consultarUsuario(String correo) throws ExcepcionServiceHistorialEquipos;
    
    /**
     * 
     * @return Lista de usuarios
     * @throws ExcepcionServiciosBanco 
     */
    public abstract List<User> consultarUsuarios() throws ExcepcionServiceHistorialEquipos;


    public abstract void registrarElemento(Elemento ele) throws ExcepcionServiceHistorialEquipos;
    public abstract ArrayList<Elemento> consultarElementos() throws ExcepcionServiceHistorialEquipos;
    public abstract Elemento consultarElemento(int id) throws ExcepcionServiceHistorialEquipos;

	
    public abstract void registrarNovedad(Novedad n) throws ExcepcionServiceHistorialEquipos;
    public abstract ArrayList<Novedad> consultarNovedadporElemento(int i) throws ExcepcionServiceHistorialEquipos;
    public abstract ArrayList<Novedad> consultarNovedadporEquipo(int i) throws ExcepcionServiceHistorialEquipos;
    public abstract ArrayList<Novedad> consultarNovedades() throws ExcepcionServiceHistorialEquipos;

	
}
