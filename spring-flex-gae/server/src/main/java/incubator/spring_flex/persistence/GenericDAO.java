/**
 * 
 */
package incubator.spring_flex.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * Generic interface for DAOs.
 * 
 * @author iwaszkiewicz
 * 
 * @param <E>
 *            Class of the entity to handle.
 * @param <ID>
 *            Class of the entity's id.
 */
public interface GenericDAO<E, ID extends Serializable> {

    /**
     * Loads the entity with the passed id.
     * 
     * @param _id
     *            the id of the entity to load.
     * @return the loaded entity or null if there is no one with the passed id.
     */
    E load(ID _id);

    /**
     * Load all.
     * 
     * @return List
     */
    List<E> loadAll();

    /**
     * Persist the passed entity to the database. If the entity already exists, update it.
     * 
     * @param _entity
     *            the entity to save
     * @return returns the saved entity
     */
    E persist(E _entity);

    /**
     * Deletes the passed entity from database.
     * 
     * @param _entity
     *            the entity to remove.
     */
    void delete(E _entity);

    /**
     * Checks whether an entity with the passed id already exists in the database.
     * 
     * @param _id
     *            The id to look for.
     * @return true if there is already an entity with the passed id, otherwise false.
     */
    boolean exists(ID _id);

}
