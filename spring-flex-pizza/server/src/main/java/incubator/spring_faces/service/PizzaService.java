package incubator.spring_faces.service;

import incubator.spring_flex.dto.Pizza;

import java.util.List;


/**
 * Business interface of the pizza services.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
public interface PizzaService {

    /**
     * Loads all available pizzas.
     * 
     * @return List containing all pizzas.
     */
    List<Pizza> loadPizzas();

    /**
     * Load the pizza with the passed id.
     * 
     * @param id
     *            the id of the pizza to load
     * @return the appertaining pizza instance, or null if there is no pizza with this id.
     */
    Pizza loadPizza(Long id);
}
