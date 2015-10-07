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
 * @author Vincent
 */
@Entity
public class Appareil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appareilId;
    
    @Column
    private String appareilLibelle;
    
    @Column
    private String appareilModalite;

    public Long getAppareilId() {
        return appareilId;
    }

    public void setAppareilId(Long appareilId) {
        this.appareilId = appareilId;
    }

    public String getAppareilLibelle() {
        return appareilLibelle;
    }

    public void setAppareilLibelle(String appareilLibelle) {
        this.appareilLibelle = appareilLibelle;
    }

    public String getAppareilModalite() {
        return appareilModalite;
    }

    public void setAppareilModalite(String appareilModalite) {
        this.appareilModalite = appareilModalite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appareilId != null ? appareilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appareil)) {
            return false;
        }
        Appareil other = (Appareil) object;
        if ((this.appareilId == null && other.appareilId != null) || (this.appareilId != null && !this.appareilId.equals(other.appareilId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bureau.Appareil[ id=" + appareilId + " ]";
    }
    
}
