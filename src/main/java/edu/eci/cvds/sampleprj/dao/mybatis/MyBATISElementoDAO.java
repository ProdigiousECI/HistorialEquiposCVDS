package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ElementoMapper;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author javie
 */
public class MyBATISElementoDAO implements ElementoDAO{

    @Inject
    private ElementoMapper elementoMapper;
    
    @Override
    public void registrarElemento(Elemento ele) throws PersistenceException {
        try{
  
            elementoMapper.registrarElemento(ele);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al registrar "+ ele.toString(),e);
        }      
    }

    @Override
    public Elemento consultarElemento(int id) throws PersistenceException {
        try{
            return elementoMapper.consultarElemento(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar el elemento", e);
        }
    }
    @Override
    public ArrayList<Elemento> consultarElementos(int es) throws PersistenceException {
        try{
            return elementoMapper.consultarElementos(es);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar elementos", e);
        }
    }

    @Override
    public void darBajaElemento(int id) throws PersistenceException {
        try{
            elementoMapper.darBajaElemento(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar el elemento", e);
        }    
    }

    @Override
    public ArrayList<Elemento> bajaNoElemento() throws PersistenceException {
        try{
            return elementoMapper.bajaNoElemento();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar el elemento", e);
        } 
    }
    
}
