/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.sample.entities.Elemento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javier
 */
public interface ElementoDAO {
    public void registrarElemento(Elemento ele) throws PersistenceException;
    public Elemento consultarElemento(int id) throws PersistenceException;
    public ArrayList<Elemento> consultarElementos(int e) throws PersistenceException;
    public ArrayList<Elemento> consultarElementosTorre() throws PersistenceException;
    public List<Elemento> consultarElementosPantalla() throws PersistenceException;
    public List<Elemento> consultarElementosMouse() throws PersistenceException;
    public List<Elemento> consultarElementosTeclado() throws PersistenceException;
    public void actualizarDisponibilidadElementos(String torre, String pantalla, String mouse, String teclado)throws PersistenceException;
}
