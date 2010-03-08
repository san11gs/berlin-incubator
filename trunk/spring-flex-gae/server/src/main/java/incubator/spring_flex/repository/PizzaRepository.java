package incubator.spring_flex.repository;

import incubator.spring_flex.domain.Pizza;
import incubator.spring_flex.persistence.JpaGenericDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


/**
 * Business interface of the pizza services.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Repository("pizzaManager")
public class PizzaRepository {

    private JpaGenericDAO<Pizza, Long> pizzaDao = null;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.pizzaDao = new JpaGenericDAO<Pizza, Long>(entityManager, Pizza.class);
    }

    public List<Pizza> loadPizzas() {
        return this.pizzaDao.loadAll();
    }

    public Pizza loadPizza(Long id) {
        return this.pizzaDao.load(id);
    }
    
//	private Map<Long, Pizza> pizzaMap = new HashMap<Long, Pizza>();
//	
//	public PizzaManager(){
//		Pizza pizza1 = new Pizza();
//		pizza1.setId(Long.valueOf(1));
//		pizza1.setName("Salami");
//		pizza1.setPrice(4.5);
//		
//		Pizza pizza2 = new Pizza();
//		pizza2.setId(Long.valueOf(2));
//		pizza2.setName("Proscuitto");
//		pizza2.setPrice(5.0);
//		
//		Pizza pizza3 = new Pizza();
//		pizza3.setId(Long.valueOf(3));
//		pizza3.setName("Hawaii");
//		pizza3.setPrice(5.5);
//		
//		Pizza pizza4 = new Pizza();
//		pizza4.setId(Long.valueOf(4));
//		pizza4.setName("Tonno");
//		pizza4.setPrice(4.5);
//		
//		this.pizzaMap.put(pizza1.getId(), pizza1);
//		this.pizzaMap.put(pizza2.getId(), pizza2);
//		this.pizzaMap.put(pizza3.getId(), pizza3);
//		this.pizzaMap.put(pizza4.getId(), pizza4);
//	}
//   
//    public List<Pizza> loadPizzas() {
//    	return new ArrayList<Pizza>(this.pizzaMap.values());
//    }
//
//    public Pizza loadPizza(Long id){
//    	return this.pizzaMap.get(id);
//    }
}
