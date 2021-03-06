package edu.eci.cvds.bean;

import com.google.inject.Inject;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;

import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.factory.ServiceFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("deprecation")
@ManagedBean(name = "Novedades")
//@RequestScoped
@ViewScoped
//@ApplicationScoped
public class NovedadBean {
	
	
	
	
	
	protected ServiceHistorialEquipos service;
	
	private ArrayList<String> images=new ArrayList<String>();
	
	protected Integer i;
	
	protected Integer responsableId;
	
	protected String titulo;
	
	protected String detalle;
	protected String user;
	protected ArrayList<Novedad> novedades;
	
	public NovedadBean(){
        service = ServiceFactory.getInstance().getServiceHistorialEquipos();
        images.add("elemento.jpg");
        images.add("equipo.jpg");
    }
	
	
	
	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public ServiceHistorialEquipos getService() {
		return service;
	}

	public void setService(ServiceHistorialEquipos service) {
		this.service = service;
	}
	public ArrayList<String> getImages() {
        return images;
    }

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	public Integer getResponsableId() {
		return responsableId;
	}

	public void setResponsableId(Integer responsableId) {
		this.responsableId = responsableId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public void setNovedades(ArrayList<Novedad> novedades) {
		this.novedades = novedades;
	}
	
	public ArrayList<Novedad> getNovedades() throws ExcepcionServiceHistorialEquipos, IOException{
		
		return service.consultarNovedades();

	}
	public void verNovedades(ActionEvent ae){

		 Map<String,Object> options = new HashMap<String, Object>();
	     options.put("resizable", false);
	     System.out.println("pailis!!!!!!!!!!!!!!");
	     RequestContext.getCurrentInstance().openDialog("verNovedades", options, null);
	}

	
	public void showMessage(String confirmacion) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", confirmacion);
         
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
	public String color(Novedad nombre) throws ExcepcionServiceHistorialEquipos, IOException {
    	String color="#FFC264";
    	if (nombre==null) {
    		color=null;
    	}else {
    		int numero=buscar(nombre);
    		
	    	if(numero%2==0) {
	    		color="#D27F00";
	    	}
    	}
    	return color;
    }
    private int buscar(Novedad nombre) throws ExcepcionServiceHistorialEquipos, IOException {
    	
    	int cont=0;
    	
    	for(Novedad n:getNovedades()) {
    		
    		if(nombre.getId()==n.getId()) {
    			return cont; 
    		}cont++;
    	}
    	return -1;
    }
	
}
