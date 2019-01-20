package com.classphoto2.classphoto2.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.classphoto2.classphoto2.ValidEmail;
import com.classphoto2.classphoto2.model.Children;
import com.classphoto2.classphoto2.model.Classes;
import com.classphoto2.classphoto2.model.Genre;

public class parentDTO {
	 @NotNull
	    private String firstName;
	    
	    @NotNull
	    private String lastName;
	    
	    @NotNull
	    @NotEmpty
	    private String username;
	    

	    private Children childId;
	    
	    private Genre genreId;
	    
	    public Genre getGenreId() {
			return genreId;
		}

		public void setGenreId(Genre genreId) {
			this.genreId = genreId;
		}

		public Children getChildId() {
			return childId;
		}

		public void setChildId(Children childId) {
			this.childId = childId;
		}

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

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
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
