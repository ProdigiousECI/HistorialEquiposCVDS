/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.example;

import java.sql.Date;

import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;


/**
 *
 * @author javier
 */
public class mainHistorialEquipos {
    public static void main(String[] args) throws ExcepcionServiceHistorialEquipos 
    {
        ServiceFactory.getInstance().getServiciosFactory();
    	
    	
    	Novedad n=new Novedad( "prueba", "en la clase");
    	ServiceFactory.getInstance().getServiciosFactory().registrarNovedad(n);
    	//system.out.println(ServiceFactory.getInstance().getServiciosFactory().consultarNovedades());
    	//System.out.println(ServiceFactory.getInstance().getServiciosFactory().consultarNovedades());
        
    }
}
