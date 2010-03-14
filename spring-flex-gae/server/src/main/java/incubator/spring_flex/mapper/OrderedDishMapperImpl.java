package incubator.spring_flex.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.appengine.api.datastore.KeyFactory;

import incubator.spring_flex.domain.OrderedDishEntity;
import incubator.spring_flex.domain.PizzaEntity;
import incubator.spring_flex.dto.OrderedDish;

@Component("orderedDishMapper")
public class OrderedDishMapperImpl implements OrderedDishMapper {

    @Autowired
    private DishMapper dishMapper;

    public OrderedDish mapToOrderDish(OrderedDishEntity orderedDishEntity) {
        if (orderedDishEntity == null) {
            return null;
        }
        OrderedDish orderedDish = new OrderedDish();
        orderedDish.setId(KeyFactory.keyToString(orderedDishEntity.getId()));
        orderedDish.setAmount(orderedDishEntity.getAmount());
        orderedDish.setDish(this.dishMapper.mapToDish(orderedDishEntity.getDish()));
        return orderedDish;
    }

    public OrderedDishEntity mapToOrderDishEntity(OrderedDish orderedDish) {
        if (orderedDish == null) {
            return null;
        }
        OrderedDishEntity orderedDishEntity = new OrderedDishEntity();
        if(orderedDish.getId() != null){
            orderedDishEntity.setId(KeyFactory.stringToKey(orderedDish.getId()));
        }
        orderedDishEntity.setAmount(orderedDish.getAmount());
        orderedDishEntity.setDish((PizzaEntity)this.dishMapper.mapToDishEntity(orderedDish.getDish()));
        return orderedDishEntity;
    }

}
