package incubator.spring_flex.repository;

import incubator.spring_flex.domain.IngredientEntity;
import incubator.spring_flex.domain.PizzaEntity;
import incubator.spring_flex.dto.enums.PizzaType;
import incubator.spring_flex.persistence.JpaGenericDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Business interface of the pizza services.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Repository("pizzaManager")
public class PizzaRepository {

    private JpaGenericDAO<PizzaEntity, Long> pizzaDao = null;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.pizzaDao = new JpaGenericDAO<PizzaEntity, Long>(entityManager, PizzaEntity.class);
    }

    public void init() {
        try {
            System.out.println("PizzaRepository#init; pizzaDao:" + this.pizzaDao);
            
            PizzaEntity pizzaSalami = new PizzaEntity();
            pizzaSalami.setName("Salami - Classic");
            pizzaSalami.setPrice(5.0);
            pizzaSalami.setPizzaType(PizzaType.CLASSIC);
            Collection<IngredientEntity> ingredients = new ArrayList<IngredientEntity>();
            ingredients.add(new IngredientEntity("Salami"));
            ingredients.add(new IngredientEntity("Cheese"));
            pizzaSalami.setIngredients(ingredients);
            
            PizzaEntity pizzaSalami2 = new PizzaEntity();
            pizzaSalami2.setName("Salami - Chessy");
            pizzaSalami2.setPrice(5.0);
            pizzaSalami2.setPizzaType(PizzaType.CHEESY);
            ingredients = new ArrayList<IngredientEntity>();
            ingredients.add(new IngredientEntity("Salami"));
            ingredients.add(new IngredientEntity("Cheese"));
            pizzaSalami2.setIngredients(ingredients);
            
            PizzaEntity pizzaProsciutto = new PizzaEntity();
            pizzaProsciutto.setName("Proscuitto - Pan");
            pizzaProsciutto.setPrice(4.5);
            pizzaProsciutto.setPizzaType(PizzaType.PAN);
            ingredients = new ArrayList<IngredientEntity>();
            ingredients.add(new IngredientEntity("Proscuitto"));
            ingredients.add(new IngredientEntity("Cheese"));
            pizzaProsciutto.setIngredients(ingredients);
            
            PizzaEntity pizzaHawaii = new PizzaEntity();
            pizzaHawaii.setName("Hawaii - Pan");
            pizzaHawaii.setPrice(4.5);
            pizzaHawaii.setPizzaType(PizzaType.PAN);
            ingredients = new ArrayList<IngredientEntity>();
            ingredients.add(new IngredientEntity("Proscuitto"));
            ingredients.add(new IngredientEntity("Cheese"));
            ingredients.add(new IngredientEntity("Pineapple"));
            pizzaHawaii.setIngredients(ingredients);
            
            persistPizza(pizzaSalami);
            persistPizza(pizzaSalami2);
            persistPizza(pizzaProsciutto);
            persistPizza(pizzaHawaii);
            
            System.out.println("PizzaRepository#init; done");
        } catch(Exception e){
            System.out.println("Exception: ");
            e.printStackTrace(System.out);
        }
    }
    
    @Transactional
    public PizzaEntity persistPizza(PizzaEntity pizzaEntity){
        System.out.print("persistPizza");
        pizzaEntity = this.pizzaDao.persist(pizzaEntity);
        System.out.println("..persisted");
        return pizzaEntity;
    }

    @Transactional
    public List<PizzaEntity> loadPizzas() {
        System.out.println("loadPizzas");
        List<PizzaEntity> pizzaEntities = this.pizzaDao.findByNamedQuery("PizzaEntity.loadAll");
        if(pizzaEntities == null){
            pizzaEntities = new ArrayList<PizzaEntity>();
        }
        System.out.println("loadPizzas: pizzaEntities.size=" + pizzaEntities.size());
        return pizzaEntities;
    }

    @Transactional
    public PizzaEntity loadPizza(Long id) {
        return this.pizzaDao.load(id);
    }
    
}
