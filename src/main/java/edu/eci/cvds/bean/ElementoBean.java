/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.bean;

import com.google.inject.Inject;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.entities.Novedad;
import edu.eci.cvds.sample.entities.User;
//import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.factory.ServiceFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


/**
 *
 * @author javier
 */
@ManagedBean(name = "Elemento")
//@ApplicationScoped
@ViewScoped
public class ElementoBean{   
    
    /*
                    <!--p:selectOneMenu id="Tipo" binding="#{tipo}" style="width:125px">
                    <p:selectOneMenu id="city" value="#{Elemento.equipos}" effect="fold" editable="true">
                    <f:selectItem itemLabel="Select One" itemValue="" />
                    <f:selectItems value="#{Elemento.nombre}" />
                    </p:selectOneMenu>
                </p:selectOneMenu-->
    */
    
    
    private final ServiceHistorialEquipos serviceHE;
    private int filtro;
    @Inject
    private NovedadBeanElemento novedadElemento;
    public ArrayList<Elemento> elementos;
    private Map<Integer, Boolean> confirmar = new HashMap<Integer, Boolean>();
    private Map<Integer, Boolean> salvar = new HashMap<Integer, Boolean>();
    private String filtrar="";
    public ArrayList<Elemento> noDadosDeBaja;

    private ArrayList<String> images=new ArrayList<String>();
    //public ArrayList<Equipo> equipos;

    public ArrayList<Elemento> getElementos() throws ExcepcionServiceHistorialEquipos, InterruptedException {     
    	for(Integer i:salvar.keySet()) {
        	confirmar.put(i,salvar.get(i));
        }
    	
        return serviceHE.consultarElementos(filtro,filtrar);
    }
    
    public String getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(String filtrar) {
		this.filtrar = filtrar;
	}

	public List<String> getElementosTorre()throws ExcepcionServiceHistorialEquipos{
        //System.out.println(serviceHE.consultarElementosTorre());
        return serviceHE.consultarElementosTorre().stream().map(elemento -> elemento.getNombre()).collect(Collectors.toList());
    }
    public List<String> getElementosPantalla()throws ExcepcionServiceHistorialEquipos{
        return serviceHE.consultarElementosPantalla().stream().map(elemento -> elemento.getNombre()).collect(Collectors.toList());
    }
    public List<String> getElementosMouse()throws ExcepcionServiceHistorialEquipos{
        return serviceHE.consultarElementosMouse().stream().map(elemento -> elemento.getNombre()).collect(Collectors.toList());
    }
    public List<String> getElementosTeclado()throws ExcepcionServiceHistorialEquipos{
        return serviceHE.consultarElementosTeclado().stream().map(elemento -> elemento.getNombre()).collect(Collectors.toList());
    }
    public Elemento obtenerElemento(int n) throws ExcepcionServiceHistorialEquipos {
        return serviceHE.consultarElemento(n);
    }
    
    
    public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public void ordenarElementosporFiltro(int i) throws ExcepcionServiceHistorialEquipos {
    	filtro=i;
    	
    }
	public void ordenarElementos(String s) throws ExcepcionServiceHistorialEquipos {
		filtrar=s;
    	
    }
    public void darBajaElemento(int id) throws ExcepcionServiceHistorialEquipos {
    	String mensaje="";
        Elemento e=obtenerElemento(id);
    
        if(e.getBaja().equals("no")){

        	if(e.getEquipo()==null) {
                serviceHE.darBajaElemento(id);
                User user=new User();
        		user.setCorreo(ShiroBean.getUser());
        		
                serviceHE.registrarNovedad(new Novedad(e.getNombre()+" dado de Baja","Se ha dado de baja el elemento con id "+e.getId(),user,serviceHE.consultarElemento(id)));
 
                mensaje+="Elemento "+ e.getNombre()+ " con id " +id+" ha sido dado de baja";
        	}else {
        		mensaje+="Elemento " + e.getNombre()+ " con id " +id+" ya se encuentra ocupado ";
        	}
              
        }else
        {
        	mensaje+="Elemento " + e.getNombre()+ " con id " +id+" ya se encuentra dado de baja";
        }
        showMessage(mensaje);
    }
    public String darBajaElementos(int id,String mensaje) throws ExcepcionServiceHistorialEquipos {
        Elemento e=obtenerElemento(id);
    
        if(e.getBaja().equals("no")){

        	if(e.getEquipo()==null) {
                serviceHE.darBajaElemento(id);
                User user=new User();
        		user.setCorreo(ShiroBean.getUser());
        		
                serviceHE.registrarNovedad(new Novedad(e.getNombre()+" dado de Baja","Se ha dado de baja el elemento con id "+e.getId(),user,serviceHE.consultarElemento(id)));
 
               
        	}else {
        		mensaje+="Elemento " + e.getNombre()+ " con id " +id+",";
        	}
              
        }else
        {
        	mensaje+="Elemento " + e.getNombre()+ " con id " +id+",";
        }
        return mensaje;
    }
    
    

    public int getFiltro() {
        return filtro;
    }

    public void setFiltro(int filtro) {
        this.filtro = filtro;
    }

    public ArrayList<Elemento> getNoDadosDeBaja() {
        return noDadosDeBaja;
    }

    public void setNoDadosDeBaja(ArrayList<Elemento> noDadosDeBaja) {
        this.noDadosDeBaja = noDadosDeBaja;
    }

    public void bajaNoElemento() throws ExcepcionServiceHistorialEquipos 
    {
        noDadosDeBaja=serviceHE.bajaNoElemento();
    }
    
    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }
    
    public ElementoBean(){
        serviceHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
        images.add("prodigious.png");
        images.add("logo2.png");
        images.add("cpu3.png");
        images.add("raton.png");
        images.add("pantalla.png");

        
        try{
        	filtro=1;
        	filtrar="";
            elementos = serviceHE.consultarElementos(1,filtrar);  
            for(Elemento e:elementos) {
            	salvar.put(e.getId(),false);
            }
           
        }catch(ExcepcionServiceHistorialEquipos e){
        }
    }
    
    public void start(){
        
    }
 
    public void setConfirmar(int id){
    	salvar.put(id,!salvar.get(id));
    }
    public Map<Integer,Boolean> getConfirmar(){
    	return confirmar;
    	
    }
   
    public void registrarElemento(String nombre, String tipo){
        try {
        	nombre=nombre.trim();
        	if(nombre.length()>0 && !verificacionNombre(nombre)) {
        		Elemento e=new Elemento(nombre,tipo);
	            serviceHE.registrarElemento(e);
	            
	            e=serviceHE.consultarElementoPorNombre(nombre);
	            
	            novedadElemento=new NovedadBeanElemento("nuevo elemento","Es una "+tipo+" ",e.getId());
                novedadElemento.registrarNovedad();
                salvar.put(e.getId(), false);
              
	            showMessage("El registro del elemento ha sido un exito");
        	}else {
        		showMessage("El registro del elemento ha fracasado");
        	}

        } catch (ExcepcionServiceHistorialEquipos ex) {
            new ExcepcionServiceHistorialEquipos("No se pudo registrar cliente");
        }       
    }

    private boolean verificacionNombre(String nombre) {
    	for(Elemento e:elementos) {
    		if(e.getNombre().equals(nombre)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public void showMessage(String confirmacion) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", confirmacion);     
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    public String color(Elemento nombre) {
    	String color="#FFC264";
    	if (nombre==null) {
    		color=null;
    	}else {
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
    private int buscar(Elemento nombre) {
    	int cont=0;
    	for(Elemento e:elementos) {
    		if(nombre.getBaja().equals("si")) {
    			
    			return -2;
    		}if(nombre.getEquipo()==null) {
    			return -3;
    		}
    		if(nombre.getId()==e.getId()) {
    			return cont; 
    		}cont++;
    	}
    	return -1;
    }
    public void multiplesBajas() throws ExcepcionServiceHistorialEquipos, IOException {
    	String mensaje="";
    	for(Integer in:salvar.keySet()) {
    		
    		if(salvar.get(in)) {
    			
    			mensaje=darBajaElementos(in,mensaje);
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
    
   
}
