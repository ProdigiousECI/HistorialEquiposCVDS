/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.example;

import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.entities.User;
import edu.eci.cvds.sample.services.ExcepcionHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;

import java.text.ParseException;

/**
 *
 * @author javier
 */
public class mainHistorialEquipos {
    public static void main(String[] args) throws ExcepcionHistorialEquipos,ParseException
    {
         ServiceHistorialEquipos ServicioHE = ServiceFactory.getInstance().getServiciosFactory();
         //System.out.println(ServicioHE.consultarUsuario("oadavilaf18@gmail.com"));
         
        //System.out.println(ServiceFactory.getInstance().getServiciosFactory().consultarUsuarios());
        
    }
}
