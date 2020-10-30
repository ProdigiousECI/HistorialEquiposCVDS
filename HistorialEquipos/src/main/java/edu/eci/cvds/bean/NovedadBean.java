package edu.eci.cvds.bean;

import com.google.inject.Inject;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.factory.ServiceFactory;
import java.util.ArrayList;



public abstract class NovedadBean {
	
	@Inject
	protected ServiceHistorialEquipos service;
	
    public ArrayList<Novedad> novedades;
    
    public NovedadBean() {
    	
    }
	
    
	public ArrayList<Novedad> getNovedades() {
		return novedades;
	}




	public void setNovedades(ArrayList<Novedad> novedades) {
		this.novedades = novedades;
	}




	public void registrarNovedad(int id, String titulo,String detalle){
        try {
            service.registrarNovedad(new Novedad(id,titulo,detalle));
        } catch (ExcepcionServiceHistorialEquipos ex) {
            new ExcepcionServiceHistorialEquipos("No se pudo registrar novedad");
        }       
    }
    
	
	

}
