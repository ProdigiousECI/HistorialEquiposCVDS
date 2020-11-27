/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.sample.entities.Laboratorio;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
/**
 *
 * @author Andres Davila
 */
public interface LaboratorioMapper {
    
    public Laboratorio consultarLaboratorio(@Param("idlab") int id);
    public ArrayList<Laboratorio> consultarLaboratorios(@Param("ordenar") int e);
    public void registrarLaboratorio(@Param("lab") Laboratorio lab);
    public void cerrarLaboratorio(@Param("idlab") int id);
    
}
