package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.NovedadMapper;

public class MyBATISNovedadDAO implements NovedadDAO{
	
	@Inject
	private NovedadMapper novedadMapper;
	

}
