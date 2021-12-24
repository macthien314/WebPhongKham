/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.pojos;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "medical")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medical.findAll", query = "SELECT m FROM Medical m"),
    @NamedQuery(name = "Medical.findById", query = "SELECT m FROM Medical m WHERE m.id = :id"),
    @NamedQuery(name = "Medical.findByName", query = "SELECT m FROM Medical m WHERE m.name = :name"),
    @NamedQuery(name = "Medical.findByDescription", query = "SELECT m FROM Medical m WHERE m.description = :description"),
    @NamedQuery(name = "Medical.findByImage", query = "SELECT m FROM Medical m WHERE m.image = :image")})
public class Medical implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Size(min = 1, max = 45,message = "medical.name.check")
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Size(min = 30, max = 4000,message = "medical.description.check")
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "medical")
    private List<Doctor> doctor;
   
    @OneToMany(mappedBy = "medical")
    private List<Nurse> nurse;
    @Transient
   
    private MultipartFile file;
    public Medical() {
    }

    public Medical(Integer id) {
        this.id = id;
    }

    public Medical(Integer id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public List<Doctor> getDoctorList() {
        return doctor;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctor = doctorList;
    }

    

    @XmlTransient
    public List<Nurse> getNurseList() {
        return nurse;
    }

    public void setNurseList(List<Nurse> nurseList) {
        this.nurse = nurseList;
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
        if (!(object instanceof Medical)) {
            return false;
        }
        Medical other = (Medical) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wpk.pojos.Medical[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

   
    
}
