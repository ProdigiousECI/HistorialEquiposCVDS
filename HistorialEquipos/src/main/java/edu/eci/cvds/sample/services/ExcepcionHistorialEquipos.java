/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
/**
 *
 * @author Andres Davila
 */
public class ExcepcionHistorialEquipos extends Exception{
    
    public ExcepcionHistorialEquipos(String string,PersistenceException ex)
    {
        super(string, ex);
    }
    
    public ExcepcionHistorialEquipos(String string)
    {
        super(string);
    }
}
