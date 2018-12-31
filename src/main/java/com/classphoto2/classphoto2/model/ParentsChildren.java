/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Souleymane
 */
@Entity
@Table(name = "parents_children")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParentsChildren.findAll", query = "SELECT p FROM ParentsChildren p")
    , @NamedQuery(name = "ParentsChildren.findById", query = "SELECT p FROM ParentsChildren p WHERE p.id = :id")})
public class ParentsChildren implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "child_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Children childId;
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parents parentId;

    public ParentsChildren() {
    }

    public ParentsChildren(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Children getChildId() {
        return childId;
    }

    public void setChildId(Children childId) {
        this.childId = childId;
    }

    public Parents getParentId() {
        return parentId;
    }

    public void setParentId(Parents parentId) {
        this.parentId = parentId;
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
        if (!(object instanceof ParentsChildren)) {
            return false;
        }
        ParentsChildren other = (ParentsChildren) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.classphoto2.classphoto2.model.ParentsChildren[ id=" + id + " ]";
    }
    
}
