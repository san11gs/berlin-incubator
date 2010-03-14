package incubator.spring_flex.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "dishorder")
@Entity
@NamedQueries({
    @NamedQuery(name = "OrderEntity.loadAll", query = "SELECT o FROM OrderEntity o") 
})
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CustomerEntity customer;

    /**
     * Unidirectional one-to-many association to {@link OrderedDishEntity}.
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<OrderedDishEntity> orderedDishes;

    /*
     * Getter & Setter
     */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return this.customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public Collection<OrderedDishEntity> getOrderedDishes() {
        if (this.orderedDishes == null) {
            this.orderedDishes = new ArrayList<OrderedDishEntity>();
        }
        return this.orderedDishes;
    }

    public void setOrderedDishes(Collection<OrderedDishEntity> dishes) {
        this.orderedDishes = dishes;
    }

    public void addDish(DishEntity dish) {
        OrderedDishEntity orderedDish = new OrderedDishEntity();
        orderedDish.setDish((PizzaEntity)dish);
        
        for(OrderedDishEntity tmp : getOrderedDishes()){
            if(tmp.getDish().getKey().equals(dish.getKey())){
                tmp.setAmount(tmp.getAmount() + 1);
                return;
            }
        }
        
        getOrderedDishes().add(orderedDish);
    }

    public void removePizza(OrderedDishEntity orderedDish) {
        
        OrderedDishEntity toRemove = null;
        
        for(OrderedDishEntity tmp : getOrderedDishes()){
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
