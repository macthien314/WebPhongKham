/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "nurse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nurse.findAll", query = "SELECT n FROM Nurse n"),
    @NamedQuery(name = "Nurse.findById", query = "SELECT n FROM Nurse n WHERE n.id = :id"),
    @NamedQuery(name = "Nurse.findByFirstName", query = "SELECT n FROM Nurse n WHERE n.firstName = :firstName"),
    @NamedQuery(name = "Nurse.findByLastName", query = "SELECT n FROM Nurse n WHERE n.lastName = :lastName"),
    @NamedQuery(name = "Nurse.findByBirthDate", query = "SELECT n FROM Nurse n WHERE n.birthDate = :birthDate"),
    @NamedQuery(name = "Nurse.findByGender", query = "SELECT n FROM Nurse n WHERE n.gender = :gender"),
    @NamedQuery(name = "Nurse.findByPhone", query = "SELECT n FROM Nurse n WHERE n.phone = :phone"),
    @NamedQuery(name = "Nurse.findByEmail", query = "SELECT n FROM Nurse n WHERE n.email = :email"),
    @NamedQuery(name = "Nurse.findByImage", query = "SELECT n FROM Nurse n WHERE n.image = :image")})
public class Nurse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @Size(max = 45)
    @Column(name = "gender")
    private String gender;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    
    @Size(min = 1, max = 100)
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "nurse",cascade=CascadeType.ALL)
    private List<MedicalExaminationCard> medicalExaminationCardList;
    @OneToMany(mappedBy = "nurse",cascade=CascadeType.ALL)
    private List<ServiceInvoice> serviceInvoiceList;
    @OneToMany(mappedBy="nurse")
    private List<Invoice> invoices;

    @ManyToOne
    @JoinColumn(name = "medical_id")
    private Medical medical;
    
    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;
    
    @Transient
    private MultipartFile file;
    public Nurse() {
    }

    public Nurse(Integer id) {
        this.id = id;
    }

    public Nurse(Integer id, String firstName, String lastName, Date birthDate, String phone, String email, String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public List<MedicalExaminationCard> getMedicalExaminationCardList() {
        return medicalExaminationCardList;
    }

    public void setMedicalExaminationCardList(List<MedicalExaminationCard> medicalExaminationCardList) {
        this.medicalExaminationCardList = medicalExaminationCardList;
    }

    @XmlTransient
    public List<ServiceInvoice> getServiceInvoiceList() {
        return serviceInvoiceList;
    }

    public void setServiceInvoiceList(List<ServiceInvoice> serviceInvoiceList) {
        this.serviceInvoiceList = serviceInvoiceList;
    }

    public Medical getMedicalId() {
        return getMedical();
    }

    public void setMedicalId(Medical medicalId) {
        this.setMedical(medicalId);
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
        if (!(object instanceof Nurse)) {
            return false;
        }
        Nurse other = (Nurse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wpk.pojos.Nurse[ id=" + id + " ]";
    }

    /**
     * @return the medical
     */
    public Medical getMedical() {
        return medical;
    }

    /**
     * @param medical the medical to set
     */
    public void setMedical(Medical medical) {
        this.medical = medical;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
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
     * @return the invoices
     */
    public List<Invoice> getInvoices() {
        return invoices;
    }

    /**
     * @param invoices the invoices to set
     */
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
    
}
