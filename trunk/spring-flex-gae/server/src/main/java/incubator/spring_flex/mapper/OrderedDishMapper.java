package incubator.spring_flex.mapper;

import incubator.spring_flex.domain.OrderedDishEntity;
import incubator.spring_flex.dto.OrderedDish;

public interface OrderedDishMapper {

    OrderedDishEntity mapToOrderDishEntity(OrderedDish orderedDish);

    OrderedDish mapToOrderDish(OrderedDishEntity orderedDishEntity);

}
