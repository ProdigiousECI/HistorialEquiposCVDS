/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sample.entities.Laboratorio;
import edu.eci.cvds.sampleprj.dao.LaboratorioDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.LaboratorioMapper;
import java.util.ArrayList;
/**
 *
 * @author USUARIO
 */
public class MyBATISLaboratorioDAO implements LaboratorioDAO{
    
    @Inject
    private LaboratorioMapper laboratorioMapper;

    @Override
    public void registrarLaboratorio(Laboratorio lab) throws PersistenceException {
        try{
  
            laboratorioMapper.registrarLaboratorio(lab);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al registrar "+ lab.toString(),e);
        }  
    }

    @Override
    public Laboratorio consultarLaboratorio(int id) throws PersistenceException {
        try{
            return laboratorioMapper.consultarLaboratorio(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar el laboratorio", e);
        }
    }

    @Override
    public ArrayList<Laboratorio> consultarLaboratorios(int ed) throws PersistenceException {
       try{
            return laboratorioMapper.consultarLaboratorios(ed);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar elementos", e);
        }
    }

    @Override
    public void cerrarLaboratorio(int id) throws PersistenceException {
        try{
            laboratorioMapper.cerrarLaboratorio(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar elementos", e);
        }
    }
}
