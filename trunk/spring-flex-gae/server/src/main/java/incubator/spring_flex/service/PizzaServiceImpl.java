package incubator.spring_flex.service;

import incubator.spring_flex.domain.PizzaEntity;
import incubator.spring_flex.dto.Pizza;
import incubator.spring_flex.mapper.PizzaMapper;
import incubator.spring_flex.repository.PizzaRepository;

import java.util.ArrayList;
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
	
	@Autowired
	private PizzaMapper pizzaMapper;
	
	/**
	 * Transactional read-only method.
	 * 
	 * @see incubator.spring_flex.service.PizzaService#loadPizza(Long)
	 */
	public Pizza loadPizza(Long id) {
		PizzaEntity pizzaEntity = this.pizzaRepository.loadPizza(id);
		return this.pizzaMapper.mapToPizza(pizzaEntity);
	}

	/**
	 * @see incubator.spring_flex.service.PizzaService#getAllPizzas()
	 */
	public List<Pizza> getAllPizzas() {
	    System.out.println("getAllPizzas");
		List<PizzaEntity> pizzaEntities = this.pizzaRepository.loadPizzas();
		if(pizzaEntities == null || pizzaEntities.size()==0){
		    System.out.println("pizzaRepository.init()");
		    this.pizzaRepository.init();
		}
		pizzaEntities = this.pizzaRepository.loadPizzas();
		System.out.println("pizzaEntities.size:" + pizzaEntities.size());
		List<Pizza> pizzas = new ArrayList<Pizza>();
		for(PizzaEntity pizzaEntity : pizzaEntities){
		    pizzas.add(this.pizzaMapper.mapToPizza(pizzaEntity));
		}
		System.out.println("pizzas.size:" + pizzas.size());
		return pizzas;
	}

}
