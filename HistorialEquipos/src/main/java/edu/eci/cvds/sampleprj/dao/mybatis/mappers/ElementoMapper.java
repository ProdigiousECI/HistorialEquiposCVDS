/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.sample.entities.Elemento;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author javie
 */
public interface ElementoMapper {
    public Elemento consultarElemento(@Param("idele")int id);
    public void registrarElemento(@Param("ele")Elemento ele);
}