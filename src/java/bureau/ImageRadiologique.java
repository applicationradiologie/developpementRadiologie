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
public class ImageRadiologique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imageRadiologiqueId;

    @Column
    private String imageRadiologiqueURL;

    public String getImageRadiologiqueURL() {
        return imageRadiologiqueURL;
    }

    public String getImageRadiologiqueFormat() {
        return imageRadiologiqueFormat;
    }

    public String getImageRadiologiquePoids() {
        return imageRadiologiquePoids;
    }

    public String getImageRadiologiqueLibelle() {
        return imageRadiologiqueLibelle;
    }
    private String imageRadiologiqueFormat;
    private String imageRadiologiquePoids;
    private String imageRadiologiqueLibelle;

    public long getId() {
        return imageRadiologiqueId;
    }

    public void setId(Long id) {
        this.imageRadiologiqueId = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageRadiologiqueId != null ? imageRadiologiqueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImageRadiologique)) {
            return false;
        }
        ImageRadiologique other = (ImageRadiologique) object;
        if ((this.imageRadiologiqueId == null && other.imageRadiologiqueId != null) || (this.imageRadiologiqueId != null && !this.imageRadiologiqueId.equals(other.imageRadiologiqueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bureau.ImageRadiologique[ id=" + imageRadiologiqueId + " ]";
    }

}
