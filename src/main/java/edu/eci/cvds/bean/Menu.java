package edu.eci.cvds.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.google.inject.Inject;

import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;

@SuppressWarnings("deprecation")
@ManagedBean(name = "menu")

//@SessionScoped
@ViewScoped
public class Menu{
	
	private static final long serialVersionUID = -1071897882966043904L;
	
	private ArrayList<String> images=new ArrayList<String>();
		
	private Integer elementoId;

	private final ServiceHistorialEquipos service;
		
	public Menu(){
        service = ServiceFactory.getInstance().getServiceHistorialEquipos();
        images=new ArrayList<String>();
        images.add("logo1.png");
        images.add("logo2.png");
        images.add("logo3.png");
        images.add("eci1.jpg");
        images.add("eci2.jpg");
        images.add("eci3.jpg");

       
    }
	
	
	
	public ArrayList<String> getImages() {
		return images;
	}



	public void setImages(ArrayList<String> images) {
		this.images = images;
	}



	

	

	

	
	

}
