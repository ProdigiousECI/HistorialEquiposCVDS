/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.test;

import com.google.inject.Inject;
import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author javie
 */
public class ServiceHistorialEquiposTest {
    @Inject
    private final ServiceHistorialEquipos ServicioHE;
	
    public ServiceHistorialEquiposTest() throws ExcepcionServiceHistorialEquipos {
            ServicioHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
            Elemento e = new Elemento("caca","adsadsadas");
            ServicioHE.registrarElemento(e); 
    }
	
    @Before
    public void setUp() {
    }
    /*
    @Test
    public void registrarElemento(){
        Elemento e1=new Elemento("Toshiba","Torre");
        boolean r = false;
        try{
            ServicioHE.registrarElemento(e1);
        }catch(ExcepcionServiceHistorialEquipos e){
            r = true;
        }
        
        Assert.assertTrue(r);
    }
    @Test
    public void consultarElementos(){
        boolean r = false;
        try{
            ServicioHE.consultarElementos();
        }catch(ExcepcionServiceHistorialEquipos e){
            r = true;
        }
        Assert.assertTrue(r);
    }*/
}
