package edu.eci.cvds.bean;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;

@SuppressWarnings("deprecation")
@ManagedBean(name = "NovedadEquipo")
public class NovedadBeanEquipo extends NovedadBean{
	
	@ManagedProperty(value = "#{param.equipo}")
	private Integer equipoId;
	
	
	public NovedadBeanEquipo() {
		super();
		
	}
	
	public ArrayList<Novedad> getNovedades() throws ExcepcionServiceHistorialEquipos {
	
	
		
		
		if(i==null || i==0) {
			
				
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
	    	System.out.println(equipoId);
	    	
	        service.registrarNovedad(new Novedad(titulo,detalle));
	        
	    } catch (ExcepcionServiceHistorialEquipos ex) {
	        new ExcepcionServiceHistorialEquipos("No se pudo registrar novedad");
	    }       
	}
	




	
	
	

}
