package edu.eci.cvds.sampleprj.dao;



import java.util.ArrayList;

import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;



public interface NovedadDAO {
	
	
	
	public void RegistrarNovedad(Novedad n) throws PersistenceException;

	

	public ArrayList<Novedad> consultarNovedadporElemento(int i) throws PersistenceException;
	
	public ArrayList<Novedad> consultarNovedadporEquipo(int i) throws PersistenceException;

	public ArrayList<Novedad> consultarNovedades() throws PersistenceException;

}
