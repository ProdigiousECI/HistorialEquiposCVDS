/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.example;

import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.entities.User;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.EquipoMapper;
import java.sql.SQLException;
import java.text.ParseException;


/**
 *
 * @author javier
 */
public class mainHistorialEquipos {
    public static void main(String[] args)throws ParseException, ExcepcionServiceHistorialEquipos
    {
        //User u = new User("miguel","qwert");
        //Equipo e = new Equipo(10,"PC1");
        //ServiceFactory.getInstance().getServiceHistorialEquipos();
        ServiceHistorialEquipos ServicioHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
        System.out.println(ServicioHE.consultarEquipos());
    }
}
