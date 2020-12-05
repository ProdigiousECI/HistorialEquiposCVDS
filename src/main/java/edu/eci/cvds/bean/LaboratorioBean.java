/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.bean;

import com.google.inject.Inject;
import edu.eci.cvds.sample.entities.Equipo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.Laboratorio;
import edu.eci.cvds.sample.entities.Novedad;
//import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.factory.ServiceFactory;

import java.io.IOException;
import java.util.ArrayList;
import org.primefaces.model.chart.PieChartModel;
/**
 *
 * @author Andres Davila
 */
@ManagedBean(name = "Laboratorio")
@ApplicationScoped
//@ViewScoped
public class LaboratorioBean {
    

    private final ServiceHistorialEquipos serviceHE;
    private int filtro;
    private String filtrar="";
    public ArrayList<Laboratorio> laboratorio;
    public int laboratorioId;
    public int equipos2;
    private PieChartModel model;

    public int getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(int laboratorioId) {
        this.laboratorioId = laboratorioId;
    }
   
    
    public ArrayList<Laboratorio> getLaboratorios() throws ExcepcionServiceHistorialEquipos {
        return serviceHE.consultarLaboratorios(filtro,filtrar);
    }
    public Laboratorio obtenerLaboratorio(int n) throws ExcepcionServiceHistorialEquipos {
        return serviceHE.consultarLaboratorio(n);
    }
    public Laboratorio obtenerLaboratorio2() throws ExcepcionServiceHistorialEquipos {
        return serviceHE.consultarLaboratorio(laboratorioId);
    }
    public void ordenarLaboratorioFiltro(int i) throws ExcepcionServiceHistorialEquipos {
    	filtro=i;
    	
    }
    public void ordenarLaboratorios(String s) throws ExcepcionServiceHistorialEquipos {
		filtrar=s;
    	
    }
    public void setLaboratorios(ArrayList<Laboratorio> laboratorio) {
        this.laboratorio = laboratorio;
    }
    
    public void start(){
        
    }
    public int getCantidaDeEquipos()throws ExcepcionServiceHistorialEquipos{
        equipos2=serviceHE.consultarEquiposPorLaboratorio(laboratorioId).size();
        System.out.println(equipos2);
        return equipos2;
    }
    public LaboratorioBean(){
        serviceHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
        try{
        	filtro=1;
                filtrar="";
                laboratorio = serviceHE.consultarLaboratorios(1,filtrar);
                actualizarGrafico();
                
             
        }catch(ExcepcionServiceHistorialEquipos e){
        }
    }
    
        public void registrarLaboratorio(int idLaboratorio,String nombre, String departamento){
        try {
        	departamento=departamento.trim();
        	if(departamento.length()>0) {
	            serviceHE.registrarLaboratorio(new Laboratorio(idLaboratorio,nombre,departamento));

	        
	            showMessage("El registro del Laboratorio ha sido un exito");
        	}else {
        		showMessage("El registro del Laboratorio ha fracasado");
        	}

        } catch (ExcepcionServiceHistorialEquipos ex) {
            new ExcepcionServiceHistorialEquipos("No se pudo registrar Laboratorio");
        }       
    }
   public void cerrarLaboratorio(int id) throws ExcepcionServiceHistorialEquipos
   {
       serviceHE.cerrarLaboratorio(id);
       ArrayList<Equipo> eq = serviceHE.consultarEquipos(1,"");
       for (int i=0; i<eq.size();i++)
       {
           if(eq.get(i).getIdlaboratorio()==id)
           {
               serviceHE.desasociarEquipo(eq.get(i).getId());
           }
       }
       showMessage("Laboratorio " + id+ " cerrado");
   }

   public void showMessage(String confirmacion) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", confirmacion);     
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
   
   public String color(Laboratorio nombre) throws ExcepcionServiceHistorialEquipos, IOException {
   	String color="#FFC264";
   	if (nombre==null) {
   		color=null;
   	}else {
   		int numero=buscar(nombre);
   		
	    	if(numero%2==0) {
	    		color="#D27F00";
	    	}
                if(numero==-2)
                {
                    color="#F93D3D";
                }
   	}
   	return color;
   }
   private int buscar(Laboratorio nombre) throws ExcepcionServiceHistorialEquipos, IOException {
   	
   	int cont=0;
   	
   	for(Laboratorio l:getLaboratorios()) {
   		
                if(nombre.getActivo().equals("No")) {
   			return -2; 
   		}
   		if(l.getIdlaboratorio()==nombre.getIdlaboratorio()) {
   			return cont; 
   		}cont++;
                
   	}
   	return -1;
   }

    public PieChartModel getModel() {
        return model;
    }

    public void setModel(PieChartModel model) {
        this.model = model;
    }
   public void actualizarGrafico() throws ExcepcionServiceHistorialEquipos
   {
       model = new PieChartModel();
                ArrayList<Laboratorio> labs=getLaboratorios();
                for (Laboratorio lab:labs)
                {
                    model.set(lab.getNombre(),serviceHE.consultarEquiposPorLaboratorio(lab.getIdlaboratorio()).size());
                }
                model.setTitle("Equipos por laboratorio");
                model.setLegendPosition("w");
   }
   
    
}
