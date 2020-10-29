package edu.eci.cvds.sampleprj.dao.mybatis;



import com.google.inject.Inject;

import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.NovedadMapper;

public class MyBATISNovedadDAO implements NovedadDAO{
	
	@Inject
	private NovedadMapper novedadMapper;

	@Override
	public void RegistrarNovedad(Novedad n) throws PersistenceException {
		try{
			novedadMapper.registrarNovedad(n);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al registrar Novedad ",  e);
		  }
		
	}
	
	@Override
	public Novedad consultarNovedad() throws PersistenceException {
		try{
			return novedadMapper.consultarNovedad();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar Novedad ",  e);
		  }
		
	}
	

}
