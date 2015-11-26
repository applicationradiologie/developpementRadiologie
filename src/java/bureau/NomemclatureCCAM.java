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
    private Integer nomenclatureCCAMId;

    @Column
    private String nomenclatureCCAMLibelle;
    
    @Column
    private String nomemclatureCCAMCode;
    
    public Integer getNomemclatureCCAMId() {
        return nomenclatureCCAMId;
    }

    public void setNomenclatureCCAMId(Integer nomenclatureCCAMId) {
        this.nomenclatureCCAMId = nomenclatureCCAMId;
    }

    public String getNomemclatureCCAMCode() {
        return nomemclatureCCAMCode;
    }

    public void setNomemclatureCCAMCode(String nomemclatureCCAMCode) {
        this.nomemclatureCCAMCode = nomemclatureCCAMCode;
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
        hash += (nomenclatureCCAMId != null ? nomenclatureCCAMId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NomemclatureCCAM)) {
            return false;
        }
        NomemclatureCCAM other = (NomemclatureCCAM) object;
        if ((this.nomenclatureCCAMId == null && other.nomenclatureCCAMId != null) || (this.nomenclatureCCAMId != null && !this.nomenclatureCCAMId.equals(other.nomenclatureCCAMId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "bureau.NomemclatureCCAM[ id=" + nomenclatureCCAMId + " ]";
//    }

}
