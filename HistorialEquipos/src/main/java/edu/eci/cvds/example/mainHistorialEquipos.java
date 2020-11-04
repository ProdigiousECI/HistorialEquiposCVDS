/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.example;


import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.entities.User;

import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import java.text.ParseException;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ElementoMapper;
import java.sql.SQLException;
import java.text.ParseException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.sql.Date;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;




/**
 *
 * @author javier
 */

public class mainHistorialEquipos {

 
        


        
    public static void main(String[] args) throws ParseException, ExcepcionServiceHistorialEquipos 
    {
        //Elemento e = new Elemento("OMEN","Teclado");
        
        //ServiceFactory.getInstance().getServiceHistorialEquipos();
        
        //ServiceHistorialEquipos ServicioHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
        
        //System.out.println(ServicioHE.consultarElementos());
        
        //ServicioHE.registrarElemento(e);

        ServiceHistorialEquipos ServicioHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
         //System.out.println(ServicioHE.consultarUsuario("oadavilaf18@gmail.com"));
         
        //System.out.println(ServiceFactory.getInstance().getServiciosFactory().consultarUsuarios());  	
    	
    	//Novedad n=new Novedad( "prueba", "en la clase");
    	//ServiceFactory.getInstance().getServiceHistorialEquipos().registrarNovedad(n);
        System.out.println(ServiceFactory.getInstance().getServiceHistorialEquipos().consultarNovedadporElemento(1));
    	//ServiceFactory.getInstance().getServiceHistorialEquipos().consultarNovedades());
    	//ServiceFactory.getInstance().getServiceHistorialEquipos().consultarNovedades());

    }

}
