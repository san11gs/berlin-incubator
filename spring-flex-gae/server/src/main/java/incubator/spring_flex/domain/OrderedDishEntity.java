package incubator.spring_flex.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;

@Table(name = "orderedpizza")
@Entity
public class OrderedDishEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key id;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PizzaEntity dish;

    private int amount = 1;

    /*
     * getter & setter
     */

    public Key getId() {
        return this.id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public PizzaEntity getDish() {
        return this.dish;
    }

    public void setDish(PizzaEntity dish) {
        this.dish = dish;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
