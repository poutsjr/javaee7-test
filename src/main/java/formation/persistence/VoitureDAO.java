package formation.persistence;

import formation.domain.Voiture;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Created by poutsjr on 30/09/2015.
 */
@Local
@Stateless
public class VoitureDAO implements VoitureDAOItf {

    @PersistenceContext(unitName = "vraitest")
    private EntityManager em;

    @Override
    public List<Voiture> findAll() {
         TypedQuery<Voiture> query = em.createNamedQuery("findAll", Voiture.class);
         return query.getResultList();
    }

    @Override
    public Voiture create(Voiture voiture) {
        //TODO manage transaction ??
        try {
            em.persist(voiture);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
                throw new IllegalArgumentException(constraintViolation.getMessage(), e);
            }

        }
            return voiture;
    }
}
