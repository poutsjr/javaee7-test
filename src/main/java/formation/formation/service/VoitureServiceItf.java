package formation.formation.service;

import formation.domain.Voiture;

import javax.ws.rs.core.Response;

/**
 * Service for managing voiture.
 */
public interface VoitureServiceItf {

    /**
     * Count the number of voiture.
     *
     * @return le nombre de voiture.
     */
    int total();

    /**
     * Create a new voiture.
     *
     * @param voiture The voiture to create.
     * @return The created voiture.
     */
    Voiture create(Voiture voiture) throws Exception;

    /**
     * Return the voiture with the given identifier
     * @param id the identifier of the voiture
     * @return  The found voiture or null if not found.
     */
    Voiture get(Long id);
}
