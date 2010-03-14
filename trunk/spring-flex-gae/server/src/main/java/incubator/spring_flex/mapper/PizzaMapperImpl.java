package incubator.spring_flex.mapper;

import java.util.ArrayList;
import java.util.Collection;

import incubator.spring_flex.domain.IngredientEntity;
import incubator.spring_flex.domain.PizzaEntity;
import incubator.spring_flex.dto.Ingredient;
import incubator.spring_flex.dto.Pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.appengine.api.datastore.KeyFactory;

@Component("pizzaMapper")
public class PizzaMapperImpl implements PizzaMapper {

    @Autowired
    private IngredientMapper ingredientMapper;
    
    public PizzaEntity mapToPizzaEntity(Pizza pizza){
        if(pizza == null){
            return null;
        }
        PizzaEntity pizzaEntity = new PizzaEntity();
        if(pizza.getKey() != null){
            //pizzaEntity.setKey(KeyFactory.stringToKey(pizza.getKey()));
        }
        pizzaEntity.setName(pizza.getName());
        pizzaEntity.setPrice(pizza.getPrice());
        pizzaEntity.setPizzaType(pizza.getPizzaType());

        Collection<IngredientEntity> ingredients = new ArrayList<IngredientEntity>();
        for(Ingredient ingredient : pizza.getIngredients()){
            ingredients.add(this.ingredientMapper.mapToIngredientEntity(ingredient));
        }
        pizzaEntity.setIngredients(ingredients);
        
        return pizzaEntity;
    }

    public Pizza mapToPizza(PizzaEntity pizzaEntity){
        if(pizzaEntity == null){
            return null;
        }
        Pizza pizza = new Pizza();
        pizza.setKey(KeyFactory.keyToString(pizzaEntity.getKey()));
        pizza.setName(pizzaEntity.getName());
        pizza.setPrice(pizzaEntity.getPrice());
        pizza.setPizzaType(pizzaEntity.getPizzaType());

        Collection<Ingredient> ingredients = new ArrayList<Ingredient>();
        for(IngredientEntity ingredientEntity : pizzaEntity.getIngredients()){
            ingredients.add(this.ingredientMapper.mapToIngredient(ingredientEntity));
        }
        pizza.setIngredients(ingredients);
        
        return pizza;
    }
    
}
