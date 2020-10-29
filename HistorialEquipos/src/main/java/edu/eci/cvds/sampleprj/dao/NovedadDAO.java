package edu.eci.cvds.sampleprj.dao;



import edu.eci.cvds.sample.entities.Novedad;



public interface NovedadDAO {
	
	
	
	public void RegistrarNovedad(Novedad n) throws PersistenceException;

	public Novedad consultarNovedad() throws PersistenceException;

}
