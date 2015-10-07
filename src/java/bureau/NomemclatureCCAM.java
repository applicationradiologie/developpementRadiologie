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
public class NomemclatureCCAM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nomenclatureCCAMCode;
    
    @Column
    private String nomenclatureCCAMLibelle; 

    public Long getNomenclatureCCAMCode() {
        return nomenclatureCCAMCode;
    }

    public void setNomenclatureCCAMCode(Long nomenclatureCCAMCode) {
        this.nomenclatureCCAMCode = nomenclatureCCAMCode;
    }

    public String getNomenclatureCCAMLibelle() {
        return nomenclatureCCAMLibelle;
    }

    public void setNomenclatureCCAMLibelle(String nomenclatureCCAMLibelle) {
        this.nomenclatureCCAMLibelle = nomenclatureCCAMLibelle;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomenclatureCCAMCode != null ? nomenclatureCCAMCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NomemclatureCCAM)) {
            return false;
        }
        NomemclatureCCAM other = (NomemclatureCCAM) object;
        if ((this.nomenclatureCCAMCode == null && other.nomenclatureCCAMCode != null) || (this.nomenclatureCCAMCode != null && !this.nomenclatureCCAMCode.equals(other.nomenclatureCCAMCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bureau.NomemclatureCCAM[ id=" + nomenclatureCCAMCode + " ]";
    }
    
}
