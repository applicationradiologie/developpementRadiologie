/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import java.util.Date;
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
public class ActeRadiologique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String acteRadiologiquePACS;
    
    @Column
    private Date acteRadiologiqueDate;

    public String getId() {
        return acteRadiologiquePACS;
    }

    public void setId(String id) {
        this.acteRadiologiquePACS = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acteRadiologiquePACS != null ? acteRadiologiquePACS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActeRadiologique)) {
            return false;
        }
        ActeRadiologique other = (ActeRadiologique) object;
        if ((this.acteRadiologiquePACS == null && other.acteRadiologiquePACS != null) || (this.acteRadiologiquePACS != null && !this.acteRadiologiquePACS.equals(other.acteRadiologiquePACS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bureau.ActeRadiologique[ id=" + acteRadiologiquePACS + " ]";
    }
    
}
