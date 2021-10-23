/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author macth
 */
@Entity
@Table(name = "service_invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceInvoice.findAll", query = "SELECT s FROM ServiceInvoice s"),
    @NamedQuery(name = "ServiceInvoice.findById", query = "SELECT s FROM ServiceInvoice s WHERE s.id = :id"),
    @NamedQuery(name = "ServiceInvoice.findByFee", query = "SELECT s FROM ServiceInvoice s WHERE s.fee = :fee"),
    @NamedQuery(name = "ServiceInvoice.findByCreatedDay", query = "SELECT s FROM ServiceInvoice s WHERE s.createdDay = :createdDay")})
public class ServiceInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "fee")
    private String fee;
    @Column(name = "created_day")
    @Temporal(TemporalType.DATE)
    private Date createdDay;

    public ServiceInvoice() {
    }
    @Transient
   
    private MultipartFile file;
    public ServiceInvoice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public Date getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Date createdDay) {
        this.createdDay = createdDay;
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
        if (!(object instanceof ServiceInvoice)) {
            return false;
        }
        ServiceInvoice other = (ServiceInvoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wpk.pojos.ServiceInvoice[ id=" + id + " ]";
    }
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
