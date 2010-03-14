package incubator.spring_flex.mapper;

import incubator.spring_flex.domain.PizzaEntity;
import incubator.spring_flex.dto.Pizza;

public interface PizzaMapper {

    PizzaEntity mapToPizzaEntity(Pizza pizza);

    Pizza mapToPizza(PizzaEntity pizzaEntity);
    
}
