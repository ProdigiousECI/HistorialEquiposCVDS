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

import java.io.IOException;
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
import java.util.HashMap;
import java.util.Map;
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
    private int indice; 

    private Map<Integer, Boolean> confirmar = new HashMap<Integer, Boolean>();
    private Map<Integer, Boolean> salvar = new HashMap<Integer, Boolean>();
    private int filtro;
    private String filtrar;
    public Integer laboratorioId;
    private ArrayList<String> images=new ArrayList<String>();
    public ArrayList<Equipo> equiposLab;
    
    
    
    public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public int getFiltro() {
		return filtro;
	}

	public void setFiltro(int filtro) {
		this.filtro = filtro;
	}

	public String getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(String filtrar) {
		this.filtrar = filtrar;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public ArrayList<Equipo> getEquipos() throws ExcepcionServiceHistorialEquipos {
		for(Integer i:salvar.keySet()) {
        	confirmar.put(i,salvar.get(i));
        }
		
		if(indice==0 ) {
			equipos= serviceHE.consultarEquiposActivos(filtro, filtrar);
		}else if(indice==1) {
			equipos= serviceHE.consultarEquipos(filtro, filtrar);
		}
		return equipos;
        
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    public EquipoBean() throws ExcepcionServiceHistorialEquipos{
        serviceHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
      
        	filtrar="";
        	filtro=1;
             
            images.add("eci1.jpg");
            images.add("boton1.JPG");
            images.add("equipo.jpg");
            images.add("eci2.jpg");
            images.add("prodigious.png");
            
            equipos = serviceHE.consultarEquipos(filtro,filtrar);  
            
            for(Equipo e:equipos) {
            	
            	salvar.put(e.getId(),false);
            }
    }
    
  
    public void ordenarEquipos(String s) throws ExcepcionServiceHistorialEquipos {
		filtrar=s;
    	equipos=getEquipos();
    }
    
    
    public void start(){
        
    }
    public void ordenarEquiposporFiltro(int i) throws ExcepcionServiceHistorialEquipos {
    	filtro=i;
    	equipos=serviceHE.consultarEquipos(filtro,filtrar);	
    }
    private boolean verificacionNombre(String nombre) throws ExcepcionServiceHistorialEquipos {
    	equipos=getEquipos();
    	for(Equipo e:equipos) {
    		if(e.getNombre().equals(nombre)) {
    			return true;
    		}
    	}
    	return false;
    }
    public void registrarEquipo(int id, String nombre, String torre, String pantalla, String mouse, String teclado){
   
        try {
        	nombre=nombre.trim();
        	if(nombre.length()>0 && !verificacionNombre(nombre) && torre!="" && pantalla!="" && mouse!="" && teclado!="") {
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
	            
	            serviceHE.registrarNovedad(new Novedad("Elemento asociado","asociado con "+e.getNombre(),user,equipo));
	            serviceHE.registrarNovedad(new Novedad("Elemento asociado","asociado con "+e.getNombre(),user,equipo));
	            serviceHE.registrarNovedad(new Novedad("Elemento asociado","asociado con "+e.getNombre(),user,equipo));
	            serviceHE.registrarNovedad(new Novedad("Elemento asociado","asociado con "+e.getNombre(),user,equipo));
	            serviceHE.asociarElementoAEquipo(torre,equipo.getId());
	            serviceHE.asociarElementoAEquipo(pantalla,equipo.getId());
	            serviceHE.asociarElementoAEquipo(mouse,equipo.getId());
	            serviceHE.asociarElementoAEquipo(teclado,equipo.getId());
	            salvar.put(e.getId(), false);
	            equipos = getEquipos();
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
    public String color(Equipo nombre) throws ExcepcionServiceHistorialEquipos {
    	String color="#FFC264";
    	
    	if(nombre==null) {
    		color=null;
    	}else{
	    	int numero=buscar(nombre);
	    	if(numero%2==0) {
	    		color="#D27F00";
	    	}if(numero==-2) {
	    		
	    		color="#F93D3D";
	    	}if(numero==-3) {
	    		
	    		color="#ADFF81";
	    	}
    	}
    	return color;
    }
    private int buscar(Equipo nombre) throws ExcepcionServiceHistorialEquipos {
    	
    	int cont=0;
    	
    	for(Equipo e:equipos) {
    		
    		if(nombre.getActivo().equals("no")) {
    			
    			return -2;
    		}if(nombre.getLaboratorio()==null) {
    			return -3;
    		}
    		if(nombre.getId()==e.getId()) {
    			return cont; 
    		}cont++;
    	}
    	return -1;
    }
    
    public String darBajaElementos(int id,String mensaje) throws ExcepcionServiceHistorialEquipos {
        Equipo e=serviceHE.consultarEquipo(id);
        
        if(e.getActivo().equals("no")){

        	if(e.getActivo()==null) {
                //serviceHE.darBajaElemento(id);
                //User user=new User();
        		//user.setCorreo(ShiroBean.getUser());
        		
                //serviceHE.registrarNovedad(new Novedad(e.getNombre()+" dado de Baja","Se ha dado de baja el elemento con id "+e.getId(),user,serviceHE.consultarElemento(id)));
        		
               
        	}else {
        		mensaje+="Elemento " + e.getNombre()+ " con id " +id+",";
        	}
              
        }else
        {
        	mensaje+="Elemento " + e.getNombre()+ " con id " +id+",";
        }
        return mensaje;
    }
    
    public void multiplesBajas() throws ExcepcionServiceHistorialEquipos, IOException {
    	String mensaje="";
    	for(Integer in:salvar.keySet()) {
    		
    		if(salvar.get(in)) {
    			System.out.println(in);
    			//mensaje=darBajaElementos(in,mensaje);
    			salvar.put(in,false);
    		}
    		
    	
    	}
    	//ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    	//context.redirect(context.getRequestContextPath() + "elemento.xhtml");
    	if(mensaje!="") {
    		showMessage("Los elementos: "+mensaje +"no se pudieron dar de baja");
    	}else {
    		showMessage("Todos los elementos se han dado de baja exitosamente");
    	}
    	
    	
    }
    public void setConfirmar(int id){
    	salvar.put(id,!salvar.get(id));
    }
    public Map<Integer,Boolean> getConfirmar(){
    	return confirmar;
    	
    }
  
    
}
