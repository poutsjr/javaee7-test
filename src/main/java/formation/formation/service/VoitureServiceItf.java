package formation.formation.service;

import formation.domain.Voiture;

/**
 * Service for managing voiture.
 * Created by poutsjr on 30/09/2015.
 */
public interface VoitureServiceItf {

    /**
     * Count the number of voiture.
     *
     * @return le nombre de voiture.
     */
    public int total();

    /**
     * Create a new voiture.
     *
     * @param voiture The voiture to create.
     * @return The created voiture.
     */
    public Voiture create(Voiture voiture);
}
