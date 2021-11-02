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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "medical_examination_card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicalExaminationCard.findAll", query = "SELECT m FROM MedicalExaminationCard m"),
    @NamedQuery(name = "MedicalExaminationCard.findById", query = "SELECT m FROM MedicalExaminationCard m WHERE m.id = :id"),
    @NamedQuery(name = "MedicalExaminationCard.findByNum", query = "SELECT m FROM MedicalExaminationCard m WHERE m.num = :num"),
    @NamedQuery(name = "MedicalExaminationCard.findByDate", query = "SELECT m FROM MedicalExaminationCard m WHERE m.date = :date"),
    @NamedQuery(name = "MedicalExaminationCard.findByFee", query = "SELECT m FROM MedicalExaminationCard m WHERE m.fee = :fee"),
    @NamedQuery(name = "MedicalExaminationCard.findBySympton", query = "SELECT m FROM MedicalExaminationCard m WHERE m.sympton = :sympton"),
    @NamedQuery(name = "MedicalExaminationCard.findByDiagnosis", query = "SELECT m FROM MedicalExaminationCard m WHERE m.diagnosis = :diagnosis")})
public class MedicalExaminationCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "num")
    private String num;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fee")
    private long fee;
    @Size(max = 100)
    @Column(name = "sympton")
    private String sympton;
    @Size(max = 100)
    @Column(name = "diagnosis")
    private String diagnosis;
    
    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;
    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
     @Transient
   
    private MultipartFile file;

    public MedicalExaminationCard() {
       
    }

    public MedicalExaminationCard(Integer id) {
        this.id = id;
    }

    public MedicalExaminationCard(Integer id, String num, Date date, long fee) {
        this.id = id;
        this.num = num;
        this.date = date;
        this.fee = fee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

  

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public String getSympton() {
        return sympton;
    }

    public void setSympton(String sympton) {
        this.sympton = sympton;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalExaminationCard)) {
            return false;
        }
        MedicalExaminationCard other = (MedicalExaminationCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wpk.pojos.MedicalExaminationCard[ id=" + id + " ]";
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
