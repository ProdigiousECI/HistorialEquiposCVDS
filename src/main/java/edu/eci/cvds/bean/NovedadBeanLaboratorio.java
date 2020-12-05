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

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.primefaces.PrimeFaces;

import com.google.inject.Inject;

import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.entities.User;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;

@SuppressWarnings("deprecation")
@ManagedBean(name = "NovedadElemento")

//@SessionScoped
@ViewScoped
public class NovedadBeanLaboratorio extends NovedadBean{
	
	private static final long serialVersionUID = -1071897882966043904L;
	
	private ArrayList<String> images=new ArrayList<String>();
		
	private Integer laboratorioId;

	
		
	public NovedadBeanLaboratorio(){
        service = ServiceFactory.getInstance().getServiceHistorialEquipos();
        images=new ArrayList<String>();
        images.add("cpu1.png");
        images.add("cpu2.png");
        images.add("cpu3.png");
        images.add("cpu4.png");
        images.add("cpu5.jpg");
      
        }
	public NovedadBeanLaboratorio(Integer laboratorioId){
        	
        	this.laboratorioId=laboratorioId;
      
        }
	
	
	
	public ArrayList<String> getImages() {
		return images;
	}


	public void setImages(ArrayList<String> images) {
		this.images = images;
	}
	
	public Elemento obtenerElemento() throws ExcepcionServiceHistorialEquipos {
		return service.consultarElemento(laboratorioId);
	}



	@Override
	public ArrayList<Novedad> getNovedades() throws ExcepcionServiceHistorialEquipos, IOException {
		
		//ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		//context.redirect(context.getRequestContextPath() + "registrarNovedad.xhtml?elemento=" + elementoId + "&i=" + i);
		
		if(i==0) {

			novedades = service.consultarNovedadporElemento(laboratorioId);

		}
		
		else if(i==1) {
			novedades=service.consultarNovedades();
		}
		return novedades;
	}
	
	public Integer getElementoId() {
		return laboratorioId;
	}
	///public void setEliminar(boolean) {
		//return 
	//}

	public void setElementoId(Integer elementoId) {
		this.laboratorioId = elementoId;
	}
	
     
        
	
    }
