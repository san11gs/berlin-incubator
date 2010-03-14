package incubator.spring_flex.mapper;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import incubator.spring_flex.domain.OrderEntity;
import incubator.spring_flex.domain.OrderedDishEntity;
import incubator.spring_flex.dto.Order;
import incubator.spring_flex.dto.OrderedDish;

@Component("orderMapper")
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private OrderedDishMapper orderedDishMapper;

    @Autowired
    private CustomerMapper customerMapper;

    public Order mapToOrder(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setCustomer(this.customerMapper.mapToCustomer(orderEntity.getCustomer()));
        Collection<OrderedDish> orderedDishes = new ArrayList<OrderedDish>();
        for (OrderedDishEntity orderedDishEntity : orderEntity.getOrderedDishes()) {
            orderedDishes.add(this.orderedDishMapper.mapToOrderDish(orderedDishEntity));
        }
        order.setOrderedDishes(orderedDishes);
        return order;
    }

    public OrderEntity mapToOrderEntity(Order order) {
        if (order == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderEntity.getId());
        orderEntity.setCustomer(this.customerMapper.mapToCustomerEntity(order.getCustomer()));
        Collection<OrderedDishEntity> orderedDishes = new ArrayList<OrderedDishEntity>();
        for (OrderedDish orderedDish : order.getOrderedDishes()) {
            orderedDishes.add(this.orderedDishMapper.mapToOrderDishEntity(orderedDish));
        }
        orderEntity.setOrderedDishes(orderedDishes);
        return orderEntity;
    }

}
