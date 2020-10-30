package edu.eci.cvds.bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;

@ManagedBean(name = "NovedadElemento")
@RequestScoped
public class NovedadBeanElemento extends NovedadBean{
	
	
	
	@ManagedProperty(value = "#{param.elementos}")
	private Integer elementosId=1;
	



	public Integer getElementosId() {
		return elementosId;
	}




	public void setElementosId(Integer elementosId) {
		this.elementosId = elementosId;
	}




	public NovedadBeanElemento() {
		service = ServiceFactory.getInstance().getServiciosFactory();
		try {
			
			novedades = service.consultarNovedadporElemento(elementosId);
		
			
		} catch (ExcepcionServiceHistorialEquipos e) {
			e.printStackTrace();
		}
		
	}
	
	

}
