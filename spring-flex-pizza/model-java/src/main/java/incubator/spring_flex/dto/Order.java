package incubator.spring_flex.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class implementing an order entity. <br/>
 * We must use a table name different from 'order' as this key reserved by SQL.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
public class Order implements Serializable {

    private Long id;

    private Customer customer;

    private Collection<OrderedPizza> orderedPizzas;

    /*
     * Getter & Setter
     */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<OrderedPizza> getOrderedPizzas() {
        if (this.orderedPizzas == null) {
            this.orderedPizzas = new ArrayList<OrderedPizza>();
        }
        return this.orderedPizzas;
    }

    public void setOrderedPizzas(Collection<OrderedPizza> pizzas) {
        this.orderedPizzas = pizzas;
    }

    public void addPizza(Pizza pizza) {
        OrderedPizza orderedPizza = new OrderedPizza();
        orderedPizza.setPizza(pizza);
        
        for(OrderedPizza tmp : getOrderedPizzas()){
            if(tmp.getPizza().getId().equals(pizza.getId())){
                tmp.setAmount(tmp.getAmount() + 1);
                return;
            }
        }
        
        getOrderedPizzas().add(orderedPizza);
    }

    public void removePizza(OrderedPizza orderedPizza) {
        
        OrderedPizza toRemove = null;
        
        for(OrderedPizza tmp : getOrderedPizzas()){
            if(tmp.getPizza().getId().equals(orderedPizza.getPizza().getId())){
                int amount = tmp.getAmount() - 1;
                
                if(amount == 0){
                    toRemove = tmp;
                    break;
                } else {
                    tmp.setAmount(amount);
                    return;
                }
            }
        }
        getOrderedPizzas().remove(toRemove);
    }
}
