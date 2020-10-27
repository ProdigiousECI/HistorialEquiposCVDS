/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.entities;

import java.io.Serializable;

/**
 *
 * @author javie
 */
public class User implements Serializable{

    private final String passwordd;
    private final String nick;
    
    public User(String nick, String passwordd)
    {
        this.nick = nick;
        this.passwordd = passwordd;
    }
}
