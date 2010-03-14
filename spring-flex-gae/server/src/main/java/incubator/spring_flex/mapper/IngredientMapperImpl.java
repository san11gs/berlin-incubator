package incubator.spring_flex.mapper;

import org.springframework.stereotype.Component;

import com.google.appengine.api.datastore.KeyFactory;

import incubator.spring_flex.domain.IngredientEntity;
import incubator.spring_flex.dto.Ingredient;

@Component("ingredientMapper")
public class IngredientMapperImpl implements IngredientMapper {

    public Ingredient mapToIngredient(IngredientEntity ingredientEntity) {
        if(ingredientEntity == null){
            return null;
        }
        Ingredient ingredient = new Ingredient();
        //ingredient.setKey(KeyFactory.keyToString(ingredientEntity.getKey()));
        ingredient.setName(ingredientEntity.getName());
        return ingredient;
    }

    public IngredientEntity mapToIngredientEntity(Ingredient ingredient) {
        if(ingredient == null){
            return null;
        }
        IngredientEntity ingredientEntity = new IngredientEntity();
        //ingredientEntity.setKey(KeyFactory.stringToKey(ingredient.getKey()));
        ingredientEntity.setName(ingredient.getName());
        return ingredientEntity;
    }


}
