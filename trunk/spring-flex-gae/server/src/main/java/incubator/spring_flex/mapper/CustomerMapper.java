package incubator.spring_flex.mapper;

import incubator.spring_flex.domain.CustomerEntity;
import incubator.spring_flex.dto.Customer;

public interface CustomerMapper {

    CustomerEntity mapToCustomerEntity(Customer customer);

    Customer mapToCustomer(CustomerEntity customerEntity);
    
}
