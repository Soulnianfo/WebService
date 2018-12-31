/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.DTO;

import com.classphoto2.classphoto2.PasswordMatches;
import com.classphoto2.classphoto2.ValidEmail;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Souleymane
 */
@PasswordMatches
public class UserDTO {
    
    @NotNull
    @NotEmpty
    private String username;
    
    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;
    
    @NotNull
    @NotEmpty
    
    private String password;
    private String matchingPassword;
   
    @NotNull
    @NotEmpty
    private String ville;
    
    @NotNull
    
    private Integer codePostale;
  
    @NotNull
    @NotEmpty    
    private String rue;
    
    @NotNull
    
    private Integer numero;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(Integer codePostale) {
        this.codePostale = codePostale;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    

    
}
