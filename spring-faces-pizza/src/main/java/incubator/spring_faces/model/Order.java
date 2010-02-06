package incubator.spring_faces.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class implementing an order entity. <br/>
 * We must use a table name different from 'order' as this key reserved by SQL.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Table(name = "pizzaorder")
@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Customer customer;

    /**
     * Unidirectional one-to-many association to {@link Pizza}.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "pizzaorder_orderedpizza", 
            joinColumns = { @JoinColumn(name = "fid_order", nullable = false) }, 
            inverseJoinColumns = { @JoinColumn(name = "fid_orderedpizza", nullable = false) })
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
