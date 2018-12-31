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
@Table(name = "typephoto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typephoto.findAll", query = "SELECT t FROM Typephoto t")
    , @NamedQuery(name = "Typephoto.findById", query = "SELECT t FROM Typephoto t WHERE t.id = :id")
    , @NamedQuery(name = "Typephoto.findByProprie", query = "SELECT t FROM Typephoto t WHERE t.proprie = :proprie")})
public class Typephoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "proprie")
    private String proprie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private Collection<Photos> photosCollection;

    public Typephoto() {
    }

    public Typephoto(Integer id) {
        this.id = id;
    }

    public Typephoto(Integer id, String proprie) {
        this.id = id;
        this.proprie = proprie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProprie() {
        return proprie;
    }

    public void setProprie(String proprie) {
        this.proprie = proprie;
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
        if (!(object instanceof Typephoto)) {
            return false;
        }
        Typephoto other = (Typephoto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.classphoto2.classphoto2.model.Typephoto[ id=" + id + " ]";
    }
    
}
