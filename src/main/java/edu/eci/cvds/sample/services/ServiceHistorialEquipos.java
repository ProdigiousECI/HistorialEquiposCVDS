/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services;


import edu.eci.cvds.sample.entities.Equipo;


import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.User;
import java.util.List;


import edu.eci.cvds.sample.entities.Elemento;
import java.util.ArrayList;

import edu.eci.cvds.sample.entities.Laboratorio;

import java.util.ArrayList;

import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;



/**
 *
 * @author Andres Davila 
 */
public interface ServiceHistorialEquipos {

    public abstract void registrarEquipo(Equipo equip)throws ExcepcionServiceHistorialEquipos;
    
    public abstract Equipo consultarEquipo(int id) throws ExcepcionServiceHistorialEquipos;
    
    public abstract ArrayList<Equipo> consultarEquipos(int filtro,String filtrar) throws ExcepcionServiceHistorialEquipos;

    public abstract ArrayList<Equipo> consultarEquiposPorLaboratorio(Integer laboratorioId)throws ExcepcionServiceHistorialEquipos;
    public abstract void actualizarDisponibilidadElementos(String torre,String pantalla,String mouse,String teclado)throws ExcepcionServiceHistorialEquipos;

    public void darBajaElemento(int id) throws ExcepcionServiceHistorialEquipos;
    
    public ArrayList<Elemento> bajaNoElemento() throws ExcepcionServiceHistorialEquipos;

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
    public abstract ArrayList<Elemento> consultarElementos(int e,String s) throws ExcepcionServiceHistorialEquipos;
    public abstract Elemento consultarElemento(int id) throws ExcepcionServiceHistorialEquipos;
    public abstract ArrayList<Elemento> consultarElementosTorre()throws ExcepcionServiceHistorialEquipos;
    public abstract List<Elemento> consultarElementosPantalla()throws ExcepcionServiceHistorialEquipos;
    public abstract List<Elemento> consultarElementosMouse()throws ExcepcionServiceHistorialEquipos;
    public abstract List<Elemento> consultarElementosTeclado()throws ExcepcionServiceHistorialEquipos;
	
    public abstract void registrarNovedad(Novedad n) throws ExcepcionServiceHistorialEquipos;
    public abstract ArrayList<Novedad> consultarNovedadporElemento(int i) throws ExcepcionServiceHistorialEquipos;
    public abstract ArrayList<Novedad> consultarNovedadporEquipo(int i) throws ExcepcionServiceHistorialEquipos;
    public abstract ArrayList<Novedad> consultarNovedades() throws ExcepcionServiceHistorialEquipos;
    
    
    
    public abstract void registrarLaboratorio(Laboratorio lab)throws ExcepcionServiceHistorialEquipos;
    public abstract ArrayList<Laboratorio> consultarLaboratorios(int e) throws ExcepcionServiceHistorialEquipos;
    public abstract Laboratorio consultarLaboratorio(int id) throws ExcepcionServiceHistorialEquipos;

	public abstract Elemento consultarElementoPorNombre(String tipo) throws ExcepcionServiceHistorialEquipos;

	public abstract Equipo consultarEquipoPorNombre(String nombre) throws ExcepcionServiceHistorialEquipos;

	public abstract void asociarElementoAEquipo(String torre, int id) throws ExcepcionServiceHistorialEquipos;

	public abstract void eliminarAsociacion(int n) throws ExcepcionServiceHistorialEquipos;

	public abstract ArrayList<Equipo> consultarEquiposActivos(int filtro, String filtrar) throws ExcepcionServiceHistorialEquipos;

        public abstract void darBajaEquipo(int id)throws ExcepcionServiceHistorialEquipos;

        public abstract ArrayList<Elemento> consultarElementosPorEquipo(int equipoId)throws ExcepcionServiceHistorialEquipos;

        public abstract void desasociarElementoEquipo(int id)throws ExcepcionServiceHistorialEquipos;



	

	
}
