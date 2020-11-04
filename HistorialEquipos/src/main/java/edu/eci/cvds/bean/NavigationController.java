/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author Andres Davila 
 */
@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController {
    public String paginaAutenticar() {
        return "Autenticacion";
    }
    
    public String paginaInicio(){
        return "Index";
    }
}
