/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Souleymane
 */
@Entity
@Table(name = "photos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photos.findAll", query = "SELECT p FROM Photos p")
    , @NamedQuery(name = "Photos.findById", query = "SELECT p FROM Photos p WHERE p.id = :id")
    , @NamedQuery(name = "Photos.findByDateTake", query = "SELECT p FROM Photos p WHERE p.dateTake = :dateTake")})
public class Photos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_take")
    @Temporal(TemporalType.DATE)
    private Date dateTake;
    @JoinColumn(name = "child_id", referencedColumnName = "id")
    @ManyToOne
    private Children childId;
    @JoinColumn(name = "type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Typephoto type;
    @JoinColumn(name = "classes_id", referencedColumnName = "id")
    @ManyToOne
    private Classes classesId;
    @Basic(optional = false)
    @Column(name = "data")
    private byte[] data;
    
    @Basic(optional = false)
    @Column(name = "label")
    private String label;
    
    @Basic(optional = false)
    @Column(name = "filetype")
    private String Filetype;
    
    @JoinColumn(name = "photograph_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Photographers photographId;

    public Photos() {
    }

    public Photos(Integer id) {
        this.id = id;
    }

    public Photos(Integer id, Date dateTake) {
        this.id = id;
        this.dateTake = dateTake;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTake() {
        return dateTake;
    }

    public void setDateTake(Date dateTake) {
        this.dateTake = dateTake;
    }

    public Children getChildId() {
        return childId;
    }

    public void setChildId(Children childId) {
        this.childId = childId;
    }

    public Typephoto getType() {
        return type;
    }

    public void setType(Typephoto type) {
        this.type = type;
    }

    public Classes getClassesId() {
        return classesId;
    }

    public void setClassesId(Classes classesId) {
        this.classesId = classesId;
    }

    public Photographers getPhotographId() {
        return photographId;
    }

    public void setPhotographId(Photographers photographId) {
        this.photographId = photographId;
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
        if (!(object instanceof Photos)) {
            return false;
        }
        Photos other = (Photos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.classphoto2.classphoto2.model.Photos[ id=" + id + " ]";
    }

	

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getFiletype() {
		return Filetype;
	}

	public void setFiletype(String filetype) {
		Filetype = filetype;
	}
    
}
