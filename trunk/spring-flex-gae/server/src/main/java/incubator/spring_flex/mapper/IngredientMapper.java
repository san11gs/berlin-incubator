package incubator.spring_flex.mapper;

import incubator.spring_flex.domain.IngredientEntity;
import incubator.spring_flex.dto.Ingredient;

public interface IngredientMapper {

    IngredientEntity mapToIngredientEntity(Ingredient ingredient);

    Ingredient mapToIngredient(IngredientEntity ingredientEntity);

}
