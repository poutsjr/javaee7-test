package formation.persistence;

import formation.domain.Voiture;
import sun.security.validator.ValidatorException;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;

/**
 * DAO Implementation for voiture
 */
@Local
@Stateless
public class VoitureDAO implements VoitureDAOItf {

    /**
     * EntityManager of DAO
     */
    @PersistenceContext(unitName = "vraitest")
    private EntityManager em;

    @Override
    public List<Voiture> findAll() {
         TypedQuery<Voiture> query = em.createNamedQuery("findAll", Voiture.class);
         return query.getResultList();
    }

    @Override
    public Voiture create(Voiture voiture) throws Exception{
        //TODO manage transaction ??
        try {
            em.persist(voiture);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
                throw new Exception(constraintViolation.getMessage(), e);
            }

        }
            return voiture;
    }

    @Override
    public Voiture find(Long id) {
        return em.find(Voiture.class, id);
    }
}
