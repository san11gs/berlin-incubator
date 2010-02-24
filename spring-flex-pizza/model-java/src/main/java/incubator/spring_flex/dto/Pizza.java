package incubator.spring_flex.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

/**
 * Class implementing a pizza entity.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
public class Pizza implements Serializable {

    private Long id;

    private String name;

    private double price;

    /**
     * Unidirectional ont-to-many association to {@link Topping}.
     */
    private Set<Topping> toppings;

    /*
     * getter & setter
     */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Topping> getToppings() {
        if (this.toppings == null) {
            return Collections.emptySet();
        }
        return this.toppings;
    }

    public void setToppings(Set<Topping> toppings) {
        this.toppings = toppings;
    }

}
