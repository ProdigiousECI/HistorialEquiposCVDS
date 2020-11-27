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

import org.primefaces.PrimeFaces;
import java.lang.String;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.entities.User;
import javax.faces.bean.ViewScoped;
import edu.eci.cvds.sample.factory.ServiceFactory;
import java.util.ArrayList;
/**
 *
 * @author javier
 */
@ManagedBean(name = "Equipo")
/*@ApplicationScoped*/
@ViewScoped
public class EquipoBean{   
    
    /*
                    <!--p:selectOneMenu id="Tipo" binding="#{tipo}" style="width:125px">
                    <p:selectOneMenu id="city" value="#{Elemento.equipos}" effect="fold" editable="true">
                    <f:selectItem itemLabel="Select One" itemValue="" />
                    <f:selectItems value="#{Elemento.nombre}" />
                    </p:selectOneMenu>
                </p:selectOneMenu-->
    */
    
    
    private final ServiceHistorialEquipos serviceHE;
    public ArrayList<Equipo> equipos;
    public Integer laboratorioId;
    private ArrayList<String> images=new ArrayList<String>();
    public ArrayList<Equipo> equiposLab;
    
    public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public ArrayList<Equipo> getEquipos() {
		System.out.println(equipos);
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    public EquipoBean(){
        serviceHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
        try{
            equipos = serviceHE.consultarEquipos();  
            images.add("eci1.jpg");
            images.add("boton1.JPG");
            images.add("equipo.jpg");
            images.add("eci2.jpg");
            images.add("prodigious.png");
        }catch(ExcepcionServiceHistorialEquipos e){
        }
    }
    
    public void start(){
        
    }
    
    public void registrarEquipo(int id, String nombre, String torre, String pantalla, String mouse, String teclado){
        System.out.println(torre);
        try {
        	nombre=nombre.trim();
        	if(nombre.length()>0) {
	            serviceHE.registrarEquipo(new Equipo(id,nombre));
                    serviceHE.actualizarDisponibilidadElementos(torre,pantalla,mouse,teclado);
	            equipos = serviceHE.consultarEquipos();
	            showMessage("El registro del equipo ha sido un exito");
        	}else {
        		showMessage("El registro del equipo ha fracasado");
        	}

        } catch (ExcepcionServiceHistorialEquipos ex) {
            new ExcepcionServiceHistorialEquipos("No se pudo registrar equipo");
        }       
    }
    public ArrayList<Equipo> getEquiposPorLaboratorio() throws ExcepcionServiceHistorialEquipos{
            
            return serviceHE.consultarEquiposPorLaboratorio(laboratorioId);
        
    }
    public void showMessage(String confirmacion) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", confirmacion);     
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public Integer getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(Integer laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public ArrayList<Equipo> getEquiposLab() {
        return equiposLab;
    }

    public void setEquiposLab(ArrayList<Equipo> equiposLab) {
        this.equiposLab = equiposLab;
    }
    
}