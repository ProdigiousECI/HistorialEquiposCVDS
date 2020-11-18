/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.subject.Subject;
import java.io.IOException;
import java.io.Serializable;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 *
 * @author Andres Davila 
 */
@SuppressWarnings("deprecation")
@ManagedBean(name="shBean")
@ViewScoped
public class ShiroBean implements Serializable{
    private String userName;
    private String userPassword;
    private boolean rememberMe;
    private String pagina;
    private Subject currentUser;
    
    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rme) {
        rememberMe = rme;
    }
    
    /**
     * Metodo que realiza el login del usuario y verifica sus credenciales
     */
    public void loginUser()
    {
        try 
        {
            currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName,userPassword,true);
            currentUser.login(token);
            currentUser.getSession().setAttribute("Correo",userName);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/menu.xhtml");
        } catch (UnknownAccountException e) {
            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no registrado", "Este usuario no se encuentra en la base de datos "));
        } catch (IncorrectCredentialsException e) {
            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña incorrecta", "La contraseña ingresada no es correcta"));
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fallo en servidor", "Error"));
        }
    }
    public void logOut()
    {
        SecurityUtils.getSubject().logout();
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Index.xhtml");
        }catch (IOException ex) {
        }
    }
        /**
     * Metodo que verifica si el usuario está en sesión
     */
    public void isLogged(){
        if (SecurityUtils.getSubject().getSession().getAttribute("Correo") != null){
            try{
            	
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/elemento.xhtml");

            }catch (IOException e){
                FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al redireccionar","Ocurrio un error en el servidor"));
            }
        }
      
    }
        /**
     * Obtiene el nombre del usuario en la sesión actual
     * @return correo del usuario
     */
    public static String getUser(){
        return (String) SecurityUtils.getSubject().getSession().getAttribute("Correo");
    }
}
