/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.example;

import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ElementoMapper;
import java.sql.SQLException;
import java.text.ParseException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 *
 * @author javier
 */


public class mainHistorialEquipos {
        
    public static void main(String[] args) throws ParseException, ExcepcionServiceHistorialEquipos 
    {
        Elemento e = new Elemento(5,"OMEN","Teclado");
        
        //ServiceFactory.getInstance().getServiceHistorialEquipos();
        
        ServiceHistorialEquipos ServicioHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
        
        System.out.println(ServicioHE.consultarElemento(2));
        
        //ServicioHE.registrarElemento(e);
    }
}
