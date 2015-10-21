/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Thomas
 */
@Entity
public class Admission implements Serializable {

 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long admissionIEP;
    @Column

    private String admissionIPP;

    public String getAdmissionIPP() {
        return admissionIPP;
    }

    public Long getAdmissionIEP() {
        return admissionIEP;
    }

    public void setAdmissionIEP(Long admissionIEP) {
        this.admissionIEP = admissionIEP;
    }

    public void setAdmissionIPP(String admissionIPP) {
        this.admissionIPP = admissionIPP;
    }

    public Long getId() {
        return admissionIEP;
    }

    public void setId(Long id) {
        this.admissionIEP = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admissionIEP != null ? admissionIEP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admission)) {
            return false;
        }
        Admission other = (Admission) object;
        if ((this.admissionIEP == null && other.admissionIEP != null) || (this.admissionIEP != null && !this.admissionIEP.equals(other.admissionIEP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bureau.Admission[ id=" + admissionIEP + " ]";
    }

}
