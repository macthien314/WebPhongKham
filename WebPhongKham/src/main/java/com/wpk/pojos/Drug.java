/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "drug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drug.findAll", query = "SELECT d FROM Drug d"),
    @NamedQuery(name = "Drug.findById", query = "SELECT d FROM Drug d WHERE d.id = :id"),
    @NamedQuery(name = "Drug.findByName", query = "SELECT d FROM Drug d WHERE d.name = :name"),
    @NamedQuery(name = "Drug.findByUnitPrice", query = "SELECT d FROM Drug d WHERE d.unitPrice = :unitPrice"),
    @NamedQuery(name = "Drug.findByQuantity", query = "SELECT d FROM Drug d WHERE d.quantity = :quantity"),
    @NamedQuery(name = "Drug.findByExpiry", query = "SELECT d FROM Drug d WHERE d.expiry = :expiry"),
    @NamedQuery(name = "Drug.findByManufacturer", query = "SELECT d FROM Drug d WHERE d.manufacturer = :manufacturer")})
public class Drug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private Integer quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiry")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiry;
    @Basic(optional = false)
    @NotNull
    @Column(name = "manufacturer")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufacturer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drug")
    private List<PrescriptionDrug> prescriptionDrugList;

   
    public Drug() {
    }

    public Drug(Integer id) {
        this.id = id;
    }

    public Drug(Integer id, String name, BigDecimal unitPrice, Integer quantity, Date expiry, Date manufacturer) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.expiry = expiry;
        this.manufacturer = manufacturer;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public Date getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Date manufacturer) {
        this.manufacturer = manufacturer;
    }

    @XmlTransient
    public List<PrescriptionDrug> getPrescriptionDrugList() {
        return prescriptionDrugList;
    }

    public void setPrescriptionDrugList(List<PrescriptionDrug> prescriptionDrugList) {
        this.prescriptionDrugList = prescriptionDrugList;
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
        if (!(object instanceof Drug)) {
            return false;
        }
        Drug other = (Drug) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

 
}
