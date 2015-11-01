package formation.persistence;

import formation.domain.Voiture;

import javax.ejb.Local;
import java.util.List;
import java.util.Set;

/**
 * DAO for insert and retrieve voiture in database.
 * Created by poutsjr on 30/09/2015.
 */
public interface VoitureDAOItf {

    /**
     * Return all voitres in the database
     *
     * @return a set of voiture
     */
    List<Voiture> findAll();


    /**
     * allow to create voiture (without id)
     *
     * @param voiture The voiture to create.
     * @return the new voiture.
     */
    Voiture create(Voiture voiture) throws Exception;

    /**
     * Find a voiture with the given identifier
     *
     * @param id The id of the voiture
     * @return The found voiture or null if not found
     */
    Voiture find(Long id);
}
