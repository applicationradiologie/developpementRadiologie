/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

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

    public Crayon newCrayon(String couleur) {
        Crayon p = new Crayon();
        p.setCouleur(couleur);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
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

    //Acte Radiologique
    public ActeRadiologique newActeRadiologique(Date dateActe, Admission ad, List<ImageRadiologique> images, Appareil appareil, NomemclatureCCAM nomemclatureCCAM) {
        ActeRadiologique a = new ActeRadiologique();
        a.setActeRadiologiqueDate(new java.util.Date());
        a.setAdmission(ad);
        a.setImages(images);
        a.setAppareil(appareil);
        a.setNomenclatureCCAM(nomemclatureCCAM);
        em.getTransaction().begin();
        em.persist(a);
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

    //Admission
    public Admission newAdmission(String IPP) {
        Admission a = new Admission();
        a.setAdmissionIPP(IPP);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return a;
    }

    public Admission getAdmission(Long iep) {
        Admission adm = em.find(Admission.class, iep);
        return adm;
    }

    public List<Admission> getAllAdmission() {
        TypedQuery<Admission> query = em.createQuery("SELECT a FROM Admission a", Admission.class);
        List<Admission> res = query.getResultList();
        return res;
    }

    public void deleteAllAdmission() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Admission").executeUpdate();
        em.getTransaction().commit();
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

    public Appareil getAppareil(Long id) {
        Appareil ap = em.find(Appareil.class, id);
        return ap;
    }

    public List<Appareil> getAllAppareil() {
        TypedQuery<Appareil> query = em.createQuery("SELECT a FROM Appareil a", Appareil.class);
        List<Appareil> res = query.getResultList();
        return res;
    }

    public void deleteAllAppareil() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Appareil").executeUpdate();
        em.getTransaction().commit();
    }

    //Image Radiologique
    public ImageRadiologique newImageRadiologique(String imageRadiologiqueURL, String imageRadiologiqueFormat, String imageRadiolgoquePoids, String imageRadiologiqueLibelle) {
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

    public ImageRadiologique getImageRadiologique(Long id) {
        ImageRadiologique i = em.find(ImageRadiologique.class, id);
        return i;
    }

    public List<ImageRadiologique> getAllImageRadiologique() {
        TypedQuery<ImageRadiologique> query = em.createQuery("SELECT a FROM ImageRadiologique a", ImageRadiologique.class);
        List<ImageRadiologique> res = query.getResultList();
        return res;
    }

    public void deleteAllImageRadiologique() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM ImageRadiologique").executeUpdate();
        em.getTransaction().commit();
    }

    //NomemclatureCCAM
    public NomemclatureCCAM newNomemclatureCCAM(String NomemclatureCCAMLibelle, String nomenclatureCCAMCode) {
        NomemclatureCCAM a = new NomemclatureCCAM();
        a.setNomenclatureCCAMLibelle(NomemclatureCCAMLibelle);
        a.setNomemclatureCCAMCode(nomenclatureCCAMCode);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return a;
    }

    public NomemclatureCCAM getNomemclatureCCAM(Long id) {
        NomemclatureCCAM nc = em.find(NomemclatureCCAM.class, id);
        return nc;
    }

    public List<NomemclatureCCAM> getAllNomemclatureCCAM() {
        TypedQuery<NomemclatureCCAM> query = em.createQuery("SELECT a FROM NomemclatureCCAM a", NomemclatureCCAM.class);
        List<NomemclatureCCAM> res = query.getResultList();
        return res;
    }

    public void deleteAllNomemclatureCCAM() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM NomemclatureCCAM").executeUpdate();
        em.getTransaction().commit();
    }
}
