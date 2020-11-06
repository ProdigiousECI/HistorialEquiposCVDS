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
    public ArrayList<Equipo> consultarEquipos() throws PersistenceException {
        try{
            return equipoMapper.consultarEquipos();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar equipos",e);
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
