package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ElementoMapper;
import java.util.ArrayList;
import java.util.List;

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
    public void actualizarDisponibilidadElementos(String torre, String pantalla, String mouse, String teclado) throws PersistenceException {
        try{
  
            elementoMapper.actualizarDisponibilidadElementos(torre,pantalla,mouse,teclado);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al actualizar",e);
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
    public ArrayList<Elemento> consultarElementos(int es,String s) throws PersistenceException {
        try{
            return elementoMapper.consultarElementos(es,"%"+s+"%");
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar elementos", e);
        }
    }

    @Override

    public ArrayList<Elemento> consultarElementosTorre() throws PersistenceException {
        try{
            return elementoMapper.consultarElementosTorre();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar elementos por torre", e);
        }
    }
    @Override
    public List<Elemento> consultarElementosPantalla() throws PersistenceException {
        try{
            return elementoMapper.consultarElementosPantalla();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar elementos por pantalla", e);
        }
    }
    @Override
    public List<Elemento> consultarElementosMouse() throws PersistenceException {
        try{
            return elementoMapper.consultarElementosMouse();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar elementos por mouse", e);
        }
    }
    @Override
    public List<Elemento> consultarElementosTeclado() throws PersistenceException {
        try{
            return elementoMapper.consultarElementosTeclado();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar elementos por teclado", e);
        }
    }

    

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
	@Override
	public Elemento consultarElementoPorNombre(String tipo) throws PersistenceException {
		try{
            return elementoMapper.consultarElementoPorNombre(tipo);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al consultar el elemento", e);
        } 
	}
	@Override
	public void asociarElementoAEquipo(String nombre, int id) throws PersistenceException {
		try{
            elementoMapper.asociarElementoAEquipo(nombre,id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al asociar el elemento", e);
        } 
		
	}
	@Override
	public void eliminarAsociacion(int n) throws PersistenceException {
		try{
            elementoMapper.eliminarAsociacion(n);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
             throw new PersistenceException("Error al asociar el elemento", e);
        } 
		
	}

    
}
