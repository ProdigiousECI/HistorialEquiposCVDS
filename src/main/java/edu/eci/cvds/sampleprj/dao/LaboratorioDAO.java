/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.sample.entities.Laboratorio;
import java.util.ArrayList;

/**
 *
 * @author Andres Davila
 */
public interface LaboratorioDAO {
    public void registrarLaboratorio(Laboratorio lab) throws PersistenceException;
    public Laboratorio consultarLaboratorio(int id) throws PersistenceException;
    public void cerrarLaboratorio(int id) throws PersistenceException;
    public ArrayList<Laboratorio> consultarLaboratorios(int e,String s) throws PersistenceException;
}
