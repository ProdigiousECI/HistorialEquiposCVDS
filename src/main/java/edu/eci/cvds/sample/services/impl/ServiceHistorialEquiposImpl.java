/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services.impl;

import java.sql.Date;

import edu.eci.cvds.sample.entities.Equipo;

import java.util.List;

import edu.eci.cvds.sampleprj.dao.EquipoDAO;

import com.google.inject.Inject;

import edu.eci.cvds.sample.entities.User;

import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import java.util.List;
import edu.eci.cvds.sampleprj.dao.UsersDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.sample.services.ServiceHistorialEquipos;

import java.util.ArrayList;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;

/**
 *
 * @author javier
 */
public class ServiceHistorialEquiposImpl implements ServiceHistorialEquipos {

    @Inject
    private EquipoDAO equipoDAO;

    @Inject
    private UsersDAO UserDAO;

    @Inject
    private ElementoDAO elementoDAO;

    @Inject
    private NovedadDAO novedadDAO;

    @Override
    public void registrarEquipo(Equipo equip) throws ExcepcionServiceHistorialEquipos {
        try {
            equipoDAO.registrarEquipo(equip);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al registrar", ex);
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipo consultarEquipo(int id) throws ExcepcionServiceHistorialEquipos {
        try {
            return equipoDAO.consultarEquipo(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al consultar", ex);
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Equipo> consultarEquipos() throws ExcepcionServiceHistorialEquipos {
        try {
            return equipoDAO.consultarEquipos();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al consultar equipos", ex);
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarElemento(Elemento ele) throws ExcepcionServiceHistorialEquipos {
        try {
            elementoDAO.registrarElemento(ele);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al registrar", ex);
        }
    }

    @Override
    public Elemento consultarElemento(int id) throws ExcepcionServiceHistorialEquipos {
        try {
            return elementoDAO.consultarElemento(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al consultar el elemento " + id, ex);
        }
    }

    @Override
    public ArrayList<Elemento> consultarElementos(int e) throws ExcepcionServiceHistorialEquipos {
        try {
            return elementoDAO.consultarElementos(e);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al consultar elementos", ex);
        }
    }

    @Override
    public void registrarNovedad(Novedad n) throws ExcepcionServiceHistorialEquipos {
        try {

            novedadDAO.RegistrarNovedad(n);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al registrar novedad", ex);
        }
    }

    @Override
    public ArrayList<Novedad> consultarNovedadporElemento(int i) throws ExcepcionServiceHistorialEquipos {
        try {
            return novedadDAO.consultarNovedadporElemento(i);
        } catch (PersistenceException ex) {

            throw new ExcepcionServiceHistorialEquipos("Error al consultar novedad", ex);
        }
    }

    @Override
    public ArrayList<Novedad> consultarNovedades() throws ExcepcionServiceHistorialEquipos {
        try {
            return novedadDAO.consultarNovedades();
        } catch (PersistenceException ex) {

            throw new ExcepcionServiceHistorialEquipos("Error al consultar novedad", ex);
        }
    }

    @Override
    public ArrayList<Novedad> consultarNovedadporEquipo(int i) throws ExcepcionServiceHistorialEquipos {
        try {
            return novedadDAO.consultarNovedadporEquipo(i);
        } catch (PersistenceException ex) {

            throw new ExcepcionServiceHistorialEquipos("Error al consultar novedad", ex);
        }
    }

    @Override
    public User consultarUsuario(String correo) throws ExcepcionServiceHistorialEquipos {
        try {
            return UserDAO.consultarUsuario(correo);
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("No se pudo consultar el usuario " + correo, ex); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public List<User> consultarUsuarios() throws ExcepcionServiceHistorialEquipos {
        try {
            return UserDAO.consultarUsuarios();
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("No se pudo consultar los usuarios ", ex); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
