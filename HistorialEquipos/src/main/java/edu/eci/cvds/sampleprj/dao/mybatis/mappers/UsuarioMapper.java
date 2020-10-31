/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import edu.eci.cvds.sample.entities.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Andres Davila 
 */


public interface UsuarioMapper {
    /**
     * Consulta usuario dado
     * @param correo String correo del Usuario
     * @return Usuario correspondiente 
     */
    public User consultarUsuario(@Param("corr")String correo );
    
    /**
     * Consulta todos los usuarios
     * @return Lista de todos los usuarios 
     */
    public List<User> consultarUsuarios();
    
}
