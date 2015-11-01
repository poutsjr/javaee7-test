package formation.formation.service;

import formation.domain.Voiture;
import formation.persistence.VoitureDAOItf;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Default implementation for managing voiture
 */
@Remote
@Stateless
public class VoitureService implements VoitureServiceItf{

    /**
     * Allow to manage voiture persistence
     */
    @EJB
    VoitureDAOItf dao;

    @Override
    public int total() {
        return dao.findAll().size();
    }

    @Override
    public Voiture create(Voiture voiture) throws Exception {
        //FIXME validate voiture
        Voiture v =  dao.create(voiture);
        return v;
    }

    @Override
    public Voiture get(Long id) {
        return dao.find(id);
    }


}
