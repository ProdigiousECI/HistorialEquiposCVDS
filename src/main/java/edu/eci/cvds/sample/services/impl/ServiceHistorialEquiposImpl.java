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
import edu.eci.cvds.sample.entities.Laboratorio;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.LaboratorioDAO;
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
    
    @Inject
    private LaboratorioDAO laboratorioDAO;

    @Override
    public void registrarEquipo(Equipo equip) throws ExcepcionServiceHistorialEquipos {
        try {
            equipoDAO.registrarEquipo(equip);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al registrar", ex);
        }
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
    public ArrayList<Equipo> consultarEquipos(int filtro,String filtrar) throws ExcepcionServiceHistorialEquipos {
        try {
            return equipoDAO.consultarEquipos(filtro,filtrar);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al consultar equipos", ex);
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Equipo> consultarEquiposPorLaboratorio(Integer laboratorioId) throws ExcepcionServiceHistorialEquipos {
        try {
            return equipoDAO.consultarEquiposPorLaboratorio(laboratorioId);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al consultar equipos por laboratorio", ex);
        }    }

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
    public ArrayList<Elemento> consultarElementos(int e,String s) throws ExcepcionServiceHistorialEquipos {
        try {
            return elementoDAO.consultarElementos(e,s);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al consultar elementos", ex);
        }
    }
    @Override
    public ArrayList<Elemento> consultarElementosTorre() throws ExcepcionServiceHistorialEquipos{
        try{
            return elementoDAO.consultarElementosTorre();
        }catch (PersistenceException ex){
            throw new ExcepcionServiceHistorialEquipos("Error al consultar elementos por torre", ex);
        }
    }
    @Override
    public List<Elemento> consultarElementosPantalla() throws ExcepcionServiceHistorialEquipos{
        try{
            return elementoDAO.consultarElementosPantalla();
        }catch (PersistenceException ex){
            throw new ExcepcionServiceHistorialEquipos("Error al consultar elementos por pantalla", ex);
        }
    }
    @Override
    public List<Elemento> consultarElementosMouse() throws ExcepcionServiceHistorialEquipos{
        try{
            return elementoDAO.consultarElementosMouse();
        }catch (PersistenceException ex){
            throw new ExcepcionServiceHistorialEquipos("Error al consultar elementos por mouse", ex);
        }
    }
    @Override
    public List<Elemento> consultarElementosTeclado() throws ExcepcionServiceHistorialEquipos{
        try{
            return elementoDAO.consultarElementosTeclado();
        }catch (PersistenceException ex){
            throw new ExcepcionServiceHistorialEquipos("Error al consultar elementos por teclado", ex);
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

    @Override

    public void actualizarDisponibilidadElementos(String torre, String pantalla, String mouse, String teclado) throws ExcepcionServiceHistorialEquipos {
        try{
            elementoDAO.actualizarDisponibilidadElementos(torre, pantalla, mouse, teclado);
        }catch (PersistenceException ex){
            throw new ExcepcionServiceHistorialEquipos("Error al consultar elementos por teclado", ex);
        }    
    }

    @Override
    public void registrarLaboratorio(Laboratorio lab) throws ExcepcionServiceHistorialEquipos {
        try {
            laboratorioDAO.registrarLaboratorio(lab);
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("No se pudo registrar laboratorio ", ex); //To change body of generated methods, choose Tools | Templates.
        }
    }
    @Override
    public void darBajaElemento(int id) throws ExcepcionServiceHistorialEquipos {
        try {
            elementoDAO.darBajaElemento(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al dar de baja", ex);

        }
    }

    @Override

    public ArrayList<Laboratorio> consultarLaboratorios(int e,String s) throws ExcepcionServiceHistorialEquipos {
        try {
            return laboratorioDAO.consultarLaboratorios(e,s);
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("No se pudo consultar los laboratorios ", ex); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public Laboratorio consultarLaboratorio(int id) throws ExcepcionServiceHistorialEquipos {
        try {
            return laboratorioDAO.consultarLaboratorio(id);
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("No se pudo consultar el laboratorio", ex); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public ArrayList<Elemento> bajaNoElemento() throws ExcepcionServiceHistorialEquipos {
        try {
            return elementoDAO.bajaNoElemento();
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("Errores al consultar baja no ", ex); //To change body of generated methods, choose Tools | Templates.
        }
    }
    @Override
    public Elemento consultarElementoPorNombre(String tipo) throws ExcepcionServiceHistorialEquipos {
        try {
            return elementoDAO.consultarElementoPorNombre(tipo);
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("Errores al consultar elemento ", ex); //To change body of generated methods, choose Tools | Templates.
        }
    }
    @Override
    public Equipo consultarEquipoPorNombre(String nombre) throws ExcepcionServiceHistorialEquipos {
        try {
            return equipoDAO.consultarEquipoPorNombre(nombre);
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("Errores al consultar equipo ", ex); //To change body of generated methods, choose Tools | Templates.
        }
    }
    @Override
    public void asociarElementoAEquipo(String nombre, int id) throws ExcepcionServiceHistorialEquipos{
    	try {
            elementoDAO.asociarElementoAEquipo(nombre,id);
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("Errores al asociar equipo ", ex); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    @Override
    public void eliminarAsociacion(int n) throws ExcepcionServiceHistorialEquipos {
    	try {
            elementoDAO.eliminarAsociacion(n);
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("Errores al asociar equipo ", ex); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void cerrarLaboratorio(int id) throws ExcepcionServiceHistorialEquipos {
        try {
            laboratorioDAO.cerrarLaboratorio(id);
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("Errores al asociar equipo ", ex); //To change body of generated methods, choose Tools | Templates.
        }
        
    }

    @Override
    public ArrayList<Equipo> consultarEquiposActivos(int filtro, String filtrar) throws ExcepcionServiceHistorialEquipos {		
	try {
            return equipoDAO.consultarEquiposActivos(filtro,filtrar);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al consultar equipos", ex);
        }
    }

    @Override
    public void desasociarEquipo(int id) throws ExcepcionServiceHistorialEquipos {
        try {
            equipoDAO.desasociarEquipo(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiceHistorialEquipos("Error al desasociar equipos", ex);
        }
    }
}
