package edu.eci.cvds.bean;

import com.google.inject.Inject;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.factory.ServiceFactory;
import java.util.ArrayList;


@SuppressWarnings("deprecation")
@ManagedBean(name = "Novedad")
@RequestScoped
public class NovedadBean extends BasePageBean{
	
	
	
	private static final long serialVersionUID = -1071897882966043904L;
	
	@Inject
	protected ServiceHistorialEquipos service;
	
	@ManagedProperty(value = "#{param.i}")
	protected Integer i;
	
	@ManagedProperty(value = "#{param.elemento}")
	protected Integer elementoId;
	
	@ManagedProperty(value = "#{param.responsable}")
	protected Integer responsableId;
	
	@ManagedProperty(value = "#{param.equipo}")
	protected Integer equipoId;
	
	
	



	public ArrayList<Novedad> novedades;
    
    
	
    
	
	
	
	public Integer getElementoId() {
		return elementoId;
	}






	public Integer getI() {
		return i;
	}






	public void setI(Integer i) {
		this.i = i;
	}






	public void setElementoId(Integer elementoId) {
		this.elementoId = elementoId;
	}






	public Integer getResponsableId() {
		return responsableId;
	}






	public void setResponsableId(Integer responsableId) {
		this.responsableId = responsableId;
	}






	public Integer getEquipoId() {
		return equipoId;
	}






	public void setEquipoId(Integer equipoId) {
		this.equipoId = equipoId;
	}






	public ArrayList<Novedad> getNovedades() throws ExcepcionServiceHistorialEquipos {
		
		i=1;
	
		if(i==0 || i==null) {
			novedades = service.consultarNovedadporElemento(1);
		}
		else if(i==1) {
			novedades=service.consultarNovedades();
		}
		return novedades;
	}






	public void setNovedades(ArrayList<Novedad> novedades) {
		this.novedades = novedades;
	}




	public void registrarNovedad(String titulo,String detalle){
        try {
            service.registrarNovedad(new Novedad(titulo,detalle));
            
        } catch (ExcepcionServiceHistorialEquipos ex) {
            new ExcepcionServiceHistorialEquipos("No se pudo registrar novedad");
        }       
    }
    
	 
	
	

}
