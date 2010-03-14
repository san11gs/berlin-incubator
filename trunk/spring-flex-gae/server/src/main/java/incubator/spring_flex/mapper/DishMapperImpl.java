package incubator.spring_flex.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import incubator.spring_flex.domain.DishEntity;
import incubator.spring_flex.domain.PizzaEntity;
import incubator.spring_flex.dto.Dish;
import incubator.spring_flex.dto.Pizza;

@Component("dishMapper")
public class DishMapperImpl implements DishMapper {

    @Autowired
    private PizzaMapper pizzaMapper;

    public Dish mapToDish(DishEntity dishEntity) {
        if (dishEntity == null) {
            return null;
        }
        if (dishEntity instanceof PizzaEntity) {
            return this.pizzaMapper.mapToPizza((PizzaEntity) dishEntity);
        }
        throw new IllegalArgumentException("Unsupported Type: " + dishEntity.getClass().getName());
    }

    public DishEntity mapToDishEntity(Dish dish) {
        if (dish == null) {
            return null;
        }
        if (dish instanceof Pizza) {
            return this.pizzaMapper.mapToPizzaEntity((Pizza) dish);
        }
        throw new IllegalArgumentException("Unsupported Type: " + dish.getClass().getName());
    }

}
