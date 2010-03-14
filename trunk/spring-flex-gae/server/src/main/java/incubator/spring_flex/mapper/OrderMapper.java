package incubator.spring_flex.mapper;

import incubator.spring_flex.domain.OrderEntity;
import incubator.spring_flex.dto.Order;

public interface OrderMapper {

    OrderEntity mapToOrderEntity(Order order);

    Order mapToOrder(OrderEntity orderEntity);

}
