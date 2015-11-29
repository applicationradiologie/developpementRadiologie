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
    private int appareilId;
    
    @Column
    private String appareilLibelle;
    
    @Column
    private String appareilModalite;

    public int getAppareilId() {
        return appareilId;
    }

    public void setAppareilId(int appareilId) {
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
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

  

   

    
}
