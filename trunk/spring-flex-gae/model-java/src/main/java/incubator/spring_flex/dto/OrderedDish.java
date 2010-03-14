package incubator.spring_flex.dto;

import java.io.Serializable;

public class OrderedDish implements Serializable {

    private String id;

    private Dish dish;

    private int amount = 1;

    /*
     * getter & setter
     */

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dish getDish() {
        return this.dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
