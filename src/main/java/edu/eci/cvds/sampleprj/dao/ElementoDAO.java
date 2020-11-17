/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.sample.entities.Elemento;
import java.util.ArrayList;

/**
 *
 * @author javier
 */
public interface ElementoDAO {
    public void registrarElemento(Elemento ele) throws PersistenceException;
    public Elemento consultarElemento(int id) throws PersistenceException;
    public ArrayList<Elemento> consultarElementos(int e) throws PersistenceException;
    public void darBajaElemento(int id) throws PersistenceException;
    public ArrayList<Elemento> bajaNoElemento() throws PersistenceException;
}
