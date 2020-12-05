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
    
    public ArrayList<Equipo> consultarEquipos(@Param("filtro")int filtro,@Param("filtrar")String filtrar);
    
    public void registrarEquipo(@Param("equip")Equipo equip);
    
    public ArrayList<Equipo> consultarEquiposPorLaboratorio(@Param("idlab")Integer laboratorioId);

    public Equipo consultarEquipoPorNombre(@Param("nom") String nombre);


    public void darBajaEquipo(@Param("idbaja")int id);

    public ArrayList<Equipo> consultarEquiposActivos(@Param("filtro")int filtro,@Param("filtrar")String filtrar);
    
    public void desasociarEquipo(@Param("ideq")int id);

	public void asociarEquipoALaboratorio(@Param("ineq")int in,@Param("inlab") Integer laboratorioId);
    
}
