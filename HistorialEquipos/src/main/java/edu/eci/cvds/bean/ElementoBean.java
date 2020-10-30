/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.bean;

import com.google.inject.Inject;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.factory.ServiceFactory;
import java.util.ArrayList;
/**
 *
 * @author javier
 */
@ManagedBean(name = "Elemento")
@ApplicationScoped
public class ElementoBean{   
    
    private final ServiceHistorialEquipos serviceHE;
    public ArrayList<Elemento> elementos;

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }
    
    public ElementoBean(){
        serviceHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
        try{
            elementos = serviceHE.consultarElementos();          
        }catch(ExcepcionServiceHistorialEquipos e){
        }
    }
    
    public void start(){
        
    }
    
    public void registrarCliente(long id, String nombre, String tipo, long idEquipo){
        try {
            serviceHE.registrarElemento(new Elemento((int)id,nombre,tipo));
            elementos = serviceHE.consultarElementos();

        } catch (ExcepcionServiceHistorialEquipos ex) {
            new ExcepcionServiceHistorialEquipos("No se pudo registrar cliente");
        }       
    }
}
