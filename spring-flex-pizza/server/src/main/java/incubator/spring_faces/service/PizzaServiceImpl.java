package incubator.spring_faces.service;

import incubator.spring_faces.manager.PizzaManager;
import incubator.spring_flex.domain.Pizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for loading pizzas (business delegate pattern!!).
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Service("pizzaService")
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaManager pizzaManager;
	
	/**
	 * Transactional read-only method.
	 * 
	 * @see incubator.spring_faces.service.PizzaService#loadPizza(Long)
	 */
	public Pizza loadPizza(Long id) {
		return this.pizzaManager.loadPizza(id);
	}

	/**
	 * Transactional read-only method.
	 * 
	 * @see incubator.spring_faces.service.PizzaService#loadPizza(Long)
	 */
	public List<Pizza> loadPizzas() {
		return this.pizzaManager.loadPizzas();
	}
	
	/*
	 * Getter  Setter
	 */

	public PizzaManager getPizzaManager() {
		return this.pizzaManager;
	}

	public void setPizzaManager(PizzaManager pizzaManager) {
		this.pizzaManager = pizzaManager;
	}
	

}
