  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

/**
 *

 * @author Miguel  
 */
public class PersistenceException extends Exception {



    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(Throwable cause) {
        super(cause);
    }

    public PersistenceException(String string, org.apache.ibatis.exceptions.PersistenceException e) {
        super(string,e);
    }

	
    public PersistenceException() {
	super();
    }

    


}
