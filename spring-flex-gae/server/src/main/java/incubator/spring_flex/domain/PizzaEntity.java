package incubator.spring_flex.domain;

import incubator.spring_flex.dto.enums.PizzaType;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "pizza")
@Entity
@NamedQueries({
    @NamedQuery(name = "PizzaEntity.loadAll", query = "SELECT p FROM PizzaEntity p") 
})
public class PizzaEntity extends DishEntity {

    private PizzaType pizzaType = PizzaType.CLASSIC;

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        if(pizzaType != null){
            this.pizzaType = pizzaType;
        }
    }
    
}
