/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Souleymane
 */
@Entity
@Table(name = "photographers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photographers.findAll", query = "SELECT p FROM Photographers p")
    , @NamedQuery(name = "Photographers.findById", query = "SELECT p FROM Photographers p WHERE p.id = :id")
    , @NamedQuery(name = "Photographers.findByFirstName", query = "SELECT p FROM Photographers p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Photographers.findByLastName", query = "SELECT p FROM Photographers p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Photographers.findByAddressId", query = "SELECT p FROM Photographers p WHERE p.addressId = :addressId")})
public class Photographers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "address_id")
    private int addressId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "photographId")
    private Collection<Schooladmins> schooladminsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "photographId")
    private Collection<Photos> photosCollection;

    public Photographers() {
    }

    public Photographers(Integer id) {
        this.id = id;
    }

    public Photographers(Integer id, String firstName, String lastName, int addressId, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressId = addressId;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Schooladmins> getSchooladminsCollection() {
        return schooladminsCollection;
    }

    public void setSchooladminsCollection(Collection<Schooladmins> schooladminsCollection) {
        this.schooladminsCollection = schooladminsCollection;
    }

    @XmlTransient
    public Collection<Photos> getPhotosCollection() {
        return photosCollection;
    }

    public void setPhotosCollection(Collection<Photos> photosCollection) {
        this.photosCollection = photosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photographers)) {
            return false;
        }
        Photographers other = (Photographers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.classphoto2.classphoto2.model.Photographers[ id=" + id + " ]";
    }
    
}
