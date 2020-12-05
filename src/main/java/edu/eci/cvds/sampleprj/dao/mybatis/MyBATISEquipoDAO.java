/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.EquipoMapper;
import java.util.ArrayList;


/**
 *
 * @author Acer
 */
public class MyBATISEquipoDAO implements EquipoDAO{
    @Inject
    private EquipoMapper equipoMapper;
    
    @Override
    public void registrarEquipo(Equipo equip) throws PersistenceException {
        try{
            equipoMapper.registrarEquipo(equip);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar"+equip.toString(),e);
        }
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipo consultarEquipo(int id) throws PersistenceException {
        try{
            return equipoMapper.consultarEquipo(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar equipo",e);
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Equipo> consultarEquipos(int filtro,String filtrar) throws PersistenceException {
        try{
        	return equipoMapper.consultarEquipos(filtro,"%"+filtrar+"%");
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar equipos",e);
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Equipo> consultarEquiposPorLaboratorio(Integer laboratorioId) throws PersistenceException {
        try{
            return equipoMapper.consultarEquiposPorLaboratorio(laboratorioId);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar equipos por laboratorio",e);
        }
    }

	@Override
	public Equipo consultarEquipoPorNombre(String nombre) throws PersistenceException {
		try{
            return equipoMapper.consultarEquipoPorNombre(nombre);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar equipo",e);
        }
	}

	@Override
	public ArrayList<Equipo> consultarEquiposActivos(int filtro, String filtrar) throws PersistenceException {
		try{
			
            return equipoMapper.consultarEquiposActivos(filtro,"%"+filtrar+"%");
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar equipos",e);
        }
	}
        @Override
        public void desasociarEquipo(int id) throws PersistenceException {
            try{
                equipoMapper.desasociarEquipo(id);
            }catch(org.apache.ibatis.exceptions.PersistenceException e){
                 throw new PersistenceException("Error al consultar elementos", e);
            }
        }

		@Override
		public void asociarEquipoALaboratorio(int in, Integer laboratorioId) throws PersistenceException {
			try{
                equipoMapper.asociarEquipoALaboratorio(in,laboratorioId);
            }catch(org.apache.ibatis.exceptions.PersistenceException e){
                 throw new PersistenceException("Error al Asociar equipo a Laboratorio", e);
            }
			
		}
    
    
}
