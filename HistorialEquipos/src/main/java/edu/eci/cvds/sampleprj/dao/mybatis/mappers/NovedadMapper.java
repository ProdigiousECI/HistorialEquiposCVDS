package edu.eci.cvds.sampleprj.dao.mybatis.mappers;



import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.sample.entities.Novedad;

public interface NovedadMapper {

	void registrarNovedad(@Param("idn") Novedad n);

	

	ArrayList<Novedad> consultarNovedadporElemento(@Param("numero") int i);
	ArrayList<Novedad> consultarNovedadporEquipo(@Param("numero") int i);



	ArrayList<Novedad> consultarNovedades();


}
