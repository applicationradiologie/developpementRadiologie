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
public class CCAM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CCAMid;
    
    @Column
    private String CCAMLibelle;
    
    @Column
    private String CCAMCode;

    public String getCCAMLibelle() {
        return CCAMLibelle;
    }

    public void setCCAMLibelle(String CCAMLibelle) {
        this.CCAMLibelle = CCAMLibelle;
    }

    public String getCCAMCode() {
        return CCAMCode;
    }

    public void setCCAMCode(String CCAMCode) {
        this.CCAMCode = CCAMCode;
    }

    public Long getIdCCAM() {
        return CCAMid;
    }

    public void setIdCCAM(Long idCCAM) {
        this.CCAMid = idCCAM;
    }

    @Override
    public String toString() {
        return "bureau.CCAM[ id=" + CCAMid + " ]"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appareil)) {
            return false;
        }
        CCAM other = (CCAM) object;
        if ((this.CCAMid == null && other.CCAMid != null) || (this.CCAMid != null && !this.CCAMid.equals(other.CCAMid))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
