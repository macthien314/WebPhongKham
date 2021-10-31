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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "services_invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceInvoice.findAll", query = "SELECT s FROM ServiceInvoice s"),
    @NamedQuery(name = "ServiceInvoice.findById", query = "SELECT s FROM ServiceInvoice s WHERE s.id = :id"),
    @NamedQuery(name = "ServiceInvoice.findByFee", query = "SELECT s FROM ServiceInvoice s WHERE s.fee = :fee"),
    @NamedQuery(name = "ServiceInvoice.findByCreatedDay", query = "SELECT s FROM ServiceInvoice s WHERE s.createdDay = :createdDay")})
public class ServiceInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fee")
    private Long fee;
    @Column(name = "created_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createdDay;
    
    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;
    
    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
   
    @ManyToOne
    @JoinColumn(name ="service_id")
    private Services service;
    @Transient
   
    private MultipartFile file;
    public ServiceInvoice() {
    }

    public ServiceInvoice(Integer id, Long fee, Date createdDay, Nurse nurse, Patient patient, Services service) {
        this.id = id;
        this.fee = fee;
        this.createdDay = createdDay;
        this.nurse = nurse;
        this.patient = patient;
        this.service = service;
    }

    public ServiceInvoice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Date getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Date createdDay) {
        this.createdDay = createdDay;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
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
