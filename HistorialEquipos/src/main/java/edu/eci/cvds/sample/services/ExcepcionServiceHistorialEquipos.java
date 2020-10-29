/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

/**
 *
 * @author javie
 */
public class ExcepcionServiceHistorialEquipos extends Exception {
        public ExcepcionServiceHistorialEquipos(String string) {
		super(string);
	}
        
	public ExcepcionServiceHistorialEquipos(String string, PersistenceException pex) {
		super(string, pex);
	}
}
