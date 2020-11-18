/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.sample.entities.Equipo;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Acer
 */
public interface EquipoMapper {
    public Equipo consultarEquipo(@Param("idequip")int id);
    
    public ArrayList<Equipo> consultarEquipos();
    
    public void registrarEquipo(@Param("equip")Equipo equip);
    
    public ArrayList<Equipo> consultarEquiposPorLaboratorio(@Param("idlab")Integer laboratorioId);
    
}
