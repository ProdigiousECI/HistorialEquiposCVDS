/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.services;

import edu.eci.cvds.sample.entities.Elemento;
import java.util.ArrayList;

/**
 *
 * @author javier
 */
public interface ServiceHistorialEquipos {
    public abstract void registrarElemento(Elemento ele) throws ExcepcionServiceHistorialEquipos;
    public abstract ArrayList<Elemento> consultarElementos() throws ExcepcionServiceHistorialEquipos;
    public abstract Elemento consultarElemento(int id) throws ExcepcionServiceHistorialEquipos;
}
