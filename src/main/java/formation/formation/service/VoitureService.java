package formation.formation.service;

import formation.domain.Voiture;
import formation.persistence.VoitureDAOItf;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by poutsjr on 30/09/2015.
 */
@Remote
@Stateless
public class VoitureService implements VoitureServiceItf{

    @EJB
    VoitureDAOItf dao;

    @Override
    public int total() {
        return dao.findAll().size();
    }

    @Override
    public Voiture create(Voiture voiture) {
        //FIXME validate voiture
        Voiture v =  dao.create(voiture);
        return v;
    }


}
