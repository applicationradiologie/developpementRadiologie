/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bureau.ActeRadiologique;
import static bureau.ActeRadiologique_.CCAM;
import bureau.Admission;
import bureau.Appareil;
import bureau.Boite;
import bureau.Crayon;
import bureau.DatabaseUtils;
import bureau.ImageRadiologique;
import bureau.CCAM;
import bureau.Services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kurasawa
 */
public class bureauTest {

    static EntityManagerFactory fact;

    public bureauTest() {

    }

    static void clean() {
        Services serv = new Services(DatabaseUtils.fact());
        serv.deleteAllBoites();
        serv.deleteAllCrayons();
        serv.deleteAllActeRadiologique();
        serv.deleteAllAdmission();
        serv.deleteAllAppareil();
        serv.deleteAllImageRadiologique();
        serv.deleteAllNomemclatureCCAM();
        List<Crayon> res = serv.getAllCrayons();
        List<Admission> res2 = serv.getAllAdmission();
        assert (res.isEmpty());
    }

    @BeforeClass
    public static void setUpClass() {
        clean();

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    @Test
    public void crayon() {
        clean();
        Services serv = new Services(DatabaseUtils.fact());
        Crayon cr = serv.newCrayon("vert");
        assertNotNull(cr);
        cr = serv.newCrayon("jaune");
        assertNotNull(cr);
        cr = serv.newCrayon("vert");
        assertNotNull(cr);
        List<Crayon> res = serv.getCrayonsByCouleurId("vert");
        assert (!res.isEmpty());
        assert (res.size() == 2);

        res = serv.getAllCrayons();
        assert (!res.isEmpty());
        assert (res.size() == 3);

    }

    @Test
    public void boite() {
        clean();
        Services serv = new Services(DatabaseUtils.fact());
        List<Crayon> liste = new ArrayList<>();
        String[] couleurs = {"rouge", "jaune", "vert"};
        for (String c : couleurs) {
            Crayon cr = new Crayon();
            cr.setCouleur(c);
            liste.add(cr);
        }
        Boite b = serv.newBoite(liste);
        assertNotNull(b);

        List<Boite> boites = serv.getBoitesByCouleurDeCrayon("vert");
        assert (!boites.isEmpty());
        assert (!boites.get(0).getCrayons().isEmpty());
        assert (boites.get(0).getCrayons().get(2).getCouleur().equals("vert"));

    }

    @Test
    public void Appareil() {
        clean();
        Services serv = new Services(DatabaseUtils.fact());
        Appareil ap = serv.newAppareil("Appareil service neurologie", "IRM");
        assertNotNull(ap);
        ap = serv.newAppareil("Appareil pneumologie", "Scanner");
        assertNotNull(ap);
        ap = serv.newAppareil("Obstétrique", "Echographe");
        assertNotNull(ap);

    }

    @Test
    public void NomemclatureCCAM() {
        //clean();
        Services serv = new Services(DatabaseUtils.fact());
        CCAM nc = serv.newCCAM("Radiologie du thorax", "ZBQK002");
        assertNotNull(nc);
        nc = serv.newCCAM("Radiographie de labdomen sans préparation", "ZCQK002");
        assertNotNull(nc);
        nc = serv.newCCAM("Scannographie des vaisseaux encéphalique", "EAQH002");
        assertNotNull(nc);
        nc = serv.newCCAM("Scannographie des vaisseaux cervicaux", "EBQH006");
        assertNotNull(nc);
        nc = serv.newCCAM("Restitution tridimensionnelle des images acquises par remnographie", "ZZQN002");
        assertNotNull(nc);
        nc = serv.newCCAM("Remnographie fonctionnelle du cerveau pour étude des fonctions motrices", "AAQN004");
        assertNotNull(nc);
    }

    @Test
    public void CCAM() {
        Services serv = new Services(DatabaseUtils.fact());
        CCAM nc = serv.newCCAM("Radiologie ", "ZK002");
        assertNotNull(nc);
    }

    @Test
    public void ImageRadiologique() {
        //clean();
        Services serv = new Services(DatabaseUtils.fact());
        ImageRadiologique im = serv.newImageRadiologique("JPG", "Bouteille ", "34KoB", "http://www.image-drole.eu/wp-content/uploads/2010/03/coca.jpg");
        assertNotNull(im);
        im = serv.newImageRadiologique("JPG", "Cerveau ", "500KoB", "http://img.medicalexpo.fr/images_me/photo-g/69419-8267635.jpg");
        assertNotNull(im);

    }

    @Test
    public void Admission() {
        //clean();
        Services serv = new Services(DatabaseUtils.fact());
        Admission adm = serv.newAdmission("4454fd1fdsfsd");
        assertNotNull(adm);
        adm = serv.newAdmission("882dfd824552aa");
        assertNotNull(adm);
        adm = serv.newAdmission("4565dsf56df2d62d00");
        assertNotNull(adm);
        adm = serv.newAdmission("89256fd2s54fdfds");
        assertNotNull(adm);
        adm = serv.newAdmission("0052345fdofzdjfze");
        assertNotNull(adm);
    }

    @Test
    public void ActeRadiologique() throws ParseException {
        //clean();
        Services serv = new Services(DatabaseUtils.fact());
        //Creation des images
        List<ImageRadiologique> liste = new ArrayList<>();
        ImageRadiologique im = serv.newImageRadiologique("http://www.image-drole.eu/wp-content/uploads/2010/03/coca.jpg", "JPG", "34KoB", "Bouteille Rectum");
        liste.add(im);
        ImageRadiologique im2 = serv.newImageRadiologique("http://www.irmdole.fr/imagesUp/galerie/23.jpg", "DICOM", "80KoB", "Cerveau");
        liste.add(im2);
        ImageRadiologique im3 = serv.newImageRadiologique("http://radiologie-drome-ardeche.fr/wp/wp-content/uploads/2013/05/radio-abdomen-sans-preparation.jpg", "DICOM", "96KoB", "Abdomen");
        liste.add(im3);
        ImageRadiologique im4 = serv.newImageRadiologique("http://www.info-radiologie.ch/pouteau-colles/fullsize/pouteau-colles-15_fs.jpg", "DICOM", "43KoB", "3D");
        liste.add(im4);
        //Creation de l'admission

        Admission adm = serv.newAdmission("4454fd1fdsfsd");
        Long iep = adm.getAdmissionIEP();
        //Creation de l'appareil
        Appareil ap = serv.newAppareil("Appareil service neurologie", "IRM");
        //Nomemclature
        CCAM nc = serv.newCCAM("Restitution", "ZZQN002");

        //Creation de l'acte radiologique
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse("14/10/2015");
        ActeRadiologique a = serv.newActeRadiologique(d, adm, liste, ap, nc);
        assertNotNull(a);

        //Test de récuperation l'acte radiogique d'une admission
        List<ActeRadiologique> actes = serv.getActeRadiologiqueByAdmission("4454fd1fdsfsd");
        assert (!actes.isEmpty());
        assert (actes.get(0).getAdmission().getAdmissionIEP() == iep);

        //Test d'ajout d'une image à un acte radiollogique
        ImageRadiologique im5 = serv.newImageRadiologique("http://www.radiologie-luton-reims.fr/imageszoom/image003.gif", "gif", "56KoB", "Main");
        serv.updateActeRadiologiqueImage(a, im5);
        assertNotNull(a);

        //Test consulter les images d'un patient
        List<ImageRadiologique> images = serv.getImagesByAdmission("4454fd1fdsfsd");
        assertNotNull(a);

    }

}
