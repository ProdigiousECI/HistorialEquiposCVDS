package edu.eci.cvds.bean;

import java.io.IOException;
import java.util.ArrayList;
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

import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.entities.User;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;

@SuppressWarnings("deprecation")
@ManagedBean(name = "NovedadEquipo")
//@SessionScoped
@ViewScoped
public class NovedadBeanEquipo extends NovedadBean{
	
	private static final long serialVersionUID = -1071897882966043904L;
	
	private ServiceHistorialEquipos service;
		
	private Integer equipoId;
		

	
	public NovedadBeanEquipo(){
            service = ServiceFactory.getInstance().getServiceHistorialEquipos();
        }
	public NovedadBeanEquipo(String titulo,String detalle,Integer equipoId){
    	this.titulo=titulo;
    	this.detalle=detalle;
    	this.equipoId=equipoId; 
  
    }
	
	public ServiceHistorialEquipos getService() {
		return service;
	}

	public void setService(ServiceHistorialEquipos service) {
		this.service = service;
	}


	public void setNovedades(ArrayList<Novedad> novedades) {
		this.novedades = novedades;
	}
	
	public Equipo obtenerEquipo() throws ExcepcionServiceHistorialEquipos {
		return service.consultarEquipo(equipoId);
	}

	@Override
	public ArrayList<Novedad> getNovedades() throws ExcepcionServiceHistorialEquipos, IOException {
		
		
		if(i==0) {

			novedades = service.consultarNovedadporEquipo(equipoId);

		}
		
		else if(i==1) {
			novedades=service.consultarNovedades();
		}
		return novedades;
	}
	
	public Integer getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Integer equipoId) {
		this.equipoId = equipoId;
	}

	public void registrarNovedad(){
		
		
        try {
        	titulo=titulo.trim();
        	detalle=detalle.trim();
        	if(titulo.length()>0 && detalle.length()>0) {
        		User u=new User();
                u.setCorreo(ShiroBean.getUser());
               
	        	Novedad n=new Novedad(titulo,detalle,u,service.consultarEquipo(equipoId));
	        	service.registrarNovedad(n);
	            showMessage("Tu registro de la novedad ha sido exitoso");
        	}else {
        		showMessage("Tu registro de la novedad ha fallado");
        	}
            
        } catch (ExcepcionServiceHistorialEquipos ex) {
        	showMessage("Tu registro de la novedad ha fallado");
        } 
    }
	
	
	public String obtenerElemento(Equipo equipo,String tipo) throws ExcepcionServiceHistorialEquipos {
		
		ArrayList<Elemento> ele=service.consultarElementos(1, "");
		for(Elemento elemento:ele) {
			if(elemento.getEquipo()!=null) {
				if(equipo.getId()==elemento.getEquipo().getId() && elemento.getTipo().equals(tipo)) {
					return elemento.getNombre();
				}
			}
		}
		return null;
	}
        public ArrayList<Elemento> consultarElementosPorEquipo() throws ExcepcionServiceHistorialEquipos{
            try {
        	
        	return service.consultarElementosPorEquipo(equipoId);
            
            } catch (ExcepcionServiceHistorialEquipos ex) {
                    showMessage("No se pudo hay elementos en este equipo");
            } 
            return null;
            
        }
        

	
}