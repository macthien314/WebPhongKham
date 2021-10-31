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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "prescription_drug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrescriptionDrug.findAll", query = "SELECT p FROM PrescriptionDrug p"),
    @NamedQuery(name = "PrescriptionDrug.findByUserGuide", query = "SELECT p FROM PrescriptionDrug p WHERE p.userGuide = :userGuide"),
    @NamedQuery(name = "PrescriptionDrug.findByQuantity", query = "SELECT p FROM PrescriptionDrug p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "PrescriptionDrug.findById", query = "SELECT p FROM PrescriptionDrug p WHERE p.id = :id"),
    @NamedQuery(name = "PrescriptionDrug.findByDrugDetailcol", query = "SELECT p FROM PrescriptionDrug p WHERE p.drugDetailcol = :drugDetailcol")})
public class PrescriptionDrug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "user_guide")
    private String userGuide;
    @Column(name = "quantity")
    private Integer quantity;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "drug_detailcol")
    private String drugDetailcol;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "drug")
    private Drug drug;
   
    @ManyToOne(optional = false)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    public PrescriptionDrug() {
    }

    public PrescriptionDrug(Integer id) {
        this.id = id;
    }

    public String getUserGuide() {
        return userGuide;
    }

    public void setUserGuide(String userGuide) {
        this.userGuide = userGuide;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugDetailcol() {
        return drugDetailcol;
    }

    public void setDrugDetailcol(String drugDetailcol) {
        this.drugDetailcol = drugDetailcol;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drugId) {
        this.drug = drugId;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
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
        if (!(object instanceof PrescriptionDrug)) {
            return false;
        }
        PrescriptionDrug other = (PrescriptionDrug) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wpk.pojos.PrescriptionDrug[ id=" + id + " ]";
    }
    
}
