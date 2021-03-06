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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Kurasawa
 */
@Path("generic")
public class RestServices {

    @Context
    private UriInfo context;
    Services serv;

    /**
     * Creates a new instance of GenericResource
     */
    public RestServices() {
        serv = new Services(DatabaseUtils.fact());
    }

    /**
     * Retrieves representation of an instance of bureau.RestServices
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("crayons/{id}")
    @Produces("application/json")
    public Crayon getCrayons(@PathParam("id") int id) {
        //TODO return proper representation object
        return serv.getCrayonsById(id);
    }

    @GET
    @Path("crayons")
    @Produces("application/json")
    public List<Crayon> getAllCrayons() {
        //TODO return proper representation object
        return serv.getAllCrayons();
    }

    @GET
    @Path("boites")
    @Produces("application/json")
    public List<Boite> getBoites() {
        //TODO return proper representation object
        return serv.getAllBoites();
    }

    @POST
    @Path("crayons")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Crayon newCrayon(Crayon cr) {
        serv.newCrayon(cr);
        System.out.println("id:" + cr.getId());
        return cr;
    }

    @POST
    @Path("crayons/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editCrayon(Crayon cr) {
        serv.editCrayon(cr);
        return Response.status(200).entity(cr).build();
    }

    @DELETE
    @Path("crayons/{id}")
    public Response removeCrayon(@PathParam("id") int id) {
        serv.removeCrayon(id);
        return Response.status(200).build();
    }
    /*
     //-----------------------RADIOLOGIE-----------------------
     */

    //Afficher les actes radiologiques par admission OK

    @GET
    @Path("actes/{ipp}")
    @Produces("application/json")
    public List<ActeRadiologique> getActeRadiologiquesByAdmission(@PathParam("ipp") Long iep) {
        //TODO return proper representation object
        return serv.getActeRadiologiqueByAdmission(iep);
    }

    //Afficher tous les actes OK
    @GET
    @Path("acteradiologique")
    @Produces("application/json")
    public List<ActeRadiologique> getAllActeRadiologiques(@DefaultValue("") @QueryParam("ad") Long ad) {
        //TODO return proper representation object
        System.out.println("Valeur du query params : " + ad);
        if (ad != null) {
            return serv.getActeRadiologiqueByAdmission(ad);
        } else {
            return serv.getAllActeRadiologique();
        }
    }

    //Obtenir un acte
    @GET
    @Path("acteradiologique/{act}")
    @Produces("application/json")
    public ActeRadiologique getActeById(@PathParam("act") Long act) {
        //TODO return proper representation object
        return serv.getActeRadiologique(act);
    }

    //Obtenir une admission OK
    @GET
    @Path("admission/{iep}")
    @Produces("application/json")
    public Admission getAdmissionById(@PathParam("iep") Long iep) {
        //TODO return proper representation object
        return serv.getAdmissionById(iep);
    }

    //Obtenir toutes les admissions
    @GET
    @Path("admission")
    @Produces("application/json")
    public List<Admission> getAllAdmissions() {
        //TODO return proper representation object
        return serv.getAllAdmission();
    }

    //Consulter les images d'un patient OK
    @GET
    @Path("acteradiologiqueimages/{ipp}")
    @Produces("application/json")
    public List<ImageRadiologique> getImagesByAdmission(@PathParam("ipp") String ipp) {
        return serv.getImagesByAdmission(ipp);
    }

    //Consulter les images d'un patient OK
    @GET
    @Path("appareil/{appa}")
    @Produces("application/json")
    public Appareil getAppareil(@PathParam("appa") int appareilId) {
        System.out.println("passage1");
        return serv.getAppareilByID(appareilId);
    }

    //Obtenir tous les appareils
    @GET
    @Path("appareil")
    @Produces("application/json")
    public List<Appareil> getAppareils() {
        //TODO return proper representation object
        System.out.println("passage2");
        System.out.println(serv.getAppareilByID(3).getAppareilLibelle().toString());
        return serv.getAllAppareil();
    }

    //Editer un appareil
    @POST
    @Path("appareil/{appa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editAppareil(Appareil appa) {
        System.out.println("mise à jour de l'appareil");
        serv.editAppareil(appa);
        return Response.status(200).entity(appa).build();
    }

    //Editer un CCAM
    @POST
    @Path("CCAM/{no}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editCCAM(CCAM no) {
        serv.editCCAM(no);
        return Response.status(200).entity(no).build();
    }

    //Editer une admission
    @POST
    @Path("admission/{ad}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editadmission(Admission ad) {
        serv.editAdmission(ad);
        return Response.status(200).entity(ad).build();
    }

    //Obtenir un CCAM
    @GET
    @Path("CCAM/{no}")
    @Produces("application/json")
    public CCAM getCCAMById(@PathParam("no") Long idCCAM) {
        //TODO return proper representation object
        return serv.getCCAMById(idCCAM);
    }

    //Obtenir tous les CCAM (le bon)
    @GET
    @Path("CCAM")
    @Produces("application/json")
    public List<CCAM> getAllCCAM() {
        //TODO return proper representation object
        System.out.println("passage2");
        System.out.println(serv.getAppareilByID(3).getAppareilModalite().toString());
        return serv.getAllCCAM();
    }

    //Obtenir toutes les nomenclature
    //NE PLUS UTILISER
    @GET
    @Path("nomemclatureCCAM")
    @Produces("application/json")
    public List<NomemclatureCCAM> getNomemclatureCCAM() {
        //TODO return proper representation object
        return serv.getAllNomemclatureCCAM();
    }

    //Obtenir toutes les images
    @GET
    @Path("imageradiologique")
    @Produces("application/json")
    public List<ImageRadiologique> getImageRadiologique(@DefaultValue("") @QueryParam("im") String im) {
        //TODO return proper representation object
        
        System.out.println("Valeur du query params : " + im);
        if (!(im.isEmpty())) {
            System.out.println("Recherche des images pour le patient : " + im);
            return serv.getImagesByAdmission(im);
            
        } else {
            return serv.getAllImageRadiologique();
        }
    }

    //Obtenir une image
    @GET
    @Path("imageradiologique/{im}")
    @Produces("application/json")
    public ImageRadiologique getImageRadiologiqueById(@PathParam("im") Long imageRadiologiqueId) {
        //TODO return proper representation object
        return serv.getImageRadiologiqueById(imageRadiologiqueId);
    }

    //Créer un acte radiologique OK
    @POST
    @Path("acteradiologique")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public ActeRadiologique newActeRadiologique(ActeRadiologique act) {
        System.out.println(act);
//        List<ImageRadiologique> images;
//        images = new ArrayList<>();
//        act.setImages(images);
        serv.newActeRadiologique2(act);

        //System.out.println("Acte radiologique créé le " + act.getActeRadiologiqueDate()+ " pour l'admission "+ act.getAdmission().getAdmissionIEP());
        return act;
    }

    //Créer une modalité d'imagerie OK
    @POST
    @Path("appareil")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Appareil newAppareil(Appareil appa) {
        serv.newAppareil2(appa);
//        serv.newAppareil(appa.getAppareilLibelle(), appa.getAppareilModalite());
//        System.out.println("L'appareil "+appa.getAppareilLibelle()+"a été ajouté ");
        return appa;
    }

    //Créer une nomenclature CCAM 
    //NE PLUS UTILISER
    @POST
    @Path("nomemclatureCCAM")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public NomemclatureCCAM newNomemclature(NomemclatureCCAM no) {
        serv.newNomemclatureCCAM(no.getNomenclatureCCAMLibelle(), no.getNomemclatureCCAMCode());
        System.out.println("La nomemclature " + no.getNomenclatureCCAMLibelle() + "a été ajoutée ");
        return no;
    }

    //Créer une nomenclature CCAM (le bon)
    @POST
    @Path("CCAM")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public CCAM newCCAM(CCAM ccam) {
        serv.newCCAM2(ccam);
        //System.out.println("La nomenclature "+ccam.getCCAMLibelle()+"a été ajoutée ");
        return ccam;
    }

    //Créer une image
    @POST
    @Path("imageradiologique")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public ImageRadiologique newImageRadiologique(ImageRadiologique im) {
        serv.newImageRadiologique2(im);
        //System.out.println("L'image "+im.getImageRadiologiqueLibelle()+"a été ajoutée ");
        return im;
    }

    //Créer une admission
    @POST
    @Path("admission")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Admission newAdmission(Admission ad) {
        serv.newAdmission2(ad);
        //System.out.println("L'admission "+ad.getAdmissionIPP()+"a été ajoutée ");
        return ad;
    }

    //Supprimer un appareil
    @DELETE
    @Path("appareil")
    public Response removeAppareil(Appareil ap) {
        System.out.println("suppression ");
        serv.removeAppareil(ap);
        return Response.status(200).build();
    }

    //Supprimer une image
    @DELETE
    @Path("imageradiologique/{im}")
    public Response removeimageradiologique(@PathParam("im") Long imageRadiologiqueId) {
        
        serv.removeImageRadiologique(imageRadiologiqueId);
        return Response.status(200).build();
    }

    //Supprimer un CCAM
    @DELETE
    @Path("CCAM/{no}")
    public Response removeCCAM(@PathParam("no") Long CCAMid) {
        serv.removeCCAM(CCAMid);
        return Response.status(200).build();
    }

    //Supprimer une admission
    @DELETE
    @Path("admission/{iep}")
    public Response removeAdmission(@PathParam("iep") Long admissionIEP) {
        serv.removeAdmission(admissionIEP);
        return Response.status(200).build();
    }

    //Ajouter une image à un acte --> LE coupable !!!!!!!!!!!!
//    @POST
//    @Path("acteradiologique/{iep}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces("application/json")
//    public Response updateActeRadiologiqueImage (ActeRadiologique act, ImageRadiologique img)
//    {
//        serv.updateActeRadiologiqueImage(act, img);
//        return Response.status(200).entity(act).build();
//    }
}
