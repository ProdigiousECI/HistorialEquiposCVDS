/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;
import edu.eci.cvds.sample.entities.Equipo;
import java.util.ArrayList;
/**
 *
 * @author Acer
 */
public interface EquipoDAO {
    public void registrarEquipo(Equipo equip)throws PersistenceException;
    
    public Equipo consultarEquipo(int id) throws PersistenceException;
    
    public ArrayList<Equipo> consultarEquipos(int filtro,String filtrar) throws PersistenceException;
    
    public ArrayList<Equipo> consultarEquiposPorLaboratorio(Integer laboratorioId) throws PersistenceException;

    public Equipo consultarEquipoPorNombre(String nombre) throws PersistenceException;

    public void darBajaEquipo(int id)throws PersistenceException;


    public ArrayList<Equipo> consultarEquiposActivos(int filtro,String filtrar) throws PersistenceException;

	
    public void desasociarEquipo(int id)throws PersistenceException;

	public void asociarEquipoALaboratorio(int in, Integer laboratorioId) throws PersistenceException;
}
