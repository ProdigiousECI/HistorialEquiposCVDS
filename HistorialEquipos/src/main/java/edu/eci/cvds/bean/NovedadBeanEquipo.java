package edu.eci.cvds.bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;

@ManagedBean(name = "NovedadEquipo")
@RequestScoped
public class NovedadBeanEquipo extends NovedadBean{
	
	
	
	@ManagedProperty(value = "#{param.equipos}")
	private Integer equipoId=1;
	



	public Integer getEquipoId() {
		return equipoId;
	}




	public void setEquipoId(Integer equipoId) {
		this.equipoId = equipoId;
	}




	public NovedadBeanEquipo() {
		service = ServiceFactory.getInstance().getServiciosFactory();
		try {
			
			novedades = service.consultarNovedadporEquipo(equipoId);
		
			
		} catch (ExcepcionServiceHistorialEquipos e) {
			e.printStackTrace();
		}
		
	}
	
	

}
