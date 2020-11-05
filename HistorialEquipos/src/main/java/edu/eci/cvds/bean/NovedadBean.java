package edu.eci.cvds.bean;

import com.google.inject.Inject;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.factory.ServiceFactory;
import java.util.ArrayList;



public class NovedadBean{
	
	
	
	private static final long serialVersionUID = -1071897882966043904L;
	
	@Inject
	protected ServiceHistorialEquipos service;
	
	@ManagedProperty(value = "#{param.i}")
	protected Integer i;
	
	@ManagedProperty(value = "#{param.responsable}")
	protected Integer responsableId;
	
	protected String titulo;
	
	protected String detalle;
	
	protected ArrayList<Novedad> novedades;
	
	
	
	



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






	public void setNovedades(ArrayList<Novedad> novedades) {
		this.novedades = novedades;
	}



   	 
	
	

}
