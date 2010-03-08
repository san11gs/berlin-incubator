package incubator.spring_flex.service;

import incubator.spring_flex.domain.Pizza;
import incubator.spring_flex.repository.PizzaRepository;

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
	private PizzaRepository pizzaRepository;
	
	/**
	 * Transactional read-only method.
	 * 
	 * @see incubator.spring_flex.service.PizzaService#loadPizza(Long)
	 */
	public Pizza loadPizza(Long id) {
		return this.pizzaRepository.loadPizza(id);
	}

	/**
	 * Transactional read-only method.
	 * 
	 * @see incubator.spring_flex.service.PizzaService#loadPizza(Long)
	 */
	public List<Pizza> loadPizzas() {
		return this.pizzaRepository.loadPizzas();
	}
	
	/*
	 * Getter  Setter
	 */

	public PizzaRepository getPizzaManager() {
		return this.pizzaRepository;
	}

	public void setPizzaManager(PizzaRepository pizzaManager) {
		this.pizzaRepository = pizzaManager;
	}
	

}
