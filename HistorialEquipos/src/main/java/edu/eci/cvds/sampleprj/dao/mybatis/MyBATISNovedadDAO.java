package edu.eci.cvds.sampleprj.dao.mybatis;



import java.util.ArrayList;

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
	public ArrayList<Novedad> consultarNovedadporElemento(int i) throws PersistenceException {
		try{
			return novedadMapper.consultarNovedadporElemento(i);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar Novedad ",  e);
		  }
	}

	@Override
	public ArrayList<Novedad> consultarNovedadporEquipo(int i) throws PersistenceException {
		try{
			return novedadMapper.consultarNovedadporEquipo(i);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar Novedad ",  e);
		  }
	}
	

}
