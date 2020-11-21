/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.bean;

import com.google.inject.Inject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.PrimeFaces;
import java.lang.String;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.entities.User;
import javax.faces.bean.ViewScoped;
import edu.eci.cvds.sample.factory.ServiceFactory;
import java.util.ArrayList;
/**
 *
 * @author javier
 */
@ManagedBean(name = "Equipo")
/*@ApplicationScoped*/
@ViewScoped
public class EquipoBean{   
    
    /*
                    <!--p:selectOneMenu id="Tipo" binding="#{tipo}" style="width:125px">
                    <p:selectOneMenu id="city" value="#{Elemento.equipos}" effect="fold" editable="true">
                    <f:selectItem itemLabel="Select One" itemValue="" />
                    <f:selectItems value="#{Elemento.nombre}" />
                    </p:selectOneMenu>
                </p:selectOneMenu-->
    */
    
    
    private final ServiceHistorialEquipos serviceHE;
    public ArrayList<Equipo> equipos;
    private NovedadBeanEquipo novedadEquipo;
    private NovedadBeanElemento novedadElemento;
    public Integer laboratorioId;
    private ArrayList<String> images=new ArrayList<String>();
    public ArrayList<Equipo> equiposLab;
    
    public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public ArrayList<Equipo> getEquipos() {
		
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    public EquipoBean(){
        serviceHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
        try{
            equipos = serviceHE.consultarEquipos();  
            images.add("eci1.jpg");
            images.add("boton1.JPG");
            images.add("equipo.jpg");
            images.add("eci2.jpg");
            images.add("prodigious.png");
        }catch(ExcepcionServiceHistorialEquipos e){
        }
    }
    
    public void start(){
        
    }
    
    public void registrarEquipo(int id, String nombre, String torre, String pantalla, String mouse, String teclado){
   
        try {
        	nombre=nombre.trim();
        	if(nombre.length()>0) {
        		Equipo e=new Equipo(id,nombre);
	            serviceHE.registrarEquipo(new Equipo(id,nombre));
                serviceHE.actualizarDisponibilidadElementos(torre,pantalla,mouse,teclado);
                e=serviceHE.consultarEquipoPorNombre(nombre);
                
                User user=new User();
        		user.setCorreo(ShiroBean.getUser());
        		Equipo equipo=serviceHE.consultarEquipoPorNombre(nombre);
        		serviceHE.registrarNovedad(new Novedad("nuevo equipo","registro de "+e.getNombre(),user,equipo));
	            serviceHE.registrarNovedad(new Novedad("Elemento asociado","asociado con "+e.getNombre(),user,serviceHE.consultarElementoPorNombre(torre)));
	            serviceHE.registrarNovedad(new Novedad("Elemento asociado","asociado con "+e.getNombre(),user,serviceHE.consultarElementoPorNombre(pantalla)));
	            serviceHE.registrarNovedad(new Novedad("Elemento asociado","asociado con "+e.getNombre(),user,serviceHE.consultarElementoPorNombre(mouse)));
	            serviceHE.registrarNovedad(new Novedad("Elemento asociado","asociado con "+e.getNombre(),user,serviceHE.consultarElementoPorNombre(teclado)));
	            serviceHE.asociarElementoAEquipo(torre,equipo.getId());
	            serviceHE.asociarElementoAEquipo(pantalla,equipo.getId());
	            serviceHE.asociarElementoAEquipo(mouse,equipo.getId());
	            serviceHE.asociarElementoAEquipo(teclado,equipo.getId());
	            
	            equipos = serviceHE.consultarEquipos();
	            showMessage("El registro del equipo ha sido un exito");
        	}else {
        		showMessage("El registro del equipo ha fracasado");
        	}

        } catch (ExcepcionServiceHistorialEquipos ex) {
            new ExcepcionServiceHistorialEquipos("No se pudo registrar equipo");
        }       
    }
    
    public ArrayList<Equipo> getEquiposPorLaboratorio() throws ExcepcionServiceHistorialEquipos{

            return serviceHE.consultarEquiposPorLaboratorio(laboratorioId);
        
    }
    public void showMessage(String confirmacion) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", confirmacion);     
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public Integer getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(Integer laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public ArrayList<Equipo> getEquiposLab() {
        return equiposLab;
    }

    public void setEquiposLab(ArrayList<Equipo> equiposLab) {
        this.equiposLab = equiposLab;
    }
    public String color(Equipo nombre) {
    	String color="#FFC264";
    	
    	int numero=equipos.indexOf(nombre);
    	if (numero==-1) {
    		color=null;
    	}
    	
    	else if(numero%2==0) {
    		color="#D27F00";
    	}
    	return color;
    }
    
}
