package edu.eci.cvds.bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;

@SuppressWarnings("deprecation")
@ManagedBean(name = "NovedadElemento")
@RequestScoped
public class NovedadBeanElemento{
	
	private static final long serialVersionUID = -1071897882966043904L;
	
	private ServiceHistorialEquipos service;
		
	@ManagedProperty(value = "#{param.elemento}")
	private Integer elementoId;
		
	@ManagedProperty(value = "#{param.i}")
	private Integer i;
	
	//@ManagedProperty(value = "#{param.responsable}")
	private Integer responsableId;
	
	private String titulo;
	
	private String detalle;
	
	private ArrayList<Novedad> novedades;
	
	public NovedadBeanElemento(){
            service = ServiceFactory.getInstance().getServiceHistorialEquipos();
        }
	
	public ServiceHistorialEquipos getService() {
		return service;
	}

	public void setService(ServiceHistorialEquipos service) {
		this.service = service;
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

	public ArrayList<Novedad> getNovedades() throws ExcepcionServiceHistorialEquipos, IOException {

		//ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		//context.redirect(context.getRequestContextPath() + "registrarNovedad.xhtml?elemento=" + elementoId + "&i=" + i);
		if(i==0) {

			novedades = service.consultarNovedadporElemento(elementoId);

		}
		
		else if(i==1) {
			novedades=service.consultarNovedades();
		}
		return novedades;
	}
	
	public Integer getElementoId() {
		return elementoId;
	}

	public void setElementoId(Integer elementoId) {
		this.elementoId = elementoId;
	}

	public void registrarNovedad(){
		
        try {
        	
        	Novedad n=new Novedad(titulo,detalle);
        	Elemento e=service.consultarElemento(elementoId);
        	n.setElemento(e);
            service.registrarNovedad(n);
            
        } catch (ExcepcionServiceHistorialEquipos ex) {
            new ExcepcionServiceHistorialEquipos("No se pudo registrar novedad");
        } 
    }
	
	

	

	
	

}
