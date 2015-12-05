/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author Kurasawa
 */
public class Services {

    EntityManagerFactory fact;
    EntityManager em;

    public Services(EntityManagerFactory fact) {
        this.fact = fact;
        this.em = fact.createEntityManager();
    }

    public void newCrayon(Crayon cr) {
        em.getTransaction().begin();
        em.persist(cr);
        em.getTransaction().commit();
    }

    public Crayon newCrayon(String couleur) {
        Crayon p = new Crayon();
        p.setCouleur(couleur);

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    public void editCrayon(Crayon cr) {

        em.getTransaction().begin();
        em.merge(cr);
        em.getTransaction().commit();

    }

    public void removeCrayon(int id) {

        Crayon cr = em.find(Crayon.class, id);
        em.getTransaction().begin();
        em.remove(cr);
        em.getTransaction().commit();

    }

    public Crayon getCrayonsById(int id) {

        Crayon res = em.find(Crayon.class, id);
        return res;
    }

    public List<Crayon> getAllCrayons() {

        TypedQuery<Crayon> query = em.createQuery("SELECT c FROM Crayon c", Crayon.class);
        List<Crayon> res = query.getResultList();
        return res;
    }

    public List<Boite> getAllBoites() {

        TypedQuery<Boite> query = em.createQuery("SELECT b FROM Boite b", Boite.class);
        List<Boite> res = query.getResultList();
        return res;
    }

    public List<Crayon> getCrayonsByCouleurId(String couleur) {
        TypedQuery<Crayon> query = em.createQuery("SELECT c FROM Crayon c WHERE c.couleur = :couleur", Crayon.class)
                .setParameter("couleur", couleur);
        List<Crayon> res = query.getResultList();
        return res;
    }

    public Boite newBoite(List<Crayon> crayons) {
        Boite b = new Boite();
        em.getTransaction().begin();
        b.setCrayons(crayons);
        em.persist(b);
        em.getTransaction().commit();
        return b;
    }

    public Boite getBoiteById(int id) {
        Boite res = em.find(Boite.class, id);
        return res;
    }

    public List<Boite> getBoitesByCouleurDeCrayon(String couleur) {
        TypedQuery<Boite> query = em.createQuery("SELECT b FROM Boite b JOIN b.crayons c WHERE c.couleur = :couleur", Boite.class)
                .setParameter("couleur", couleur);
        List<Boite> res = query.getResultList();
        return res;
    }

    public void deleteAllBoites() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Boite").executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteAllCrayons() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Crayon").executeUpdate();
        em.getTransaction().commit();
    }

    //Acte Radiologique : service non utilisé
    public ActeRadiologique newActeRadiologique(Date dateActe, Admission ad, List<ImageRadiologique> images, Appareil appareil, CCAM CCAM) {
        ActeRadiologique a = new ActeRadiologique();
        a.setActeRadiologiqueDate(new java.util.Date());
        a.setAdmission(ad);
        a.setImages(images);
        a.setAppareil(appareil);
        a.setCCAM(CCAM);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return a;
    }

//    Acte Radiologique
    public ActeRadiologique newActeRadiologique2(ActeRadiologique a) {
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        return a;
    }

    public ActeRadiologique getActeRadiologique(Long id) {
        ActeRadiologique res = em.find(ActeRadiologique.class, id);
        return res;
    }

    public List<ActeRadiologique> getAllActeRadiologique() {
        TypedQuery<ActeRadiologique> query = em.createQuery("SELECT a FROM ActeRadiologique a", ActeRadiologique.class);
        List<ActeRadiologique> res = query.getResultList();
        return res;
    }

    public void deleteAllActeRadiologique() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM ActeRadiologique").executeUpdate();
        em.getTransaction().commit();
    }

    public List<ActeRadiologique> getActeRadiologiqueByAdmission(String ipp) {
        TypedQuery<ActeRadiologique> query = em.createQuery("SELECT a FROM ActeRadiologique a JOIN a.admission adm WHERE adm.admissionIPP= :ipp", ActeRadiologique.class).setParameter("ipp", ipp);
        List<ActeRadiologique> res = query.getResultList();
        return res;

    }

    public void updateActeRadiologiqueImage(ActeRadiologique act, ImageRadiologique img) {
        act.images.add(img);
        em.getTransaction().begin();
        em.persist(act);
        em.getTransaction().commit();
    }

    //Admission
    public Admission newAdmission(String IPP) {
        Admission a = new Admission();
        a.setAdmissionIPP(IPP);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return a;
    }
    
    public Admission newAdmission2(Admission ad) {
        em.getTransaction().begin();
        em.merge(ad);
        em.getTransaction().commit();
        return ad;
    }

    public Admission getAdmissionById(Long iep) {
        Admission adm = em.find(Admission.class, iep);
        return adm;
    }

    public List<Admission> getAllAdmission() {
        TypedQuery<Admission> query = em.createQuery("SELECT a FROM Admission a", Admission.class);
        List<Admission> res = query.getResultList();
        return res;
    }
    
    public void editAdmission(Admission adm) {

        em.getTransaction().begin();
        em.merge(adm);
        em.getTransaction().commit();

    }
    
      public void removeAdmission(Long admissionIEP) {

        Admission adm = em.find(Admission.class, admissionIEP);
        em.getTransaction().begin();
        em.remove(adm);
        em.getTransaction().commit();

    }

    public void deleteAllAdmission() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Admission").executeUpdate();
        em.getTransaction().commit();
    }

    public List<ImageRadiologique> getImagesByAdmission(String ipp) {
        TypedQuery<ActeRadiologique> query = em.createQuery("SELECT a FROM ActeRadiologique a JOIN a.admission adm WHERE adm.admissionIPP= :ipp", ActeRadiologique.class).setParameter("ipp", ipp);
        List<ActeRadiologique> res = query.getResultList();
        List<ImageRadiologique> img = new ArrayList<>();
        for (ActeRadiologique act : res) {
            for (ImageRadiologique im : act.getImages()) {
                img.add(im);
            }
        }
        return img;
    }

    //Appareil
    public Appareil newAppareil(String AppareilLibelle, String AppareilModalite) {
        Appareil a = new Appareil();
        a.setAppareilLibelle(AppareilLibelle);
        a.setAppareilModalite(AppareilModalite);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return a;
    }
    public Appareil newAppareil2(Appareil a) {
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        return a;
    }

    public Appareil getAppareilByID(int appareilId) {
        Appareil ap = em.find(Appareil.class, appareilId);
        return ap;
    }
    
    public void editAppareil(Appareil appa) {

        em.getTransaction().begin();
        em.merge(appa);
        em.getTransaction().commit();

    }

    public List<Appareil> getAllAppareil() {
        TypedQuery<Appareil> query = em.createQuery("SELECT a FROM Appareil a", Appareil.class);
        List<Appareil> res = query.getResultList();
        return res;
    }

    public void removeAppareil(Appareil ap) {

        Appareil appa = em.find(Appareil.class, ap.getAppareilId());
        em.getTransaction().begin();
        em.remove(appa);
        em.getTransaction().commit();

    }

    public void deleteAllAppareil() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Appareil").executeUpdate();
        em.getTransaction().commit();
    }
    
    
    //CCAM (le bon)
    
     public CCAM newCCAM(String CCAMLibelle, String CCAMCode) {
        CCAM a = new CCAM();
        a.setCCAMLibelle(CCAMLibelle);
        a.setCCAMCode(CCAMCode);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return a;
    }
     
    public CCAM newCCAM2(CCAM ca) {
        em.getTransaction().begin();
        em.merge(ca);
        em.getTransaction().commit();
        return ca;
    }

    public CCAM getCCAMById(Long CCAMid) {
        CCAM ap = em.find(CCAM.class, CCAMid);
        return ap;
    }

    public List<CCAM> getAllCCAM() {
        TypedQuery<CCAM> query = em.createQuery("SELECT a FROM CCAM a", CCAM.class);
        List<CCAM> res = query.getResultList();
        return res;
    }
    
    public void editCCAM(CCAM ccam) {

        em.getTransaction().begin();
        em.merge(ccam);
        em.getTransaction().commit();

    }

    public void removeCCAM(Long CCAMid) {

        Appareil ap = em.find(Appareil.class, CCAMid);
        em.getTransaction().begin();
        em.remove(ap);
        em.getTransaction().commit();

    }

    public void deleteAllCCAM() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM CCAM").executeUpdate();
        em.getTransaction().commit();
    }

    //Image Radiologique
    public ImageRadiologique newImageRadiologique(String imageRadiologiqueFormat, String imageRadiologiqueLibelle, String imageRadiolgoquePoids, String imageRadiologiqueURL) {
        ImageRadiologique a = new ImageRadiologique();
        a.setImageRadiologiqueURL(imageRadiologiqueURL);
        a.setImageRadiologiqueFormat(imageRadiologiqueFormat);
        a.setImageRadiologiquePoids(imageRadiolgoquePoids);
        a.setImageRadiologiqueLibelle(imageRadiologiqueLibelle);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return a;
    }
    
    public ImageRadiologique newImageRadiologique2(ImageRadiologique im) {
        em.getTransaction().begin();
        em.merge(im);
        em.getTransaction().commit();
        return im;
    }

    public ImageRadiologique getImageRadiologiqueById(Long imageRadiologiqueId) {
        ImageRadiologique i = em.find(ImageRadiologique.class, imageRadiologiqueId);
        return i;
    }

    public List<ImageRadiologique> getAllImageRadiologique() {
        TypedQuery<ImageRadiologique> query = em.createQuery("SELECT a FROM ImageRadiologique a", ImageRadiologique.class);
        List<ImageRadiologique> res = query.getResultList();
        return res;
    }
    
    public void editImage(ImageRadiologique img) {

        em.getTransaction().begin();
        em.merge(img);
        em.getTransaction().commit();

    }

    public void deleteAllImageRadiologique() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM ImageRadiologique").executeUpdate();
        em.getTransaction().commit();
    }

    public void removeImageRadiologique(Long imageRadiologiqueId) {

        ImageRadiologique ap = em.find(ImageRadiologique.class, imageRadiologiqueId);
        em.getTransaction().begin();
        em.remove(ap);
        em.getTransaction().commit();

    }

    //NomemclatureCCAM
    //NE PLUS UTILISER
    public NomemclatureCCAM newNomemclatureCCAM(String NomemclatureCCAMLibelle, String nomenclatureCCAMCode) {
        NomemclatureCCAM a = new NomemclatureCCAM();
        a.setNomenclatureCCAMLibelle(NomemclatureCCAMLibelle);
        a.setNomemclatureCCAMCode(nomenclatureCCAMCode);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return a;
    }
    //NE PLUS UTILISER
    public NomemclatureCCAM getNomemclatureCCAM(Long id) {
        NomemclatureCCAM nc = em.find(NomemclatureCCAM.class, id);
        return nc;
    }
    //NE PLUS UTILISER
     public List<NomemclatureCCAM> getAllNomemclatureCCAM() {
        TypedQuery<NomemclatureCCAM> query = em.createQuery("SELECT n FROM NomemclatureCCAM n", NomemclatureCCAM.class);
        List<NomemclatureCCAM> res = query.getResultList();
        return res;
    }
    //NE PLUS UTILISER
    public void deleteAllNomemclatureCCAM() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM NomemclatureCCAM").executeUpdate();
        em.getTransaction().commit();
    }
}
