package edu.eci.cvds.sampleprj.dao.mybatis.mappers;



import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.sample.entities.Novedad;

public interface NovedadMapper {

	void registrarNovedad(@Param("idn") Novedad n);

	Novedad consultarNovedad();

}
