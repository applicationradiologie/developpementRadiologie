/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Thomas
 */
@Entity
public class ActeRadiologique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long acteRadiologiquePACS;

    @ManyToOne
    private Appareil appareil;

    @ManyToOne
    private CCAM CCAM;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Admission admission;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<ImageRadiologique> images;

    private Date acteRadiologiqueDate;

    public List<ImageRadiologique> getImages() {
        return images;
    }

    public void setImages(List<ImageRadiologique> images) {
        this.images = images;
    }

    public Date getActeRadiologiqueDate() {
        return acteRadiologiqueDate;
    }

    public void setActeRadiologiqueDate(Date acteRadiologiqueDate) {
        this.acteRadiologiqueDate = acteRadiologiqueDate;
    }

    public Appareil getAppareil() {
        return appareil;
    }

    public void setAppareil(Appareil appareil) {
        this.appareil = appareil;
    }

    public CCAM getCCAM() {
        return CCAM;
    }

    public void setNomenclatureCCAM(CCAM CCAM) {
        this.CCAM = CCAM;
    }

    public Long getId() {
        return acteRadiologiquePACS;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    public void setId(Long id) {
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
