package incubator.spring_flex.mapper;

import incubator.spring_flex.domain.DishEntity;
import incubator.spring_flex.dto.Dish;

public interface DishMapper {

    DishEntity mapToDishEntity(Dish dish);

    Dish mapToDish(DishEntity dishEntity);

}
