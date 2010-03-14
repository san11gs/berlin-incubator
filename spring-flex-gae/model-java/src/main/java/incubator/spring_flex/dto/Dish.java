package incubator.spring_flex.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Dish implements Serializable {

    private String key;

    private String name;

    private double price;

    private Collection<Ingredient> ingredients;
    
    /*
     * Getter & Setter 
     */
    
    public String getKey() {
        
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Collection<Ingredient> getIngredients() {
        if(this.ingredients == null){
            this.ingredients = new ArrayList<Ingredient>();         
        }
        return this.ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

}
