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
import edu.eci.cvds.sample.services.ExcepcionHistorialEquipos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Andres Davila
 */
public class ServiciosHistorialTest {
    
    @Inject
    private final ServiceHistorialEquipos ServicioHE;
    
    
	
    public ServiciosHistorialTest() {

        ServicioHE = ServiceFactory.getInstance().getServiciosFactory();
        
        
    }
    
    /*@Test
    public void consultarUsuario()
    {
      boolean r=false;
      try{
          ServicioHE.consultarUsuario("oadavilaf18@gmail.com");
      }catch(ExcepcionHistorialEquipos e)
      {
          r = true;
      }
      Assert.assertTrue(r);
    }*/
    
    /*@Test
    public void consultarUsuarios()
    {
        boolean r= false;
        try{
            ServicioHE.consultarUsuarios();
        }catch(ExcepcionHistorialEquipos e){
            r = true;
        }
        Assert.assertTrue(r);
    }*/
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
