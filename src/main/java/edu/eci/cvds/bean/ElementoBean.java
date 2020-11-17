/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.bean;

import com.google.inject.Inject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.Elemento;
//import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.factory.ServiceFactory;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author javier
 */
@ManagedBean(name = "Elemento")
@ApplicationScoped
//@ViewScoped
public class ElementoBean{   
    
    /*
                    <!--p:selectOneMenu id="Tipo" binding="#{tipo}" style="width:125px">
                    <p:selectOneMenu id="city" value="#{Elemento.equipos}" effect="fold" editable="true">
                    <f:selectItem itemLabel="Select One" itemValue="" />
                    <f:selectItems value="#{Elemento.nombre}" />
                    </p:selectOneMenu>
                </p:selectOneMenu-->
    */
    
    
    private final ServiceHistorialEquipos serviceHE;
    private int filtro;
    public ArrayList<Elemento> elementos;
    public ArrayList<Elemento> noDadosDeBaja;
    //public ArrayList<Equipo> equipos;

    public ArrayList<Elemento> getElementos() throws ExcepcionServiceHistorialEquipos {
        return serviceHE.consultarElementos(filtro);
    }
    
    public Elemento obtenerElemento(int n) throws ExcepcionServiceHistorialEquipos {
        return serviceHE.consultarElemento(n);
    }
    
    public void ordenarElementosporFiltro(int i) throws ExcepcionServiceHistorialEquipos {
    	filtro=i;
    	elementos=serviceHE.consultarElementos(filtro);
    }

    public void darBajaElemento(int id) throws ExcepcionServiceHistorialEquipos {
        int input = JOptionPane.showConfirmDialog(null, "Esta seguro de dar de baja el elemento "+id+"?");
        if(input==0)
        {
            serviceHE.darBajaElemento(id); 
            showMessage("El elemento "+id+" ha sido dado de baja");
        }       
    }

    public void bajaNoElemento() throws ExcepcionServiceHistorialEquipos 
    {
        noDadosDeBaja=serviceHE.bajaNoElemento();
    }
    
    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }
    
    public ElementoBean(){
        serviceHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
        try{
        	filtro=1;
            elementos = serviceHE.consultarElementos(1);          
        }catch(ExcepcionServiceHistorialEquipos e){
        }
    }
    
    public void start(){
        
    }
    
    public void registrarElemento(String nombre, String tipo){
        try {
        	nombre=nombre.trim();
        	if(nombre.length()>0) {
	            serviceHE.registrarElemento(new Elemento(nombre,tipo));
	            
	            showMessage("El registro del elemento ha sido un exito");
        	}else {
        		showMessage("El registro del elemento ha fracasado");
        	}

        } catch (ExcepcionServiceHistorialEquipos ex) {
            new ExcepcionServiceHistorialEquipos("No se pudo registrar cliente");
        }       
    }
    
    public void showMessage(String confirmacion) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", confirmacion);     
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
}
