package incubator.spring_flex.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Order implements Serializable {

    private Long id;

    private Customer customer;

    private Collection<OrderedDish> orderedDishes;

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

    public Collection<OrderedDish> getOrderedDishes() {
        if (this.orderedDishes == null) {
            this.orderedDishes = new ArrayList<OrderedDish>();
        }
        return this.orderedDishes;
    }

    public void setOrderedDishes(Collection<OrderedDish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public void addDish(Dish dish) {
        OrderedDish orderedDish = new OrderedDish();
        orderedDish.setDish(dish);
        
        for(OrderedDish tmp : getOrderedDishes()){
            if(tmp.getDish().getKey().equals(dish.getKey())){
                tmp.setAmount(tmp.getAmount() + 1);
                return;
            }
        }
        
        getOrderedDishes().add(orderedDish);
    }

    public void removePizza(OrderedDish orderedDish) {
        
        OrderedDish toRemove = null;
        
        for(OrderedDish tmp : getOrderedDishes()){
            if(tmp.getDish().getKey().equals(orderedDish.getDish().getKey())){
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
        getOrderedDishes().remove(toRemove);
    }
}
