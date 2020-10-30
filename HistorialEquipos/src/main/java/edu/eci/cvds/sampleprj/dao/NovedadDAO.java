package edu.eci.cvds.sampleprj.dao;



import java.util.ArrayList;

import edu.eci.cvds.sample.entities.Novedad;



public interface NovedadDAO {
	
	
	
	public void RegistrarNovedad(Novedad n) throws PersistenceException;

	

	public ArrayList<Novedad> consultarNovedadporElemento(int i) throws PersistenceException;
	
	public ArrayList<Novedad> consultarNovedadporEquipo(int i) throws PersistenceException;

}
