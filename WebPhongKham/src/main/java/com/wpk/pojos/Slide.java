/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "slide")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Slide.findAll", query = "SELECT s FROM Slide s"),
    @NamedQuery(name = "Slide.findById", query = "SELECT s FROM Slide s WHERE s.id = :id"),
    @NamedQuery(name = "Slide.findByDescription", query = "SELECT s FROM Slide s WHERE s.description = :description"),
    @NamedQuery(name = "Slide.findByImage", query = "SELECT s FROM Slide s WHERE s.image = :image"),
    @NamedQuery(name = "Slide.findByTitle", query = "SELECT s FROM Slide s WHERE s.title = :title"),
    @NamedQuery(name = "Slide.findByActive", query = "SELECT s FROM Slide s WHERE s.active = :active")})
public class Slide implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
  
    @Size(min = 1, max = 100)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Column(name = "active")
    private Boolean active;
    @Transient
    @NotNull(message = "{user.file.nullErr}")
    private MultipartFile file;
    
    public Slide() {
    }

    public Slide(Integer id) {
        this.id = id;
    }

    public Slide(Integer id, String image, String title) {
        this.id = id;
        this.image = image;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
        if (!(object instanceof Slide)) {
            return false;
        }
        Slide other = (Slide) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wpk.pojos.Slide[ id=" + id + " ]";
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
