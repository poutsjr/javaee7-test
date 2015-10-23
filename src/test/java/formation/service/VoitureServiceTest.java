package formation.service;

import formation.domain.Voiture;
import formation.formation.service.VoitureService;
import formation.formation.service.VoitureServiceItf;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by poutsjr on 30/09/2015.
 */
public class VoitureServiceTest {

    // ======================================
    // =             Attributes             =
    // ======================================

    protected static Context ctx;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @BeforeClass
    public static void initContainer() throws Exception {
        ctx = new InitialContext();
    }

    @AfterClass
    public static void closeContainer() throws Exception {
        if (ctx != null) {
            ctx.close();
        }
    }

    @Test
    public void validCase_createVoiture() throws NamingException {
        Object ejb = ctx.lookup("java:global/vrai-test-1.0.0-SNAPSHOT/VoitureService");
        assertNotNull(ejb);

        // Looks up the EJB
        VoitureServiceItf voitureService = (VoitureServiceItf) PortableRemoteObject.
                narrow(ejb, VoitureServiceItf.class);

        int initSize = voitureService.total();
        Voiture v = new Voiture();
        v.setImmatriculation("AZ 123 RE");
        v = voitureService.create(v);
        assertNotNull(v.getId());
        assertEquals(initSize + 1, voitureService.total());

    }

    @Test
    public void createVoitureWithoutImmatriculation() throws NamingException {
        Object ejb = ctx.lookup("java:global/vrai-test-1.0.0-SNAPSHOT/VoitureService");
        assertNotNull(ejb);

        // Looks up the EJB
        VoitureServiceItf voitureService = (VoitureServiceItf) PortableRemoteObject.
                narrow(ejb, VoitureServiceItf.class);

        Voiture v = new Voiture();
        v.setImmatriculation(null);
        try {
            voitureService.create(v);
            fail("IllegalArgumentException attendue car pas d'immatriculation");
        }catch(Exception e) {
            assertEquals("immatriculation obligatoire", e.getMessage());
        }
    }
}
