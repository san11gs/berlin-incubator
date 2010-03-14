package incubator.spring_flex.dto;

import incubator.spring_flex.dto.enums.PizzaType;

public class Pizza extends Dish {

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
