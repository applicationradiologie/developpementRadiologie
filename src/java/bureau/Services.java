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

    public Services(EntityManagerFactory fact) {
        this.fact = fact;
    }

    public Crayon newCrayon(String couleur) {
        Crayon p = new Crayon();
        p.setCouleur(couleur);
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        return p;
    }

    public Crayon getCrayonsById(int id) {
        EntityManager em = fact.createEntityManager();
        Crayon res = em.find(Crayon.class, id);
        em.close();
        return res;
    }

    public List<Crayon> getAllCrayons() {
        EntityManager em = fact.createEntityManager();
        TypedQuery<Crayon> query = em.createQuery("SELECT c FROM Crayon c", Crayon.class);
        List<Crayon> res = query.getResultList();
        em.close();
        return res;
    }

    public List<Boite> getAllBoites() {
        EntityManager em = fact.createEntityManager();
        TypedQuery<Boite> query = em.createQuery("SELECT b FROM Boite b", Boite.class);
        List<Boite> res = query.getResultList();
        em.close();
        return res;
    }

    public List<Crayon> getCrayonsByCouleurId(String couleur) {
        EntityManager em = fact.createEntityManager();
        TypedQuery<Crayon> query = em.createQuery("SELECT c FROM Crayon c WHERE c.couleur = :couleur", Crayon.class)
                .setParameter("couleur", couleur);
        List<Crayon> res = query.getResultList();
        em.close();
        return res;
    }

    public Boite newBoite(List<Crayon> crayons) {
        EntityManager em = fact.createEntityManager();
        Boite b = new Boite();
        em.getTransaction().begin();
        b.setCrayons(crayons);
        em.persist(b);
        em.getTransaction().commit();
        em.close();
        return b;
    }

    public Boite getBoiteById(int id) {
        EntityManager em = fact.createEntityManager();
        Boite res = em.find(Boite.class, id);
        em.close();
        return res;
    }

    public List<Boite> getBoitesByCouleurDeCrayon(String couleur) {
        EntityManager em = fact.createEntityManager();
        TypedQuery<Boite> query = em.createQuery("SELECT b FROM Boite b JOIN b.crayons c WHERE c.couleur = :couleur", Boite.class)
                .setParameter("couleur", couleur);
        List<Boite> res = query.getResultList();
        em.close();
        return res;
    }

    public void deleteAllBoites() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Boite").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAllCrayons() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Crayon").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    //Acte Radiologique
    public ActeRadiologique newActeRadiologique(Date dateActe, Admission ad, List<ImageRadiologique> images, Appareil appareil, NomemclatureCCAM nomemclatureCCAM) {
        ActeRadiologique a = new ActeRadiologique();
        a.setActeRadiologiqueDate(new java.util.Date());
        a.setAdmission(ad);
        a.setImages(images);
        a.setAppareil(appareil);
        a.setNomenclatureCCAM(nomemclatureCCAM);
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        return a;
    }

    public ActeRadiologique getActeRadiologique(Long id) {
        EntityManager em = fact.createEntityManager();
        ActeRadiologique res = em.find(ActeRadiologique.class, id);
        em.close();
        return res;
    }

    public List<ActeRadiologique> getAllActeRadiologique() {
        EntityManager em = fact.createEntityManager();
        TypedQuery<ActeRadiologique> query = em.createQuery("SELECT a FROM ActeRadiologique a", ActeRadiologique.class);
        List<ActeRadiologique> res = query.getResultList();
        return res;
    }

    public void deleteAllActeRadiologique() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM ActeRadiologique").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public List<ActeRadiologique> getActeRadiologiqueByAdmission(String iep) {
        EntityManager em = fact.createEntityManager();
        TypedQuery<ActeRadiologique> query = em.createQuery("SELECT a FROM ActeRadiologique a JOIN a.admission adm WHERE adm.iep= :iep", ActeRadiologique.class).setParameter("iep", iep);
        List<ActeRadiologique> res = query.getResultList();
        em.close();
        return res;

    }

    //Admission
    public Admission newAdmission(String IPP) {
        Admission a = new Admission();
        a.setAdmissionIPP(IPP);
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        return a;
    }

    public Admission getAdmission(Long iep) {
        EntityManager em = fact.createEntityManager();
        Admission adm = em.find(Admission.class, iep);
        em.close();
        return adm;
    }

    public List<Admission> getAllAdmission() {
        EntityManager em = fact.createEntityManager();
        TypedQuery<Admission> query = em.createQuery("SELECT a FROM Admission a", Admission.class);
        List<Admission> res = query.getResultList();
        return res;
    }

    public void deleteAllAdmission() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Admission").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    //Appareil
    public Appareil newAppareil(String AppareilLibelle, String AppareilModalite) {
        Appareil a = new Appareil();
        a.setAppareilLibelle(AppareilLibelle);
        a.setAppareilModalite(AppareilModalite);
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        return a;
    }

    public Appareil getAppareil(Long id) {
        EntityManager em = fact.createEntityManager();
        Appareil ap = em.find(Appareil.class, id);
        em.close();
        return ap;
    }

    public List<Appareil> getAllAppareil() {
        EntityManager em = fact.createEntityManager();
        TypedQuery<Appareil> query = em.createQuery("SELECT a FROM Appareil a", Appareil.class);
        List<Appareil> res = query.getResultList();
        return res;
    }

    public void deleteAllAppareil() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Appareil").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    //Image Radiologique
    public ImageRadiologique newImageRadiologique(String imageRadiologiqueURL, String imageRadiologiqueFormat, String imageRadiolgoquePoids, String imageRadiologiqueLibelle) {
        ImageRadiologique a = new ImageRadiologique();
        a.setImageRadiologiqueURL(imageRadiologiqueURL);
        a.setImageRadiologiqueFormat(imageRadiologiqueFormat);
        a.setImageRadiologiquePoids(imageRadiolgoquePoids);
        a.setImageRadiologiqueLibelle(imageRadiologiqueLibelle);
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        return a;
    }

    public ImageRadiologique getImageRadiologique(Long id) {
        EntityManager em = fact.createEntityManager();
        ImageRadiologique i = em.find(ImageRadiologique.class, id);
        em.close();
        return i;
    }

    public List<ImageRadiologique> getAllImageRadiologique() {
        EntityManager em = fact.createEntityManager();
        TypedQuery<ImageRadiologique> query = em.createQuery("SELECT a FROM ImageRadiologique a", ImageRadiologique.class);
        List<ImageRadiologique> res = query.getResultList();
        return res;
    }

    public void deleteAllImageRadiologique() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM ImageRadiologique").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    //NomemclatureCCAM
    public NomemclatureCCAM newNomemclatureCCAM(String NomemclatureCCAMLibelle, String nomenclatureCCAMCode) {
        NomemclatureCCAM a = new NomemclatureCCAM();
        a.setNomenclatureCCAMLibelle(NomemclatureCCAMLibelle);
        a.setNomemclatureCCAMCode(nomenclatureCCAMCode);
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        return a;
    }

    public NomemclatureCCAM getNomemclatureCCAM(Long id) {
        EntityManager em = fact.createEntityManager();
        NomemclatureCCAM nc = em.find(NomemclatureCCAM.class, id);
        em.close();
        return nc;
    }

    public List<NomemclatureCCAM> getAllNomemclatureCCAM() {
        EntityManager em = fact.createEntityManager();
        TypedQuery<NomemclatureCCAM> query = em.createQuery("SELECT a FROM NomemclatureCCAM a", NomemclatureCCAM.class);
        List<NomemclatureCCAM> res = query.getResultList();
        return res;
    }

    public void deleteAllNomemclatureCCAM() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM NomemclatureCCAM").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
