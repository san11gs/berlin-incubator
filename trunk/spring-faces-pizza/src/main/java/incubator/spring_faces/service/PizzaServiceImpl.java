package incubator.spring_faces.service;

import incubator.spring_faces.model.Order;
import incubator.spring_faces.model.Pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * A JPA based implementations of the {@link PizzaService}.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Service("pizzaService")
@Repository
public class PizzaServiceImpl implements PizzaService {

    /*
     * This entity manager is provided and injected by spring.
     */
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
     * Transactional read-only method.
     * 
     * @see incubator.spring_faces.service.PizzaService#loadPizza(Long)
     */
    @Transactional(readOnly = true)
    public Pizza loadPizza(Long id) {
        if(id == null){
            return null;
        }
        return this.em.find(Pizza.class, id);
    }

    /**
     * Transactional read-only method.
     * 
     * @see incubator.spring_faces.service.PizzaService#loadPizza(Long)
     */
    @Transactional(readOnly = true)
    public List<Pizza> loadPizzas() {
        List<Pizza> pizzas = this.em.createQuery("select p from Pizza p").getResultList();        
        return pizzas;
    }

}
