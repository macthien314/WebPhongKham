/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Where;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
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
    @Column(name = "num")
    private Integer num;
    @Basic(optional = false)
    
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @Basic(optional = false)
    @Column(name = "fee")
    private BigDecimal fee;
    
    @Column(name = "sympton")
    @Size(min = 5, max = 100,message = "medcard.string.size")
    private String sympton;
    @Column(name = "receive", nullable = true)
    private boolean receive;
    
    @Column(name = "diagnosis")
    @Size(min = 5, max = 100,message = "medcard.string.size")
    private String diagnosis;
    
    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
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

    public MedicalExaminationCard(Integer id, Integer num, Date date, BigDecimal fee) {
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

  

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
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

    /**
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * @return the recive
     */
    public boolean isReceive() {
        return receive;
    }

    /**
     * @param recive the recive to set
     */
    public void setReceive(boolean receive) {
        this.receive = receive;
    }

}
