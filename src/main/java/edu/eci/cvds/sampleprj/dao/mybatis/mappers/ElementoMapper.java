/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.sample.entities.Elemento;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author javie
 */
public interface ElementoMapper {
    public Elemento consultarElemento(@Param("idele") int id);
    public ArrayList<Elemento> consultarElementos(@Param("ordenar") int e,@Param("filtrar") String s);
    public ArrayList<Elemento> consultarElementosTorre();
    public ArrayList<Elemento> consultarElementosPantalla();
    public ArrayList<Elemento> consultarElementosMouse();
    public ArrayList<Elemento> consultarElementosTeclado();
    public void registrarElemento(@Param("ele") Elemento ele);
    
    public void actualizarDisponibilidadElementos(@Param("torr")String torre,@Param("pant")String pantalla,@Param("mous")String mouse,@Param("Tecl")String teclado);

    public void darBajaElemento(@Param("idele") int id);
    public ArrayList<Elemento> bajaNoElemento();
	public Elemento consultarElementoPorNombre(@Param("ele") String ele);
        public ArrayList<Elemento> consultarElementosPorEquipo(@Param("ideq") int equipoId);
	public void asociarElementoAEquipo(@Param("nom")String nombre,@Param("ide") int id);
	public void eliminarAsociacion(@Param("null") int n);
        public void desasociarElementoEquipo(@Param("idequi")int id);


}
