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
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.Elemento;
//import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.factory.ServiceFactory;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
@ManagedBean(name = "Elemento")
@ApplicationScoped
//@ViewScoped
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

    public ArrayList<Elemento> noDadosDeBaja;

    private ArrayList<String> images=new ArrayList<String>();
    //public ArrayList<Equipo> equipos;

    public ArrayList<Elemento> getElementos() throws ExcepcionServiceHistorialEquipos {
        
        return serviceHE.consultarElementos(filtro);
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
    	elementos=serviceHE.consultarElementos(filtro);
    }

    public void darBajaElemento(int id) throws ExcepcionServiceHistorialEquipos {
        Elemento e=obtenerElemento(id);
        if("no".equals(e.getBaja()))
        {
            int input = JOptionPane.showConfirmDialog(null, "Esta seguro de dar de baja el elemento "+id+"?");
            if(input==0)
            {
                serviceHE.darBajaElemento(id); 
                showMessage("Elemento "+ e.getNombre()+ " con id " +id+" ha sido dado de baja");
                novedadElemento.setElementoId(id);
                novedadElemento.registrarNovedad(e.getNombre()+" dado de Baja", "Se ha dado de baja el elemento con id "+e.getId());
            }   
        }else
        {
            showMessage("Elemento " + e.getNombre()+ " con id " +id+" ya se encuentra dado de baja");
        }
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
            elementos = serviceHE.consultarElementos(1);          
        }catch(ExcepcionServiceHistorialEquipos e){
        }
    }
    
    public void start(){
        
    }
    
    public void registrarElemento(String nombre, String tipo){
        try {
        	nombre=nombre.trim();
        	if(nombre.length()>0) {
	            serviceHE.registrarElemento(new Elemento(nombre,tipo));
	            
	            showMessage("El registro del elemento ha sido un exito");
        	}else {
        		showMessage("El registro del elemento ha fracasado");
        	}

        } catch (ExcepcionServiceHistorialEquipos ex) {
            new ExcepcionServiceHistorialEquipos("No se pudo registrar cliente");
        }       
    }

    
    
    public void showMessage(String confirmacion) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", confirmacion);     
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
}