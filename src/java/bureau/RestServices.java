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
        System.out.println("id:"+cr.getId());
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
    public List<ActeRadiologique> getActeRadiologiques(@PathParam("ipp") String ipp) {
        //TODO return proper representation object
        Services serv = new Services(DatabaseUtils.fact());
        return serv.getActeRadiologiqueByAdmission(ipp);
    }
    
    //Obtenir les actes radiologiques d'une admission OK
    @GET
    @Path("admission/{iep}")
    @Produces("application/json")
    public Admission getAdmissions(@PathParam("iep") Long iep) {
        //TODO return proper representation object
        Services serv = new Services(DatabaseUtils.fact());
        return serv.getAdmission(iep);
    }
     
    //Consulter les images d'un patient OK
    @GET
    @Path("acteradiologique/{ipp}")
    @Produces("application/json")
    public List<ImageRadiologique> getImagesByAdmission(@PathParam("ipp") String ipp){
         Services serv = new Services(DatabaseUtils.fact());
         return serv.getImagesByAdmission(ipp);
    }
    
    //Obtenir tous les appareils
    @GET
    @Path("appareils")
    @Produces("application/json")
    public List<Appareil> getAppareils() {
        //TODO return proper representation object
        return serv.getAllAppareil();
    }
    
    //Obtenir toutes les nomenclature
    @GET
    @Path("nomemclatureCCAM")
    @Produces("application/json")
    public List<NomemclatureCCAM> getNomemclatureCCAM() {
        //TODO return proper representation object
        return serv.getAllNomemclatureCCAM();
    }
    
    //Obtenir toutes les images
     //Obtenir toutes les nomenclature
    @GET
    @Path("imageradiologique")
    @Produces("application/json")
    public List<ImageRadiologique> getImageRadiologique() {
        //TODO return proper representation object
        return serv.getAllImageRadiologique();
    }
   
    
    //Créer un acte radiologique OK
    @POST
    @Path("acteradiologique")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public ActeRadiologique newActeRadiologique(ActeRadiologique act) {
        serv.newActeRadiologique(act.getActeRadiologiqueDate(), act.getAdmission(), act.getImages(), act.getAppareil(), act.getNomenclatureCCAM());
        System.out.println("Acte radiologique créé le " + act.getActeRadiologiqueDate()+ " pour l'admission "+ act.getAdmission().getAdmissionIEP());
        return act;
    }
    
    //Créer une modalité d'imagerie OK
    @POST
    @Path("appareil")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Appareil newAppareil(Appareil appa){
        serv.newAppareil(appa.getAppareilLibelle(), appa.getAppareilModalite());
        System.out.println("L'appareil "+appa.getAppareilLibelle()+"a été ajouté ");
        return appa;
    }
    
    //Créer une nomenclature CCAM
    @POST
    @Path("nomemclatureCCAM")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public NomemclatureCCAM newNomemclature(NomemclatureCCAM no){
        serv.newNomemclatureCCAM(no.getNomenclatureCCAMLibelle(), no.getNomemclatureCCAMCode());
        System.out.println("La nomemclature "+no.getNomenclatureCCAMLibelle()+"a été ajoutée ");
        return no;
    }
    
     //Créer une image
    @POST
    @Path("imageradiologique")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public ImageRadiologique newImageRadiologique(ImageRadiologique im){
        serv.newImageRadiologique(im.getImageRadiologiqueFormat(), im.getImageRadiologiqueLibelle(), im.getImageRadiologiquePoids(), im.getImageRadiologiqueURL());
        System.out.println("L'image "+im.getImageRadiologiqueLibelle()+"a été ajoutée ");
        return im;
    }
    
    //Supprimer un appareil
    @DELETE
    @Path("appareil/{appareilId}")
    public Response removeAppareil(@PathParam("appareilId") int id) {
        serv.removeAppareil(id);
        return Response.status(200).build();
    }
    
    //Ajouter une image à un acte --> LE coupable !!!!!!!!!!!!
    /*
    @POST
    @Path("acteradiologique/{iep}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response updateActeRadiologiqueImage (ActeRadiologique act, ImageRadiologique img)
    {
        serv.updateActeRadiologiqueImage(act, img);
        return Response.status(200).entity(act).build();
    }
    */
    
    
   
}
